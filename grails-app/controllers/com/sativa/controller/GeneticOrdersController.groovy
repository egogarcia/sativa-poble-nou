package com.sativa.controller


import grails.plugin.springsecurity.annotation.Secured
import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__BUY

import com.sativa.domain.Genetic
import com.sativa.domain.Partner
import java.text.SimpleDateFormat
import java.text.DateFormat



@Secured(['ROLE_ADMIN', 'ROLE_SELLER'])
class GeneticOrdersController  {
	def geneticOrdersService
	def geneticHistoricService
	def geneticService
	def eventService

	def create(Long memberId, String listGenetics, String listAmount, String signature){
		Partner partner = Partner.get(memberId)
		def genetics = listGenetics.split(',')
		def amounts = listAmount.split(',')
		def numGrams = 0
		def error = ""
		def stringEvent = ""
		
		def auxGrams = geneticOrdersService.grams(partner)

		genetics.eachWithIndex { gen, index ->
			def genetic 	= Genetic.get(gen)
			def amount 		= amounts[index] as Long
			numGrams += genetic.type.grams*amount
		}
		
		if ((auxGrams.monthly+numGrams) > 90){
			error = "Has sobrepasado los gramos máximos"
		}
		else {
			genetics.eachWithIndex { gen, index ->
				def genetic 	= Genetic.get(gen)
				def amount 		= amounts[index] as Long
				stringEvent += amount+" de "+genetic.name
				if (index != genetics.size()-1)  {
					stringEvent += ', '
				}
				
				geneticOrdersService.create(partner, genetic, amount, signature)	
			}
			stringEvent += ' ('+numGrams+'gr)'
			eventService.create("Ha retirado un total de "+stringEvent, partner, EVENT_TYPE__BUY)
		}
		
		if (error != "") render error 
		else render "success"
	}


	def periodic(String start, String end){
		Date auxStart = Date.fromISO(start)
		Date auxEnd   = Date.fromISO(end )
		if (!auxStart) {
			auxStart  = new Date()-30
		}
		if (!auxEnd) {
			auxEnd    = new Date()
		}

		if (auxEnd < auxStart) {
			auxEnd = auxStart
		}
		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay(auxStart, auxEnd)

		def totalPerPeriod = stadisticsPerPeriod.grams.sum()

		render(view: "/sativaTemplate/stadistics", model: [page:"periodic", totalPerPeriod:totalPerPeriod, stadisticsPerPeriod:stadisticsPerPeriod, daySelected:new Date() ,start:auxStart, end:auxEnd])
	}



	def genetics(String start, String end){
		Date auxStart = Date.fromISO(start)
		Date auxEnd   = Date.fromISO(end )
		if (!auxStart) {
			auxStart  = new Date()-30
		}
		if (!auxEnd) {
			auxEnd    = new Date()
		}

		if (auxEnd < auxStart) {
			auxEnd = auxStart
		}
		def listGenetics 	 = geneticOrdersService.listGenetics(auxStart, auxEnd)
		listGenetics		 = listGenetics.collect {go ->
					return ["name"  : go[0],
							"amount": go[1]]
		}

		def totalBuys  = listGenetics.amount.sum()
		def totalGrams =  0
		listGenetics.each {
			totalGrams += it.name.type.grams * it.amount
		}

		def graph =geneticHistoricService.graph(auxStart, auxEnd)
		graph = graph.sort{it.ratio}.reverse()

		render(view: "/sativaTemplate/stadistics", model: [page:"genetics", graph:graph, totalGrams:totalGrams, totalBuys:totalBuys,  listGenetics:listGenetics, daySelected:new Date() ,start:auxStart, end:auxEnd])
	}

	def day(String currentDate){
		Date auxDate
		if (!currentDate){
			auxDate = new Date()
		}
		else auxDate = Date.fromISO(currentDate)
		
		def stadisticsPerDay 	 = geneticOrdersService.list(auxDate)

		render(view: "/sativaTemplate/stadistics", model: [stadisticsPerDay:stadisticsPerDay, daySelected:auxDate])
	}

	def stadistics() {
		Date auxDate    = new Date() - 30
		Date auxEndDate = new Date() 
		def stadisticsPerDay 	 = geneticOrdersService.list(auxEndDate)
		def listGenetics 	 = geneticOrdersService.listGenetics(auxDate, auxEndDate)
		listGenetics		 = listGenetics.collect {go ->
					return ["name"  : go[0],
							"amount": go[1]]
		}.sort{it.amount}

		def stadisticsPerPeriod = geneticOrdersService.listPeriodicsPerDay(auxDate, auxEndDate)
		stadisticsPerPeriod = stadisticsPerPeriod.collect { go ->
				return [ "partner": go[0],
						 "amount" : go[1] ]
		}.sort{it.amount}
	
		
		render(view: "/sativaTemplate/stadistics", model: [ stadisticsPerDay:stadisticsPerDay, daySelected:auxEndDate, listGenetics:listGenetics, stadisticsPerPeriod:stadisticsPerPeriod, start:auxDate, end:auxEndDate])
	}


}