import sun.misc.BASE64Encoder
import sun.misc.BASE64Decoder
import javax.imageio.ImageIO
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplatestadistics_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/stadistics.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
invokeTag('render','g',5,['template':("/sativaTemplate/menuTemplate"),'model':(username)],-1)
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('form','g',32,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'day',controller:'geneticOrders'])],1)
printHtmlPart(5)
if(true && (stadisticsPerDay)) {
printHtmlPart(6)
for( _it1120730385 in (stadisticsPerDay) ) {
changeItVariable(_it1120730385)
printHtmlPart(7)
expressionOut.print(it.partner?.code)
printHtmlPart(8)
expressionOut.print(it.genetic.name)
printHtmlPart(8)
expressionOut.print(it.genetic.type.grams*it.amount)
printHtmlPart(9)
invokeTag('formatDate','g',55,['timeZone':(TimeZone.getTimeZone('Europe/Madrid')),'format':("dd-MM-yyyy HH:mm"),'date':(it.dateCreated)],-1)
printHtmlPart(10)

def signatureImage
					 										try {
																def imageAux		  = ImageIO.read(new File("/usr/sativaImages/firmas/"+it.id+".png"));
																ByteArrayOutputStream bos = new ByteArrayOutputStream();
															 	ImageIO.write(imageAux, "png", bos);
																byte[] imageBytes	  = bos.toByteArray();
																BASE64Encoder encoder = new BASE64Encoder();
													        	signatureImage = encoder.encode(imageBytes);
													        }catch(all){}

printHtmlPart(11)
expressionOut.print(signatureImage)
printHtmlPart(12)
}
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(17)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(18)
})
invokeTag('form','g',106,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'periodic',controller:'geneticOrders'])],1)
printHtmlPart(19)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(20)
expressionOut.print(totalPerPeriod)
printHtmlPart(21)
if(true && (stadisticsPerPeriod)) {
printHtmlPart(22)
for( _it536512858 in (stadisticsPerPeriod) ) {
changeItVariable(_it536512858)
printHtmlPart(23)
expressionOut.print(it.partner?.code)
printHtmlPart(24)
expressionOut.print(it.grams)
printHtmlPart(25)
}
printHtmlPart(26)
}
else {
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(30)
createTagBody(1, {->
printHtmlPart(17)
expressionOut.print(new Date().format('dd/MM/yyyy'))
printHtmlPart(31)
})
invokeTag('form','g',164,['name':("myForm"),'role':("form"),'class':("form-horizontal"),'url':([action:'genetics',controller:'geneticOrders'])],1)
printHtmlPart(19)
if(true && (listGenetics)) {
printHtmlPart(32)
invokeTag('set','g',169,['var':("count"),'value':(1)],-1)
printHtmlPart(33)
expressionOut.print(totalBuys)
printHtmlPart(34)
expressionOut.print(totalGrams)
printHtmlPart(35)
for( _it2035254300 in (listGenetics) ) {
changeItVariable(_it2035254300)
printHtmlPart(36)
expressionOut.print(it.name.name)
printHtmlPart(37)
expressionOut.print(it.amount)
printHtmlPart(38)
expressionOut.print(it.name.type.grams * it.amount)
printHtmlPart(39)
if(true && (count % 5 == 0 && count!=0)) {
printHtmlPart(40)
}
printHtmlPart(41)
invokeTag('set','g',179,['var':("count"),'value':(count + 1)],-1)
printHtmlPart(42)
}
printHtmlPart(43)
}
printHtmlPart(44)
invokeTag('render','g',202,['template':("/sativaTemplate/scriptsTemplate")],-1)
printHtmlPart(45)
expressionOut.print(resource(dir:'js/pluginsSativa/chart', file: 'jquery.flot.js'))
printHtmlPart(46)
expressionOut.print(daySelected)
printHtmlPart(47)
expressionOut.print(start)
printHtmlPart(48)
expressionOut.print(start)
printHtmlPart(49)
expressionOut.print(end)
printHtmlPart(50)
expressionOut.print(end)
printHtmlPart(51)
expressionOut.print(graph)
printHtmlPart(52)
expressionOut.print(graph)
printHtmlPart(53)
expressionOut.print(graph?.name)
printHtmlPart(54)
expressionOut.print(graph?.buys)
printHtmlPart(55)
expressionOut.print(graph?.days)
printHtmlPart(56)
expressionOut.print(page)
printHtmlPart(57)
expressionOut.print(page)
printHtmlPart(58)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1456566809000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
