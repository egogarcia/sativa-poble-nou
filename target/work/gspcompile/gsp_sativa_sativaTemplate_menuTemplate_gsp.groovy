import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplate_menuTemplate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/_menuTemplate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',19,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',20,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',20,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',21,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1.0"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("description")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',24,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':(""),'name':("author")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',25,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("MobileOptimized"),'content':("320")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'js/pluginsSativa/font-awesome/css', file: 'font-awesome.min.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/pluginsSativa/simple-line-icons', file: 'simple-line-icons.min.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/pluginsSativa/bootstrap/css', file: 'bootstrap.min.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/pluginsSativa/uniform/css', file: 'uniform.default.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'js/pluginsSativa/bootstrap-daterangepicker', file: 'daterangepicker-bs3.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/pluginsSativa/fullcalendar/fullcalendar', file: 'fullcalendar.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'js/pluginsSativa/jqvmap/jqvmap', file: 'jqvmap.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css/sativaCss', file: 'style-conquer.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/sativaCss', file: 'style.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/sativaCss', file: 'style-responsive.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/sativaCss', file: 'plugins.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/sativaCss/pages', file: 'tasks.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/sativaCss/themes', file: 'default.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'css/sativaCss', file: 'custom.css'))
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',48,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(sec.loggedInUserInfo(field: 'username'))
printHtmlPart(10)
})
invokeTag('ifLoggedIn','sec',61,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',97,['mapping':("searchMember")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',104,['mapping':("listInvitate")],2)
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 3)
invokeTag('link','g',111,['mapping':("managementMembers")],3)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',119,['mapping':("managementGenetics")],3)
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',125,['mapping':("stadistics")],3)
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',131,['mapping':("searchPartner")],3)
printHtmlPart(16)
})
invokeTag('ifAllGranted','sec',133,['roles':("ROLE_ADMIN")],2)
printHtmlPart(25)
expressionOut.print(createLink(uri:'j_spring_security_logout'))
printHtmlPart(26)
})
invokeTag('ifLoggedIn','sec',141,[:],1)
printHtmlPart(27)
expressionOut.print(resource(dir:'css/img', file:'logo2.png'))
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1458676097000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
