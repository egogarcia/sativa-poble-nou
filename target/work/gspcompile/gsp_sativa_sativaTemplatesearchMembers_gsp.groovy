import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatesearchMembers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/searchMembers.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('form','g',56,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'search',controller:'member'])],1)
printHtmlPart(3)
expressionOut.print(total)
printHtmlPart(4)
if(true && (listMembers)) {
printHtmlPart(5)
loop:{
int i = 0
for( mem in (listMembers) ) {
printHtmlPart(6)
expressionOut.print(i+1+offset)
printHtmlPart(7)
expressionOut.print(mem.code)
printHtmlPart(7)
expressionOut.print(mem.firstname)
printHtmlPart(8)
expressionOut.print(mem.lastname)
printHtmlPart(7)
expressionOut.print(mem.identificationNumber)
printHtmlPart(9)
if(true && (mem.status.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(10)
invokeTag('img','g',81,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(11)
}
else if(true && (mem.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(10)
invokeTag('img','g',84,['dir':("css/img"),'file':("semaforoAzul.jpg")],-1)
printHtmlPart(11)
}
else if(true && (mem.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(10)
invokeTag('img','g',87,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(11)
}
else if(true && (mem.status.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(10)
invokeTag('img','g',90,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(11)
}
else if(true && (mem.status.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(10)
invokeTag('img','g',93,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(11)
}
else if(true && (mem.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(10)
invokeTag('img','g',96,['dir':("css/img"),'file':("semaforoLila.jpg")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
expressionOut.print(createLink(controller:'member', action:'show', params:[memberId:mem.id]))
printHtmlPart(13)
i++
}
}
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
if(true && (offset==0)) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (listMembers.size() < 50)) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('render','g',141,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(23)
expressionOut.print(offset)
printHtmlPart(24)
expressionOut.print(offset)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1458842019000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
