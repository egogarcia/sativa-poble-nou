import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplateeditMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/editMember.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
expressionOut.print(createLink(controller:'member', action:'delete', params:[memberId:member.id]))
printHtmlPart(2)
expressionOut.print(createLink(controller:'member', action:'amonished', params:[memberId:member.id]))
printHtmlPart(3)
if(true && (success)) {
printHtmlPart(4)
expressionOut.print(success)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (error)) {
printHtmlPart(7)
expressionOut.print(error)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (member.image)) {
printHtmlPart(10)
expressionOut.print(imagePerson)
printHtmlPart(11)
}
else {
printHtmlPart(12)
invokeTag('img','g',61,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(15)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(member.code)
printHtmlPart(18)
invokeTag('formatDate','g',76,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',79,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(20)
expressionOut.print(card?.code)
printHtmlPart(21)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(22)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(23)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (yellowCard > 0)) {
printHtmlPart(26)
for( _it1233083845 in (1..yellowCard) ) {
changeItVariable(_it1233083845)
printHtmlPart(27)
invokeTag('img','g',93,['dir':("css/img"),'file':("yellowCard.jpg"),'width':("50")],-1)
printHtmlPart(28)
expressionOut.print(createLink(controller:'member', action:'forgiveAmonished', params:[memberId:member.id]))
printHtmlPart(29)
}
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(1, {->
printHtmlPart(32)
expressionOut.print(member.id)
printHtmlPart(33)
expressionOut.print(member.firstname)
printHtmlPart(34)
expressionOut.print(member.lastname)
printHtmlPart(35)
expressionOut.print(member.identificationNumber)
printHtmlPart(36)
expressionOut.print(member.address)
printHtmlPart(37)
expressionOut.print(member.phone)
printHtmlPart(38)
if(true && (member.consum.name() == 'CONSUM_LUDIC')) {
printHtmlPart(39)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (member.consum.name() == 'CONSUM_THERAPEUTIC')) {
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
})
invokeTag('form','g',170,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'edit',controller:'member'])],1)
printHtmlPart(44)
if(true && (numInvitations >= 5)) {
printHtmlPart(45)
invokeTag('img','g',175,['id':("imageAlertGuest"),'dir':("images/imageSativa"),'file':("warning.png"),'width':("80"),'height':("80")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(grams.monthly)
printHtmlPart(48)
expressionOut.print(grams.anualy)
printHtmlPart(49)
for( _it1222989365 in (listGenetics) ) {
changeItVariable(_it1222989365)
printHtmlPart(50)
expressionOut.print(it.name)
printHtmlPart(51)
}
printHtmlPart(52)
invokeTag('cookie','g',202,['name':("myCookie")],-1)
printHtmlPart(53)
createTagBody(1, {->
printHtmlPart(54)
expressionOut.print(member.id)
printHtmlPart(55)
})
invokeTag('form','g',209,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(56)
for( _it1216272118 in (listEvents) ) {
changeItVariable(_it1216272118)
printHtmlPart(57)
expressionOut.print(it.writer)
printHtmlPart(58)
invokeTag('formatDate','g',212,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(59)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(60)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(61)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(62)
}
else {
printHtmlPart(63)
}
printHtmlPart(64)
expressionOut.print(it.observation)
printHtmlPart(65)
}
printHtmlPart(66)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(67)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(68)
}
printHtmlPart(69)
invokeTag('set','g',243,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(70)
invokeTag('set','g',244,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(70)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(71)
invokeTag('set','g',246,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(70)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(71)
invokeTag('set','g',249,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(70)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(71)
invokeTag('set','g',252,['var':("actionBtn"),'value':("renovation")],-1)
printHtmlPart(70)
}
printHtmlPart(72)
createTagBody(1, {->
printHtmlPart(73)
expressionOut.print(member.id)
printHtmlPart(74)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(75)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(78)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(79)
}
printHtmlPart(80)
})
invokeTag('form','g',277,['name':("myForm"),'role':("form"),'id':("formMemberEdit"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(81)
invokeTag('render','g',292,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(82)
expressionOut.print(member.status.name())
printHtmlPart(83)
expressionOut.print(member.status.name())
printHtmlPart(84)
expressionOut.print(member.birthday)
printHtmlPart(85)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1455977655000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
