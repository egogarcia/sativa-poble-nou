import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatesearchPartners_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/searchPartners.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
if(true && (error)) {
printHtmlPart(2)
expressionOut.print(error)
printHtmlPart(3)
}
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
if(true && (listMembers)) {
printHtmlPart(6)
for( _it130962255 in (listMembers) ) {
changeItVariable(_it130962255)
printHtmlPart(7)
expressionOut.print(it.id)
printHtmlPart(8)
expressionOut.print(it.firstname)
printHtmlPart(9)
expressionOut.print(it.lastname)
printHtmlPart(10)
}
printHtmlPart(11)
}
printHtmlPart(12)
})
invokeTag('form','g',67,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'add',controller:'partner'])],1)
printHtmlPart(13)
if(true && (listPartners)) {
printHtmlPart(14)
for( _it2059365257 in (listPartners) ) {
changeItVariable(_it2059365257)
printHtmlPart(15)
expressionOut.print(it.username)
printHtmlPart(16)
expressionOut.print(it.firstname)
printHtmlPart(9)
expressionOut.print(it.lastname)
printHtmlPart(17)
expressionOut.print(createLink(controller:'partner', action:'remove', params:[partnerId:it.id]))
printHtmlPart(18)
invokeTag('img','g',87,['dir':("css/img"),'file':("borrar.jpg")],-1)
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('render','g',113,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1436041506000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
