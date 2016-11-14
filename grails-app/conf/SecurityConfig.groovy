import grails.plugin.springsecurity.SecurityConfigType



//	SPRING SECURITY
grails.plugin.springsecurity.debug.useFilter = false
grails.plugin.console.enabled = true


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.sativa.domain.Partner'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.sativa.domain.PartnerRole'
grails.plugin.springsecurity.authority.className = 'com.sativa.domain.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/':                              ['permitAll'],
	'/index':                         ['permitAll'],
	'/index.gsp':                     ['permitAll'],
	'/assets/**':                     ['permitAll'],
	'/**/js/**':                      ['permitAll'],
	'/**/css/**':                     ['permitAll'],
	'/**/images/**':                  ['permitAll'],
	'/**/favicon.ico':                ['permitAll'],
	'/console/**':					  ['permitAll']
]


grails.plugin.springsecurity.interceptUrlMap = [
   '/grails-errorhandler/**': ['IS_AUTHENTICATED_ANONYMOUSLY'], 
   '/grails/error/**'      : ['IS_AUTHENTICATED_ANONYMOUSLY']
]


grails.plugin.springsecurity.logout.postOnly 			= false
grails.plugin.springsecurity.password.algorithm			= 'SHA-256'
grails.plugin.springsecurity.password.hash.iterations	= 1


grails.plugin.springsecurity.successHandler.alwaysUseDefault = true


/** default redirect **/
grails.plugin.springsecurity.successHandler.defaultTargetUrl 			= '/login/success'
grails.plugin.springsecurity.successHandler.ajaxSuccessUrl 				= '/login/success'
grails.plugin.springsecurity.failureHandler.defaultFailureUrl 			= '/login/authfail'
grails.plugin.springsecurity.failureHandler.ajaxAuthFailUrl 			= '/login/authfail'
grails.plugin.springsecurity.adh.errorPage 								= '/login/denied'
grails.plugin.springsecurity.adh.ajaxErrorPage 							= '/login/denied'
grails.plugin.springsecurity.logout.afterLogoutUrl 						= '/logout/success'
grails.plugin.springsecurity.auth.loginFormUrl 							= '/login/denied'
grails.plugin.springsecurity.auth.ajaxLoginFormUrl 						= '/login/denied'

grails.plugin.springsecurity.rejectIfNoRule 							= false
grails.plugin.springsecurity.fii.rejectPublicInvocations				= false


grails.plugin.springsecurity.useSecurityEventListener 					= true
grails.plugin.springsecurity.useSessionFixationPrevention 				= true
grails.plugin.springsecurity.sessionFixationPrevention.migrate 			= true
 

// proves crossdomain
grails.plugin.springsecurity.auth.useForward 			= true
grails.plugin.springsecurity.failureHandler.useForward 	= false	
