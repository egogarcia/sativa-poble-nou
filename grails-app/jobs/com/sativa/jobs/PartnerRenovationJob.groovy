package com.sativa.jobs

import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__DETOXIFIED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__ACTIVED
import static com.sativa.enums.PartnerStatusEnum.PARTNER_STATUS__UNKNOWN

import groovy.time.TimeCategory

import com.sativa.domain.Partner
import com.sativa.domain.GeneticOrders


class PartnerRenovationJob {
	
	
    	
    static triggers = {
		// Execucio cada  hora al minuto 1 al  segon 30
		cron name:'partnerRenovationJob', cronExpression: '30 1 0/1 * * ?' 
    }
	
	def execute() {
		log.info "startpartnerrenovation"
		Date maxDetoxified = new Date()
	    use(TimeCategory){
	      maxDetoxified = maxDetoxified - 3.month
	    }

		def partners = Partner.createCriteria().list {
	      or{
	            eq "status", PARTNER_STATUS__ACTIVED
	      		eq "status", PARTNER_STATUS__UNKNOWN
	          }
		}

	    partners.each {Partner p ->
			
	        def order = GeneticOrders.createCriteria().get {
				eq "partner", p
	          	 projections {
	                max "dateCreated"
	            }
	        }
			
		    if (!order) {
		        if (p.dateCreated < maxDetoxified) {
		         	 p.status = PARTNER_STATUS__DETOXIFIED
		          	 p.save(flush:true)
		        }
		    }
		    else {
		        if (order < maxDetoxified) {
		         	 p.status = PARTNER_STATUS__DETOXIFIED
		          	 p.save(flush:true)
		        }
		    }
   		}
	}
}



