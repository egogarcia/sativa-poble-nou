package com.sativa.service

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__ENABLED
import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__DISABLED
import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__REMOVED

import com.sativa.enums.GeneticStatusEnum
import grails.transaction.Transactional

import com.sativa.domain.Genetic
import com.sativa.domain.GeneticType

class GeneticService {

	def geneticHistoricService
	
	
	@Transactional(readOnly = true)
	def list () {
		return Genetic.createCriteria().list {
			ne "status", GENETIC_STATUS__REMOVED
			order "name", "asc"

		}
	}

	@Transactional(readOnly = true)
	def listTypes () {
		return GeneticType.createCriteria().list {}
	}

	

	def active () {
		return Genetic.createCriteria().list {
			eq "status", GENETIC_STATUS__ENABLED
		}
	}

	@Transactional
	def create (String name, GeneticType type) {
		Genetic genetic = new Genetic()
		genetic.name    = name
		genetic.type	= type
		genetic.save(flush:true)
		geneticHistoricService.enabled(genetic)


	}

	@Transactional
	def enabled (Genetic genetic) {
		genetic.status  = GENETIC_STATUS__ENABLED
		genetic.save(flush:true)
		geneticHistoricService.enabled(genetic)
	}

	@Transactional
	def disabled (Genetic genetic) {
		genetic.status  = GENETIC_STATUS__DISABLED
		genetic.save(flush:true)
		geneticHistoricService.disabled(genetic)
	}

	@Transactional
	def remove (Genetic genetic) {
		genetic.status = GENETIC_STATUS__REMOVED
		genetic.save(flush:true)
		geneticHistoricService.disabled(genetic)
	}

	@Transactional
	def graph () {
		
	}



}
