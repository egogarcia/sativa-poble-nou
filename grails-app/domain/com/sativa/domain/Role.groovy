package com.sativa.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


/**
 * <p>Roles usados en el sistema de 9SmartPark.</p>
 *
 * 	@author 	9SmartPark S.L.
 */
@ToString(includeNames = true, includeFields = true, excludes = 'metaClass')
@EqualsAndHashCode
class Role {
	private static final String ROLE_PARTNER	 = "ROLE_PARTNER"			//	Aka: Usuari de 9smartpark que podra saltarse limitaciones
	private static final String ROLE_ADMIN 		 = "ROLE_ADMIN"		//	Aka: Usuari de 9smartpark que oferta places de parking
	private static final String ROLE_SELLER 	 = "ROLE_SELLER"		//	Aka: Usuari de 9smartpark

	Long	id
	String 	authority
		
	static mapping = {
		cache 	true
		version false
	}
	static constraints = {
		authority blank: false, unique: true
	}
}
