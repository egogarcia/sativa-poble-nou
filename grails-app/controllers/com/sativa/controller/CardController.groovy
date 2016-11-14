package com.sativa.controller

import static com.sativa.enums.CardStatusEnum.CARD_STATUS__CANCELLED
import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Card
import com.sativa.domain.Partner





@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class CardController  {
	def eventService

	def memberService
	
	def dispatcher(String num_tarjeta, String error){
		def card = Card.findByCode(num_tarjeta)
		if (!card || card?.status == CARD_STATUS__CANCELLED) {	
			def listMembers = memberService.list("firstname")
			render(view: "/sativaTemplate/createMember", model: [error:error, listMembers:listMembers, numCard:num_tarjeta])
		}
		else {
			redirect(controller: "member", action: "show", params:[memberId:card.member.id])	
		}	
		
	}


}