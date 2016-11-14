package com.sativa.controller
import static com.sativa.enums.CardStatusEnum.*

import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Partner

	

import com.sativa.exception.NotFoundException




@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class PartnerController  {
	def partnerService
	def memberService

	def list() {
		def listPartners = partnerService.list()
		def listMembers  = memberService.list2("firstname")
		render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners, listMembers:listMembers])
	}
	

	def add(String username, String password, String repeatPassword, Long partnerId) {
		
		if (username && password && repeatPassword && partnerId){
			if (password != repeatPassword) {
				render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners, error:"Los passwords deben ser iguales"])		
				return
			}
			Partner partner = Partner.read(partnerId)
			partnerService.add(username, password, partner)
			def listPartners = partnerService.list()
			def listMembers  = memberService.list2("firstname")
			render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners,listMembers:listMembers])
		}
		else {
			def listPartners = partnerService.list()
			def listMembers  = memberService.list2("firstname")
			render(view: "/sativaTemplate/searchPartners", model: [error:"Faltan datos", listPartners:listPartners,listMembers:listMembers])
		}
	}

	def remove (Long partnerId) {
		Partner partner = Partner.read(partnerId)
		partnerService.remove(partner)
		def listPartners = partnerService.list()
		def listMembers  = memberService.list2("firstname")
		render(view: "/sativaTemplate/searchPartners", model: [listPartners:listPartners,listMembers:listMembers])
	}

	def isFull(Long id){
		Partner partner = Partner.read(id)
		def hasCard = partner.cards?true:false
		if (!partner.firstname || !partner.image || !partner.lastname || !partner.address || !hasCard || !partner.identificationNumber || !partner.phone) {
			render("false")
			return
		}	
		render("true")
		return
	}

}