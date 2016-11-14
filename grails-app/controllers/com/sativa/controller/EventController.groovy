package com.sativa.controller

import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__CUSTOM
import grails.plugin.springsecurity.annotation.Secured

import com.sativa.domain.Event
import com.sativa.domain.Partner
import com.sativa.enums.EventTypeEnum




@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class EventController  {
	def eventService


	def create(String observation, Long partnerId, String page) {
		Partner partner = Partner.read(partnerId)
		
		eventService.create(observation, partner, EVENT_TYPE__CUSTOM)
		if (page == "edit") redirect(controller: "member", action: "showEdit", params:[memberId:partnerId])
		else redirect(controller: "member", action: "show", params:[memberId:partnerId])
	}

	def viewed(Long eventId, Long partnerId){
		Event event = Event.get(eventId)
		eventService.viewed(event)
		redirect(controller: "member", action: "show", params:[memberId:partnerId])
	}


	def removed (Long eventId, Long partnerId) {
		Event event = Event.get(eventId)
		eventService.removed(event)
		redirect(controller: "member", action: "show", params:[memberId:partnerId])
	}

}