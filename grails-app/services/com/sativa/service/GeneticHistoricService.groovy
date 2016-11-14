package com.sativa.service

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__REMOVED
import com.sativa.domain.GeneticHistoric
import com.sativa.domain.GeneticOrders
import com.sativa.domain.Genetic

import groovy.time.TimeCategory

import grails.transaction.Transactional
class GeneticHistoricService {
	
	def geneticOrdersService

	@Transactional
	def enabled (Genetic genetic) {
		GeneticHistoric gh = new GeneticHistoric()
		gh.genetic 		   = genetic
		gh.active		   = true
		gh.changeDate		   = new Date()
		gh.save(flush:true)
	}

	@Transactional
	def disabled (Genetic genetic) {
		GeneticHistoric gh = new GeneticHistoric()
		gh.genetic 		   = genetic
		gh.active		   = false
		gh.changeDate		   = new Date()
		gh.save(flush:true)
	}

	def graph(Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: auxStart.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:auxEnd.getAt(Calendar.YEAR), month: auxEnd.getAt(Calendar.MONTH), date: auxEnd.getAt(Calendar.DATE), hourOfDay:24, minute:0, second:0)
		end   = end.getTime()

		def genetics = Genetic.createCriteria().list {
			ne "status", GENETIC_STATUS__REMOVED
		}

		def listGraph = []

		genetics.each {Genetic g->
			def count  = this.numberOfDays(g, start, end)
			def genSum = GeneticOrders.createCriteria().list {
				between "dateCreated", start, end
				eq "genetic", g
				 projections{
	            	sum("amount")
	        	}
			}	
			int sum = genSum.first()?:0
			int ratiopedro = 0
			if (count != 0) ratiopedro = sum/count
			if (ratiopedro  != 0){
				listGraph.push(["name":g.name, "buys":sum, "days": count, "ratio":ratiopedro])
			}
		}
		return listGraph	
		
	}


	@Transactional
	def numberOfDays (Genetic genetic, Date start, Date end) {
		def numberOfDays = 0;
		use(TimeCategory) {
		   numberOfDays = (end-start).days
		}
		def auxStart = start
		def auxEnd   = end  
		def count = 0;
		for (int j = 0; j < numberOfDays; j++) {
			def countSeconds
			use(TimeCategory){
				auxEnd = auxStart + 1	
			}
			def listGH = GeneticHistoric.createCriteria().list {
					eq "genetic", genetic
					ge "changeDate", start
					le "changeDate", auxEnd
			}

			if (listGH.size() == 0){
				def lastGH = GeneticHistoric.createCriteria().list {
					eq "genetic", genetic
					order ("changeDate", "desc")
				}?.first();
				def aux2
				use(TimeCategory){
					 aux2 = lastGH.changeDate - auxStart
				}
				countSeconds = (aux2.days*24*60*60) + (aux2.hours*60*60) + (aux2.minutes*60) + aux2.seconds
				if (countSeconds > 12*60*60){
					count++
				}

			}
			else if (listGH.size() == 1 && listGH.first().active) {
				def aux2
				use(TimeCategory){
					 aux2 = listGH.first().changeDate - auxStart
				}
				countSeconds = (aux2.days*24*60*60) + (aux2.hours*60*60) + (aux2.minutes*60) + aux2.seconds
				if (countSeconds > 12*60*60){
					count++
				}
			}
			else {
				for (int i = 0; i < listGH.size()-1; i++){
					def aux
					if(listGH[i].active && !listGH[i+1].active){
						use(TimeCategory){
							aux = listGH[i+1].changeDate - auxStart
						}
					}
					else if (listGH[i+1].active && (i+1) == (listGH.size()-1)){
						use(TimeCategory){
							aux = auxEnd- listGH[i+1].changeDate
						}
					}
					 
					if (aux) {
						use(TimeCategory){
							countSeconds = (aux.days*24*60*60) + (aux.hours*60*60) + (aux.minutes*60) + aux.seconds
							if (countSeconds > 12*60*60){
								count++
							}
						}
					}
				}
			}
			auxStart = auxEnd
		}
		return count	
	}



}
