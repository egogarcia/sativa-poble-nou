package com.sativa.enums


enum TypeConsumEnum {
	CONSUM_THERAPEUTIC	(100, "typeConsumEnum.therapeutic"),
	CONSUM_LUDIC 		(200, "typeConsumEnum.ludic")



	final int id
	final String name

	private TypeConsumEnum(int id, String name) {
		this.id = id
		this.name = name
	}

	String toString() {
		name
	}
	
	String getHumanName() {
		if (this == CONSUM_THERAPEUTIC) return "Terapéutico"
		else if (this == CONSUM_LUDIC) return "Lúdico"
	}

	static List getJson() {
		return TypeConsumEnum.values().collect{ return ["key":it.name(), "value":it.name] }
	}
}
