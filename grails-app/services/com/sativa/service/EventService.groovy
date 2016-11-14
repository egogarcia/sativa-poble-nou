package com.sativa.service
import static com.sativa.enums.EventTypeEnum.EVENT_TYPE__CUSTOM
import static com.sativa.enums.EventTypeEnum.EVENT_TYPE__REMOVED
import static com.sativa.enums.EventTypeEnum.EVENT_TYPE__AMONISHED
import static com.sativa.enums.EventTypeEnum.EVENT_TYPE__AMONISHED_FORGIVE



import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Event

import com.sativa.enums.EventTypeEnum
class EventService {

	def springSecurityService
	
	@Transactional(readOnly = true)
	def list (Partner partner) {
		return Event.createCriteria().list {
			eq "member", partner
			order("dateCreated", "desc")
			ne "type", EVENT_TYPE__REMOVED
		}
	}

	@Transactional(readOnly = true)
	def listCustom (Partner partner) {
		return Event.createCriteria().list {
			eq "member", partner
			eq "type", EVENT_TYPE__CUSTOM
			 maxResults(4)
			order("dateCreated", "desc")
			ne "type", EVENT_TYPE__REMOVED
		}
	}


	@Transactional
	def amonished (Partner partner) {
		def countAmonished = Event.createCriteria().count {
					eq "member", partner
					eq "type", EVENT_TYPE__AMONISHED
			}
		def countForgiveAmonished = Event.createCriteria().count {
					eq "member", partner
					eq "type", EVENT_TYPE__AMONISHED_FORGIVE
			}

		def countTotal = countAmonished-countForgiveAmonished
		countTotal = countTotal<0?0:countTotal

		return countTotal
	}


	@Transactional
	def create (String observation, Partner partner, EventTypeEnum type) {
		Event event 		 = new Event()
		event.writer 		 = springSecurityService.currentUser.username
		event.observation	 = observation
		event.member		 = partner 
		event.type			 = type
		event.save(flush:true)
	}

	@Transactional(readOnly = true)
	def notification (Partner partner) {
		def listNotifications = Event.createCriteria().list {
			eq "member", partner
			eq "type",EVENT_TYPE__CUSTOM
			eq "viewed", false
			order("dateCreated", "desc")
		}

		if (!listNotifications.isEmpty()) {
			return listNotifications.first()
		}
		return null
	}


	@Transactional
	def viewed (Event event) {
		event.viewed=true
		event.save(flush:true)
	}

	@Transactional
	def removed (Event event) {
		event.type=EVENT_TYPE__REMOVED
		event.save(flush:true)
	}


}