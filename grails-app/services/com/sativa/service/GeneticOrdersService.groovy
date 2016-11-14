package com.sativa.service
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DETOXIFIED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__ACTIVED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__UNKNOWN
import  static com.sativa.enums.EventTypeEnum.EVENT_TYPE__BUY
import grails.transaction.Transactional

import com.sativa.domain.Partner
import com.sativa.domain.Genetic 
import com.sativa.domain.GeneticOrders

import com.sativa.utils.ImageUtils

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class GeneticOrdersService {

	def eventService
	def grailsApplication


	@Transactional
	def create ( Partner partner, Genetic genetic, Long amount, String signature) {
		GeneticOrders go = new GeneticOrders()
		go.amount  = amount 
		go.partner = partner
		go.genetic = genetic
		go.save(flush:true)

		if (partner.status == PARTNER_STATUS__DETOXIFIED) {
			if (!partner.firstname || !partner.image || !partner.lastname || !partner.address || !partner.identificationNumber || !partner.phone) {
    			partner.status = PARTNER_STATUS__UNKNOWN
	    	}
	    	else if (partner.firstname && partner.image && partner.lastname && partner.address && partner.identificationNumber && partner.phone) {
	    		partner.status = PARTNER_STATUS__ACTIVED
	    	}
	    	partner.save(flush:true)
		}

	
    	BufferedImage newImg = ImageUtils.decodeToImage(signature)
        ImageIO.write(newImg, "jpg", new File("/usr/sativaImages/firmas/"+go.id+".png"))		
	
	}


	@Transactional
	def grams (Partner partner) {
		def auxStart = new Date()
		def startAnual  = Calendar.instance
		def endAnual    = new Date()
		def start = Calendar.instance
		def end   = Calendar.instance


		startAnual.set(year:auxStart.getAt(Calendar.YEAR)-1, month: 11, date:  31, hourOfDay:24, minute:00, second:0)
		startAnual = startAnual.getTime()
	
		
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date:  0, hourOfDay:24, minute:00, second:0)
		start = start.getTime()
		end.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: 1, hourOfDay:24, minute:0, second:0)
		end.set(date:end.getActualMaximum( Calendar.DATE))
		end   = end.getTime()


		def listGenetics =  GeneticOrders.createCriteria().list {
			between "dateCreated", startAnual, endAnual
			eq "partner", partner
		}

		def countGrams = 0
		def countAnualGrams = 0


		listGenetics.each { go->
			if (go.dateCreated >= start && go.dateCreated <= end){
				countGrams 		+= go.genetic.type.grams*go.amount
			}
			countAnualGrams += go.genetic.type.grams*go.amount
		}

		return ["monthly":countGrams, "anualy":countAnualGrams]
	}

	@Transactional
	def listGenetics (Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: auxStart.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:auxEnd.getAt(Calendar.YEAR), month: auxEnd.getAt(Calendar.MONTH), date: auxEnd.getAt(Calendar.DATE), hourOfDay:24, minute:0, second:0)
		end   = end.getTime()
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			 projections{
            	groupProperty("genetic")
            	sum("amount")
        	}
		}
	}

	@Transactional
	def listPeriodicsPerDay (Date auxStart, Date auxEnd) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:auxStart.getAt(Calendar.YEAR), month: auxStart.getAt(Calendar.MONTH), date: auxStart.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end.set(year:auxEnd.getAt(Calendar.YEAR), month: auxEnd.getAt(Calendar.MONTH), date: auxEnd.getAt(Calendar.DATE), hourOfDay:24, minute:0, second:0)
		end   = end.getTime()
		def listGroupBy = GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
			 projections{
			 	groupProperty("partner")
			 	groupProperty("genetic")
            	sum("amount")
        	}
		}

		def results = []
		def countGrams = 0;
		for (int i = 0; i < listGroupBy.size(); i++) {
		  if (i>0 && listGroupBy[i][0] == listGroupBy[i-1][0]) {
		   		countGrams += listGroupBy[i][1].type.grams*listGroupBy[i][2]	    
		    	if (i == listGroupBy.size()-1) {
		      		results.push("partner":listGroupBy[i-1][0], "grams":countGrams)
		    	}
		  }
		  else {
		    if (i>0){
		      results.push("partner":listGroupBy[i-1][0], "grams":countGrams)
		    }
		     countGrams = listGroupBy[i][1].type.grams*listGroupBy[i][2]      
		   	 if (i == listGroupBy.size()-1) {
		      		results.push("partner":listGroupBy[i][0], "grams":countGrams)
		    }
		   
		  }
		  
		}
		results = results.sort{it.grams}.reverse()
		return results

	}


	@Transactional
	def list(Date currentDay) {
		def start = Calendar.instance
		def end = Calendar.instance
		start.set(year:currentDay.getAt(Calendar.YEAR), month: currentDay.getAt(Calendar.MONTH), date: currentDay.getAt(Calendar.DATE), hourOfDay:0, minute:0, second:0)
		start = start.getTime()
		end   = start + 1
		return GeneticOrders.createCriteria().list {
			between "dateCreated", start, end
		}
	}



}