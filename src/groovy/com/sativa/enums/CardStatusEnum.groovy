package com.sativa.enums


enum CardStatusEnum {
	CARD_STATUS__ACTIVED		(100, "cardStatusEnum.actived"),
	CARD_STATUS__CANCELLED		(200, "cardStatusEnum.cancelled"),
	
	
	final int id
	final String name

	private CardStatusEnum(int id, String name) {
		this.id = id
		this.name = name
	}

	String toString() {
		name
	}
	
	
	static List getJson() {
		return CardStatusEnum.values().collect{ return ["key":it.name(), "value":it.name] }
	}
}
