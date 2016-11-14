package com.sativa.domain

import static com.sativa.enums.GeneticStatusEnum.GENETIC_STATUS__ENABLED

import com.sativa.enums.GeneticStatusEnum

class GeneticType {

	Long   				id
	String 				name
	BigDecimal			price
	BigDecimal			grams
	String 				color


	static constraints = {
		
	}
	
}
