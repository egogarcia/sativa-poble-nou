package com.sativa.enums


enum EventTypeEnum {
	EVENT_TYPE__CUSTOM	    		(100, "eventTypeEnum.custom"),
	EVENT_TYPE__ACTIVATE			(200, "eventTypeEnum.actived"),
	EVENT_TYPE__DISABLED			(300, "eventTypeEnum.disabled"),
	EVENT_TYPE__NEW_CARD			(400, "eventTypeEnum.newcard"),
	EVENT_TYPE__BUY					(500, "eventTypeEnum.buy"),
	EVENT_TYPE__NEW_USER			(600, "eventTypeEnum.newUser"),
	EVENT_TYPE__RENOVATE			(700,"eventTypeEnum.renovate"),
	EVENT_TYPE__REMOVED				(800,"eventTypeEnum.removed"),
	EVENT_TYPE__AMONISHED			(900,"eventTypeEnum.amonished"),
	EVENT_TYPE__AMONISHED_FORGIVE	(905,"eventTypeEnum.amonishedForgive")
	
	
	final int id
	final String name

	private EventTypeEnum(int id, String name) {
		this.id = id
		this.name = name
	}

	String toString() {
		name
	}
	
	
	static List getJson() {
		return EventTypeEnum.values().collect{ return ["key":it.name(), "value":it.name] }
	}
}
