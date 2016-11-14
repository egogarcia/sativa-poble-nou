package com.sativa.enums


enum PartnerStatusEnum {
	PARTNER_STATUS__ACTIVED		(100, "partnerStatusEnum.actived"),
	PARTNER_STATUS__DISABLED 	(200, "partnerStatusEnum.disabled"),
	PARTNER_STATUS__BANNED 		(300, "partnerStatusEnum.banned"),    
	PARTNER_STATUS__DETOXIFIED	(400, "partnerStatusEnum.detoxified"),
	PARTNER_STATUS__UNKNOWN		(500, "partnerStatusEnum.detoxified"),
	PARTNER_STATUS__INVITE		(600, "partnerStatusEnum.invite"),
	PARTNER_STATUS__REMOVED		(700, "partnerStatusEnum.removed")

	//ACTIVED -> Green --> All is correct
	//DISABLED -> Red --> Must renew
	//BANNED   -> Red --> Banned of the system
	//DETOXIFIED -> Orange --> More than a year without consume
	//UNKNOWN	-> Yellow --> Missing user data


	final int id
	final String name

	private PartnerStatusEnum(int id, String name) {
		this.id = id
		this.name = name
	}

	String toString() {
		name
	}
	
	
	static List getJson() {
		return PartnerStatusEnum.values().collect{ return ["key":it.name(), "value":it.name] }
	}
}
