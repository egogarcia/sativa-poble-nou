package com.sativa.domain

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__ENABLED

import com.sativa.enums.GeneticStatusEnum

class GeneticOrders {
	Date 				dateCreated
	Long				amount
	Partner				partner 
	Genetic 			genetic
	
	static constraints = {
		
	}
	
}
