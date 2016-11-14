package com.sativa.domain

import static com.sativa.enums.TypeConsumEnum.CONSUM_LUDIC

import com.sativa.enums.PartnerStatusEnum
import com.sativa.enums.TypeConsumEnum


class Partner {
	def guestHistoricService

	transient springSecurityService
	Long   				id
	String 				username
	String 				password
	boolean 			enabled = true
	boolean 			accountExpired
	boolean 			accountLocked
	boolean 			passwordExpired
	Date    			dateCreated
	Date                dateRenovation = new Date()
	String 				code
	String 				phone 
	String  			firstname
	String 	    	    lastname
	String  			address
	String 				image 
	String				signature
	String  			identificationNumber
	PartnerStatusEnum   status 
	Partner             friend 
	Date  				birthday
	TypeConsumEnum		consum = CONSUM_LUDIC
	Long 				numInvitations = 0


	static transients = ['springSecurityService']

	static constraints = {
		username  			 nullable:true
		password  			 nullable:true
		code 	  			 nullable:true
		phone 	  			 nullable:true
		lastname  			 nullable:true
		address   			 nullable:true
		signature			 nullable:true
		image 	  			 nullable:true
		friend 				 nullable:true
	}

	static mapping = {
		password column: '`password`'
	}

	static hasMany = [
		cards  : Card,
		events 	: Event
	]

	Set<Role> getAuthorities() {
		PartnerRole.findAllByPartner(this).collect { it.role }
	}



	def guestHistoricService() {
		return guestHistoricService.numberInvitations(this)
	}
		
	def lastFriend() {
		return guestHistoricService.lastFriend(this)
	}


	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	
}
