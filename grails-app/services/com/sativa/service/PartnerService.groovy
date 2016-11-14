package com.sativa.service


import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.PartnerRole
import com.sativa.domain.Role

class PartnerService {


	@Transactional(readOnly = true)
	def list () {
		def users = PartnerRole.createCriteria().list(){
			eq "role", Role.findByAuthority(Role.ROLE_SELLER)
			projections {
				distinct "partner.id"
			}
		}
		return Partner.createCriteria().list{
			'in' 'id', users
		}
	}

	@Transactional
	def add(String username, String password, Partner partner){
		partner.username = username 
		partner.password = password
		PartnerRole.create(partner, Role.findByAuthority(Role.ROLE_SELLER), true)
		partner.save(flush:true)
		partner.encodePassword()
	}

	@Transactional
	def remove(Partner partner){
		PartnerRole.remove(partner, Role.findByAuthority(Role.ROLE_SELLER), true)
		partner.save(flush:true)
	}
}