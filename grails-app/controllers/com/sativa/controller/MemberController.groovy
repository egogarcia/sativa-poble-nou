package com.sativa.controller


import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__BANNED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__ACTIVED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DETOXIFIED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__UNKNOWN



import grails.plugin.springsecurity.annotation.Secured

import com.sativa.utils.ImageUtils

import com.sativa.domain.Partner
import com.sativa.command.DataMemberCommand
import com.sativa.enums.PartnerStatusEnum
import com.sativa.enums.TypeConsumEnum



import com.sativa.exception.NotFoundException
import grails.validation.ValidationException

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.imageio.ImageIO;


@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class MemberController  {
	def memberService
	def geneticService
	def eventService
	def cardService
	def geneticOrdersService
	def guestHistoricService

	def search(String firstname, String lastname, String identificationNumber, String code, Integer offset) {
		def listMembers = memberService.search(firstname, lastname, identificationNumber, code)
		def total = listMembers.size();
		render(view: "/sativaTemplate/searchMembers", model: [listMembers:listMembers, total:total, offset:0])
	}

	def searchInvitate(String firstname, String lastname, String identificationNumber) {
		def listInvitates = guestHistoricService.searchInvitate(firstname, lastname, identificationNumber)
		render(view: "/sativaTemplate/showInvitates", model: [historicGuests:listInvitates])
	}



	def list (Integer offset) {
		offset = offset?:0
		
		def listMembers = memberService.list(null, offset)
		def total = listMembers.totalCount
		render(view: "/sativaTemplate/searchMembers", model: [offset:offset, listMembers:listMembers, total:total])
	}

	def all (String firstname, String lastname, String identificationNumber, String code, Integer offset) {
		offset = offset?:0


		List<PartnerStatusEnum> statusMembers = [];

		List<TypeConsumEnum> typeMembers = [];
		if (params.greenStatus) {
			statusMembers.push("PARTNER_STATUS__ACTIVED")
		}
		if (params.yellowStatus){
			statusMembers.push("PARTNER_STATUS__UNKNOWN")	
		}
		if (params.orangeStatus){
			statusMembers.push("PARTNER_STATUS__DETOXIFIED")	
		}
		if (params.redStatus){
			statusMembers.push("PARTNER_STATUS__BANNED")	
		}

		if (params.ludicStatus){
			typeMembers.push("CONSUM_LUDIC")
		}

		if (params.thrapeuticStatus){
			typeMembers.push("CONSUM_THERAPEUTIC")
		}

		println "all okkkk";
		
		def listMembers = memberService.all(firstname, lastname, identificationNumber, code, offset, statusMembers, typeMembers)

		println "all okkkk2 ";
		render(view: "/sativaTemplate/managementMembers", model: [offset:offset, listMembers:listMembers, statusMembers:statusMembers, typeMemebers:typeMembers])
	}

	def create(DataMemberCommand cpc, Long oldPartner){
		if (!cpc.firstname && !oldPartner){
			if (!cpc.friend) {
				redirect(controller: "card", action: "dispatcher",  params:[num_tarjeta:cpc.codeCard, error:"El nombre es un campo necesario"])
				return	
			}
			else {
				redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend.id, error:"El nombre es un campo necesario"])
				return
			}
		}
		if (!cpc.birthday) {
			if (!cpc.friend) {
				redirect(controller: "card", action: "dispatcher",  params:[num_tarjeta:cpc.codeCard, error:"La fecha de nacimiento es necesaria"])
				return	
			}
			else {
				redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend.id, error:"La fecha de nacimiento es necesaria"])
				return
			}
		}

		def stringBirthday = cpc.birthday.split('-');
		def dateBirthday = new Date(stringBirthday[0] as Integer, (stringBirthday[1] as Integer) - 1, stringBirthday[2] as Integer, 0, 0)
		dateBirthday.set(year:stringBirthday[0] as Integer)
		
		def now = new Date() - 18*365

		if (now < dateBirthday) {
			if (!cpc.friend) {
				redirect(controller: "card", action: "dispatcher",  params:[num_tarjeta:cpc.codeCard, error:"¡¡Es menor de edad!!"])
				return	
			}
			else {
				redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend.id, error:"¡¡Es menor de edad!!"])
				return
			}
		}

		def member
		def error 
		if (oldPartner){
			member = Partner.get(oldPartner)
			cardService.add(member, cpc.codeCard)
			error = member
		}
		else {
			error = memberService.create(cpc)
		}



		if (error &&  !(error instanceof Partner) && !cpc.friend) {
			def listMembers = memberService.list("firstname")
			render(view: "/sativaTemplate/createMember", model: [error:error, listMembers:listMembers, numCard:cpc.codeCard])
		}
		else if (error && !(error instanceof Partner)) redirect(controller: "member", action: "invite",  params:[memberId:cpc.friend?.id, error: error])
		else if (error && (error instanceof Partner)) {
			if (cpc.friend ) redirect(controller: "member", action: "guests")
			else redirect(controller: "member", action: "showEdit",  params:[memberId:error.id, success:"Se ha editado correctamente"])
		}
	}

	def show(Long memberId, String error){
		Partner member = Partner.read(memberId)
		def listGenetics 	  = geneticService.active()
		def listEvents   	  = eventService.list(member)
		def listCustomEvents  = eventService.listCustom(member)
		def notification	  = eventService.notification(member)
		def card  		 	  = cardService.cardActive(member)
		def grams			  = geneticOrdersService.grams(member)
		def yellowCards 	  = eventService.amonished(member)

		def pedro
		try {
			def imageAux		  = ImageIO.read(new File("/usr/sativaImages/partners/"+member.code+".png"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 	ImageIO.write(imageAux, "png", bos);
			byte[] imageBytes	  = bos.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
        	pedro = encoder.encode(imageBytes);
        }catch(all){}
		render(view: "/sativaTemplate/showMember", model: [error:error, yellowCard:yellowCards, imagePerson:pedro, grams:grams, member:member, notification:notification, card:card, listGenetics:listGenetics, listEvents:listEvents, listCustomEvents:listCustomEvents])
	}


	def invite(Long memberId, String error ){
		render (view:"/sativaTemplate/createMember", model:[error:error, memberId:memberId])
	}


	def showEdit (Long memberId, String error){
		Partner member 		  = Partner.read(memberId)
		def listEvents   	  = eventService.list(member)
		def notification 	  = eventService.notification(member)
		def card  		 	  = cardService.cardActive(member)
		def numberInvitations = guestHistoricService.numberInvitations(member)
		def grams			  = geneticOrdersService.grams(member)
		def yellowCards 	  = eventService.amonished(member)
		def pedro
		try {
			def imageAux		  = ImageIO.read(new File("/usr/sativaImages/partners/"+member.code+".png"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 	ImageIO.write(imageAux, "png", bos);
			byte[] imageBytes	  = bos.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
        	pedro = encoder.encode(imageBytes);
        }catch(all){}
		render(view: "/sativaTemplate/editMember", model: [card:card,yellowCard:yellowCards, imagePerson:pedro, grams:grams,  numberInvitations: numberInvitations, notification:notification, member:member,  listEvents:listEvents, error:error])

	}


	def edit (Long memberId, DataMemberCommand cpc){
		Partner member = Partner.get(memberId)

		def stringBirthday = cpc.birthday.split('-');
		def dateBirthday = new Date(stringBirthday[0] as Integer, (stringBirthday[1] as Integer) - 1, stringBirthday[2] as Integer, 0, 0)
		dateBirthday.set(year:stringBirthday[0] as Integer)
		
		def now = new Date() - 18*365

		if (now < dateBirthday) {
			redirect(controller: "member", action: "showEdit",  params:[memberId:memberId, error:"¡¡Es menor de edad!!"])	
			return
		}
		memberService.edit(member, cpc)
		redirect(controller: "member", action: "showEdit",  params:[memberId:memberId])
	}

	def remove(Long memberId, String observation, String page) {
		Partner member = Partner.get(memberId)
		memberService.remove(member, observation)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:memberId])
		else redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def delete(Long memberId, String observation, String page) {
		Partner member = Partner.get(memberId)
		memberService.delete(member, observation)
		def listMembers = memberService.all(null, null, null, null)
		render(view: "/sativaTemplate/managementMembers", model: [listMembers:listMembers])
	}

	def amonished (Long memberId) {
		Partner member = Partner.get(memberId)
		memberService.amonished(member)
		redirect(controller: "member", action: "showEdit",  params:[memberId:memberId])
	}

	def forgiveAmonished (Long memberId, String page) {
		Partner member = Partner.get(memberId)
		memberService.forgiveAmonished(member)
		if (page == "show") redirect(controller: "member", action: "show",  params:[memberId:memberId])
		else redirect(controller: "member", action: "showEdit",  params:[memberId:memberId])
	}

	def activate(Long memberId, String page) {
		Partner member = Partner.get(memberId)
		memberService.activate(member)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:memberId])
		else redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def renovation(Long memberId, String page) {
		Partner member = Partner.get(memberId)
		memberService.renovation(member)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:memberId])
		else redirect(controller: "member", action: "show", params:[memberId:memberId])
	}

	def photo (Long memberId, String image){
		Partner member = Partner.get(memberId)
		memberService.photo(member, image)
		redirect(controller: "member", action: "show", params:[memberId:memberId])
	}


	def guests(Integer offset) {
		offset = offset?:0
		def historicGuests = guestHistoricService.historic(offset)
		def listInvitates = memberService.guests()
		render(view: "/sativaTemplate/showInvitates", model: [offset:offset, historicGuests:historicGuests, listInvitates:listInvitates])
	}
}
