package com.sativa.controller

import grails.plugin.springsecurity.annotation.Secured;

import javax.servlet.http.HttpServletResponse


/**
 * <p>Logout the authenticated user.</p> 
 * <p>Accessed by /j_spring_security_logout.</p>
 * 
 * 	@author 9smartpark S.L
 */
@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])	//TODO: afegit per test, crec que no te que estar
class LogoutController {

	/**
	 * Logout success callback
	 * @return <p>200 with json translated description.</p>	
	 */
	def success() {	//TODO: repetit
		render(view: "/sativaTemplate/login")
	}
}
