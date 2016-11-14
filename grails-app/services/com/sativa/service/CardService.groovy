package com.sativa.service

import static com.sativa.enums.CardStatusEnum.CARD_STATUS__ACTIVED
import static com.sativa.enums.CardStatusEnum.CARD_STATUS__CANCELLED

import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Card


class CardService {


	@Transactional
	def cardActive (Partner member) {
		return Card.createCriteria().get {
			eq "status", CARD_STATUS__ACTIVED
			eq "member", member
		}
	}


	@Transactional
	def add (Partner member, String code) {
		def oldCard = Card.createCriteria().get {
			eq "status", CARD_STATUS__ACTIVED
			eq "member", member
		}
		if (oldCard) {
			oldCard.status = CARD_STATUS__CANCELLED
			oldCard.save()
		}
		Card card   = new Card()
		card.code   = code
		card.member = member
		card.save()
	}


}