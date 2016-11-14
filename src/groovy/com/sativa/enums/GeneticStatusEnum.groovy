package com.sativa.enums


enum GeneticStatusEnum {
	GENETIC_STATUS__ENABLED		(100, "geneticStatusEnum.enabled"),
	GENETIC_STATUS__DISABLED 	(200, "geneticStatusEnum.disabled"),
	GENETIC_STATUS__REMOVED 	(300, "geneticStatusEnum.removed")
	
	
	final int id
	final String name

	private GeneticStatusEnum(int id, String name) {
		this.id = id
		this.name = name
	}

	String toString() {
		name
	}
	
	
	static List getJson() {
		return GeneticStatusEnum.values().collect{ return ["key":it.name(), "value":it.name] }
	}
}
