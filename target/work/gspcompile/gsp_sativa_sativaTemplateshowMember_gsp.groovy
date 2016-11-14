import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplateshowMember_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/showMember.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('render','g',3,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(1)
expressionOut.print(resource(dir:'js/scriptsSativa', file: 'signature.js'))
printHtmlPart(2)
if(true && (member.image)) {
printHtmlPart(3)
expressionOut.print(imagePerson)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('img','g',17,['dir':("css/img"),'file':("avatar.png"),'width':("200")],-1)
printHtmlPart(6)
}
printHtmlPart(6)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(7)
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(member.id)
printHtmlPart(11)
if(true && (member.status.name() != 'PARTNER_STATUS__INVITE')) {
printHtmlPart(12)
}
printHtmlPart(13)
})
invokeTag('form','g',30,['name':("myForm"),'id':("formFriend"),'role':("form"),'class':("form-horizontal"),'url':([action:'invite',controller:'member'])],2)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('ifAllGranted','sec',36,['roles':("ROLE_ADMIN")],2)
printHtmlPart(14)
}
printHtmlPart(18)
if(true && (yellowCard > 0)) {
printHtmlPart(19)
for( _it344795534 in (1..yellowCard) ) {
changeItVariable(_it344795534)
printHtmlPart(20)
invokeTag('img','g',43,['dir':("css/img"),'file':("yellowCard.jpg"),'width':("50")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(member.code)
printHtmlPart(24)
expressionOut.print(member.firstname)
printHtmlPart(25)
expressionOut.print(member.lastname)
printHtmlPart(26)
expressionOut.print(member.identificationNumber)
printHtmlPart(27)
expressionOut.print(member.address)
printHtmlPart(28)
expressionOut.print(member.phone)
printHtmlPart(29)
invokeTag('formatDate','g',59,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy"),'date':(member.birthday)],-1)
printHtmlPart(30)
invokeTag('formatDate','g',60,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateCreated)],-1)
printHtmlPart(31)
invokeTag('formatDate','g',61,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(member.dateRenovation)],-1)
printHtmlPart(32)
expressionOut.print(card?.code)
printHtmlPart(33)
expressionOut.print(member.consum.getHumanName())
printHtmlPart(34)
if(true && (member.status.name() == 'PARTNER_STATUS__INVITE')) {
printHtmlPart(35)
expressionOut.print(member.lastFriend().firstname)
printHtmlPart(36)
expressionOut.print(member.lastFriend().lastname)
printHtmlPart(37)
}
printHtmlPart(38)
createTagBody(1, {->
printHtmlPart(39)
expressionOut.print(member.id)
printHtmlPart(40)
})
invokeTag('form','g',81,['name':("myForm"),'id':("formPhoto"),'role':("form"),'class':("form-horizontal"),'url':([action:'photo',controller:'member'])],1)
printHtmlPart(41)
expressionOut.print(grams.monthly)
printHtmlPart(42)
expressionOut.print(grams.anualy)
printHtmlPart(43)
if(true && (listCustomEvents.size() == 0)) {
printHtmlPart(44)
}
else {
printHtmlPart(45)
for( _it1067660332 in (listCustomEvents) ) {
changeItVariable(_it1067660332)
printHtmlPart(46)
expressionOut.print(it.writer)
printHtmlPart(47)
invokeTag('formatDate','g',94,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(48)
expressionOut.print(it.observation)
printHtmlPart(49)
expressionOut.print(createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id]))
printHtmlPart(50)
}
printHtmlPart(51)
}
printHtmlPart(52)
if(true && ((member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00)) {
printHtmlPart(53)
for( _it1941329239 in (listGenetics) ) {
changeItVariable(_it1941329239)
printHtmlPart(54)
expressionOut.print(it.type.color)
printHtmlPart(55)
expressionOut.print(it.type.color)
printHtmlPart(56)
expressionOut.print(it.id)
printHtmlPart(57)
expressionOut.print(it.type.price)
printHtmlPart(58)
expressionOut.print(it.name)
printHtmlPart(59)
}
printHtmlPart(60)
expressionOut.print(member.id)
printHtmlPart(61)
}
printHtmlPart(62)
invokeTag('cookie','g',128,['name':("myCookie")],-1)
printHtmlPart(63)
createTagBody(1, {->
printHtmlPart(64)
expressionOut.print(member.id)
printHtmlPart(65)
})
invokeTag('form','g',134,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'create',controller:'event'])],1)
printHtmlPart(66)
for( _it1201471002 in (listEvents) ) {
changeItVariable(_it1201471002)
printHtmlPart(67)
expressionOut.print(it.writer)
printHtmlPart(47)
invokeTag('formatDate','g',138,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(68)
if(true && (it.type.name() == 'EVENT_TYPE__ACTIVATE')) {
printHtmlPart(69)
}
else if(true && (it.type.name() == 'EVENT_TYPE__DISABLED')) {
printHtmlPart(70)
}
else if(true && (it.type.name() == 'EVENT_TYPE__RENOVATE')) {
printHtmlPart(71)
}
else {
printHtmlPart(72)
}
printHtmlPart(73)
expressionOut.print(it.observation)
printHtmlPart(74)
}
printHtmlPart(75)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(76)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(77)
}
printHtmlPart(78)
invokeTag('set','g',169,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(79)
invokeTag('set','g',170,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(79)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(80)
invokeTag('set','g',172,['var':("actionBtn"),'value':("remove")],-1)
printHtmlPart(79)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(80)
invokeTag('set','g',175,['var':("actionBtn"),'value':("activate")],-1)
printHtmlPart(79)
}
printHtmlPart(81)
createTagBody(1, {->
printHtmlPart(82)
expressionOut.print(member.id)
printHtmlPart(83)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(84)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(85)
}
printHtmlPart(86)
if(true && (member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED')) {
printHtmlPart(87)
}
else if(true && (member.status.name() == 'PARTNER_STATUS__BANNED')) {
printHtmlPart(88)
}
printHtmlPart(89)
})
invokeTag('form','g',199,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:actionBtn ])],1)
printHtmlPart(90)
invokeTag('set','g',214,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(79)
invokeTag('set','g',215,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(91)
createTagBody(1, {->
printHtmlPart(82)
expressionOut.print(member.id)
printHtmlPart(92)
})
invokeTag('form','g',226,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'member', action:'renovation'])],1)
printHtmlPart(93)
invokeTag('set','g',240,['var':("controllerBtn"),'value':("")],-1)
printHtmlPart(79)
invokeTag('set','g',241,['var':("actionBtn"),'value':("")],-1)
printHtmlPart(91)
createTagBody(1, {->
printHtmlPart(94)
expressionOut.print(member.id)
printHtmlPart(95)
})
invokeTag('form','g',253,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([controller:'event', action:'viewed'])],1)
printHtmlPart(96)
invokeTag('render','g',277,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(97)
expressionOut.print(grams.monthly)
printHtmlPart(98)
expressionOut.print(member.status.name())
printHtmlPart(99)
expressionOut.print(member.status.name())
printHtmlPart(100)
expressionOut.print(grams.monthly)
printHtmlPart(101)
expressionOut.print(notification)
printHtmlPart(102)
expressionOut.print(notification?.dateCreated)
printHtmlPart(103)
expressionOut.print(notification?.id)
printHtmlPart(104)
expressionOut.print(notification?.observation)
printHtmlPart(105)
expressionOut.print(member.id)
printHtmlPart(106)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1456571283000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
