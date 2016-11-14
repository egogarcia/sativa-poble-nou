import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatemanagementMembers_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/managementMembers.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',2,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('set','g',73,['var':("isGreen"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',74,['var':("isYellow"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',75,['var':("isOrange"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',76,['var':("isRed"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',77,['var':("isGrey"),'value':("false")],-1)
printHtmlPart(3)
invokeTag('set','g',78,['var':("isBlue"),'value':("false")],-1)
printHtmlPart(4)
for( _it1732381424 in (statusMembers) ) {
changeItVariable(_it1732381424)
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__ACTIVED")) {
printHtmlPart(6)
invokeTag('set','g',83,['var':("isGreen"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__UNKNOWN")) {
printHtmlPart(6)
invokeTag('set','g',86,['var':("isYellow"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__DETOXIFIED")) {
printHtmlPart(6)
invokeTag('set','g',89,['var':("isOrange"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "PARTNER_STATUS__BANNED")) {
printHtmlPart(6)
invokeTag('set','g',92,['var':("isRed"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(3)
}
printHtmlPart(3)
for( _it551307142 in (typeMemebers) ) {
changeItVariable(_it551307142)
printHtmlPart(3)
if(true && (it == "CONSUM_LUDIC")) {
printHtmlPart(6)
invokeTag('set','g',97,['var':("isGrey"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(5)
if(true && (it == "CONSUM_THERAPEUTIC")) {
printHtmlPart(6)
invokeTag('set','g',100,['var':("isBlue"),'value':("true")],-1)
printHtmlPart(5)
}
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('img','g',109,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(6)
if(true && (isGreen == 'true')) {
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('img','g',118,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(6)
if(true && (isYellow == 'true')) {
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(11)
invokeTag('img','g',127,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(6)
if(true && (isOrange == 'true')) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('img','g',136,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(6)
if(true && (isRed == 'true')) {
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (isBlue == 'true')) {
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(22)
if(true && (isGrey == 'true')) {
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
})
invokeTag('form','g',168,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'all',controller:'member'])],1)
printHtmlPart(26)
expressionOut.print(listMembers?.totalCount)
printHtmlPart(27)
if(true && (listMembers)) {
printHtmlPart(28)
for( _it1574682436 in (listMembers) ) {
changeItVariable(_it1574682436)
printHtmlPart(29)
expressionOut.print(it.code)
printHtmlPart(30)
expressionOut.print(it.firstname)
printHtmlPart(31)
expressionOut.print(it.lastname)
printHtmlPart(30)
expressionOut.print(it.identificationNumber)
printHtmlPart(32)
if(true && (it.status?.name() == 'PARTNER_STATUS__ACTIVED')) {
printHtmlPart(33)
invokeTag('img','g',193,['dir':("css/img"),'file':("semaforoVerde.jpg")],-1)
printHtmlPart(34)
}
else if(true && (it.status?.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(33)
invokeTag('img','g',196,['dir':("css/img"),'file':("semaforoAzul.jpg ")],-1)
printHtmlPart(34)
}
else if(true && (it.status?.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(33)
invokeTag('img','g',199,['dir':("css/img"),'file':("semaforoRojo.jpg")],-1)
printHtmlPart(34)
}
else if(true && (it.status?.name() == 'PARTNER_STATUS__DETOXIFIED')) {
printHtmlPart(33)
invokeTag('img','g',202,['dir':("css/img"),'file':("semaforoNaranja.jpg")],-1)
printHtmlPart(34)
}
else if(true && (it.status?.name() == 'PARTNER_STATUS__UNKNOWN')) {
printHtmlPart(33)
invokeTag('img','g',205,['dir':("css/img"),'file':("semaforoAmarillo.jpg")],-1)
printHtmlPart(34)
}
else if(true && (it.status?.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(33)
invokeTag('img','g',208,['dir':("css/img"),'file':("semaforoLila.jpg")],-1)
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(createLink(controller:'member', action:'showEdit', params:[memberId:it.id]))
printHtmlPart(36)
expressionOut.print(it.id)
printHtmlPart(37)
if(true && (it.consum?.name() == 'CONSUM_THERAPEUTIC')) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
}
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (offset==0)) {
printHtmlPart(44)
}
else {
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (listMembers.size() < 50)) {
printHtmlPart(47)
}
else {
printHtmlPart(48)
}
printHtmlPart(49)
invokeTag('render','g',266,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(50)
expressionOut.print(offset)
printHtmlPart(51)
expressionOut.print(offset)
printHtmlPart(52)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1458841351000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
