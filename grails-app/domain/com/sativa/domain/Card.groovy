package com.sativa.domain

import static com.sativa.enums.CardStatusEnum.CARD_STATUS__ACTIVED

import com.sativa.enums.CardStatusEnum

class Card {

	Long   				id
	String 				code
	CardStatusEnum   	status        = CARD_STATUS__ACTIVED


	static constraints = {
		
	}

	static belongsTo 	= [member	: Partner]

	
}
