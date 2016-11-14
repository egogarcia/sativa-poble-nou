import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sativa_sativaTemplate_scriptsTemplate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/sativaTemplate/_scriptsTemplate.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(resource(dir: 'js/pluginsSativa', file: 'jquery-1.11.0.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir: 'js/pluginsSativa', file: 'jquery-migrate-1.2.1.min.js'))
printHtmlPart(2)
expressionOut.print(resource(dir: 'js/pluginsSativa/jquery-ui', file: 'jquery-ui-1.10.3.custom.min.js'))
printHtmlPart(3)
expressionOut.print(resource(dir: 'js/pluginsSativa/bootstrap/js', file: 'bootstrap.min.js'))
printHtmlPart(4)
expressionOut.print(resource(dir:'js/pluginsSativa/bootstrap-hover-dropdown', file:'bootstrap-hover-dropdown.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/jquery-slimscroll', file:'jquery.slimscroll.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa', file:'jquery.blockui.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/uniform', file: 'jquery.uniform.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa', file:'jquery.peity.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa', file: 'jquery.pulsate.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/jquery-knob/js', file:'jquery.knob.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/flot', file:'jquery.flot.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/flot', file: 'jquery.flot.resize.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/bootstrap-daterangepicker', file: 'moment.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/bootstrap-daterangepicker', file:'daterangepicker.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/bootstrap-datepicker/js', file:'bootstrap-datepicker.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/gritter/js', file:'jquery.gritter.js'))
printHtmlPart(5)
expressionOut.print(resource(dir:'js/pluginsSativa/fullcalendar/fullcalendar', file: 'fullcalendar.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa/jquery-easypiechart', file:'jquery.easypiechart.min.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/pluginsSativa', file:'jquery.sparkline.min.js'))
printHtmlPart(6)
expressionOut.print(resource(dir:'js/scriptsSativa', file:'app.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/scriptsSativa', file:'managementMember.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/scriptsSativa', file:'index.js'))
printHtmlPart(1)
expressionOut.print(resource(dir:'js/scriptsSativa', file: 'tasks.js'))
printHtmlPart(7)
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
