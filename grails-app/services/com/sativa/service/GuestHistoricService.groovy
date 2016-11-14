package com.sativa.service
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__INVITE

import com.sativa.domain.Partner
import com.sativa.domain.GuestHistoric


import grails.transaction.Transactional
class GuestHistoricService {
	
	@Transactional
	def add (Partner guest, Partner friend) {
		GuestHistoric gh = new GuestHistoric()
		gh.guest 	= guest
		gh.entry    = new Date()
		gh.friend   = friend
		gh.numberEntries = this.numberInvitations(guest)
		gh.save(flush:true)


	}

	@Transactional
	def historic (Integer offset){
		if (!offset || offset==1){
			offset = 0
		}
		
		println "hito "+offset
		def ghList = GuestHistoric.createCriteria().list([max:50, offset:offset]) {
			order("entry", "desc")
			cache false
		}
		return ghList

	}


	def searchInvitate (String firstname, String lastname, String identificationNumber) {
		return GuestHistoric.createCriteria().list {
			guest {
				order("code", "asc")
				and {
					or {
						if (firstname){
							ilike 'firstname', "%${firstname}%"
						}
						if (lastname){
							ilike 'lastname', "%${lastname}%"
						}
						if (identificationNumber){
							ilike 'identificationNumber', "%${identificationNumber}%"
						}
					}
					eq "status", PARTNER_STATUS__INVITE
				}
			}
			
		}
	}

	@Transactional
	def numberInvitations (Partner guest ) {
		def ghList = GuestHistoric.createCriteria().list {
			eq "guest", guest
			order("id", "asc")
		}
		if (ghList && !ghList.isEmpty()){
			return ghList.last().numberEntries+1
		}
		else return 1
	}

	@Transactional
	def lastFriend(Partner guest) {
		def ghList = GuestHistoric.createCriteria().list {
			eq "guest", guest
			order("id", "asc")
		}?.last().friend
	}
}