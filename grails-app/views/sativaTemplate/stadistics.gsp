<!DOCTYPE html>
<%@ page import="sun.misc.BASE64Encoder" %>
<%@ page import="sun.misc.BASE64Decoder" %>
<%@ page import="javax.imageio.ImageIO" %>
	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="container-fluid">
				 		<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
						  <li class="active"><a href="#tablePerDay" role="tab" data-toggle="tab">Tabla del dia</a></li>
						  <li id="tableDivPeriod"><a href="#tablePerPeriod" role="tab" data-toggle="tab"> Aportaciones por período</a></li>
						  <li id="tableDivGeneticPeriod"><a href="#tablePerGeneticPeriod" role="tab" data-toggle="tab"> Geneticas período</a></li>
						</ul>

						<!-- Tab panes -->
						<div class="tab-content">
						  <div class="tab-pane active" id="tablePerDay">
						  		<div class="row">
						  			<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'day',controller:'geneticOrders']" >
							        <div class="col-lg-4">
									    <div class="input-group">
									      <input type="date" id="calendar1" class="form-control">
									      <input type="hidden" name="currentDate" id="hiddenCalendar">
									      <span class="input-group-btn">
									        <button class="btn btn-default" type="submit">Filtrar</button>
									      </span>
									    </div>
									  </div>
							        </g:form>

							       
							    </div>

						  		<table class="tableStadistic table table-bordered table-condensed">
						 			<thead>
						 				<tr>
							 				<th class="col-lg-2">Numero de socio</th>
							 				<th class="col-lg-2">Genética</th>
							 				<th class="col-lg-2">Gramos</th>
							 				
							 				<th class="col-lg-2">Fecha</th>
							 				<th class="col-lg-4 center">Firma</th>
						 				</tr>
						 			</thead>
						 			<tbody>
						 				<g:if test="${stadisticsPerDay}">
					 						<g:each in="${stadisticsPerDay}">
					 							<tr>
					 								<td style="vertical-align:middle">${it.partner?.code}</td>
					 								<td style="vertical-align:middle">${it.genetic.name}</td>
					 								<td style="vertical-align:middle">${it.genetic.type.grams*it.amount}gr</td>
					 								<td style="vertical-align:middle"><g:formatDate  timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/> </td>
					 								<td  style="vertical-align:middle" class="center">
					 									<%
					 										def signatureImage
					 										try {
																def imageAux		  = ImageIO.read(new File("/usr/sativaImages/firmas/"+it.id+".png"));
																ByteArrayOutputStream bos = new ByteArrayOutputStream();
															 	ImageIO.write(imageAux, "png", bos);
																byte[] imageBytes	  = bos.toByteArray();
																BASE64Encoder encoder = new BASE64Encoder();
													        	signatureImage = encoder.encode(imageBytes);
													        }catch(all){}
					 									%>
					 								<img src="data:image/png;base64,${signatureImage}" class="imageSign" />
					 							</tr>
					 						</g:each>
						 				</g:if>
						 				<g:else>
						 					
						 				</g:else>
						 			</tbody>
				 				</table>
						  </div>
						  <div class="tab-pane" id="tablePerPeriod">
						  		<div class="row">
							        <div class='col-lg-3'>
							        	<p>Desde</p>
							        </div>
							        <div class='col-lg-3'>
							        	<p>Hasta</p>
							        </div>
							    </div>
						  		<div class="row">
							        <div class='col-lg-12'>
							        	<div class="row">
											  <div class="col-lg-3">
											    <div class="input-group">
											    	
											     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" id="calendar2" class=" form-control">
											    </div>
											  </div>
											  <div class="col-lg-3">
											  	<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'periodic',controller:'geneticOrders']" >
												    <div class="input-group">
												    	<input type="hidden" name="start" value="" class="hiddenCalendar2">
												    	<input type="hidden" name="end" value="" class="hiddenCalendar3">
												     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" id="calendar3" class="form-control">
												      <span class="input-group-btn">
												        <button type="submit" class="btn btn-default" >Filtrar</button>
												      </span>
												    </div>
												</g:form>
											</div>
							        </div>
							    </div>
							    <g:if test="${stadisticsPerPeriod}">	
							    	<h3 style="margin-top:70px"><b>Total de gramos:</b> ${totalPerPeriod}g</h3>								
							  		<table class="table tableStadistic2 table-bordered table-condensed">
							 			<thead>
							 				<tr>
								 				<th>Numero de socio</th>
								 				<th>Cantidad total</th>
							 				</tr>
							 			</thead>
							 			<tbody>
							 				<g:if test="${stadisticsPerPeriod}">
						 						<g:each in="${stadisticsPerPeriod}">
						 							<tr>
						 								<td>${it.partner?.code}</td>
						 								<td>${it.grams} gr</td>
						 							</tr>
						 						</g:each>
							 				</g:if>
							 				<g:else>
							 					
							 				</g:else>
							 			</tbody>
					 				</table>
					 			</g:>
						  </div>
						 </div>
						  <div class="tab-pane" id="tablePerGeneticPeriod">
						  		<div class="row">
							        <div class='col-lg-3'>
							        	<p>Desde</p>
							        </div>
							        <div class='col-lg-3'>
							        	<p>Hasta</p>
							        </div>
							    </div>
						  		<div class="row">
							        <div class='col-lg-12'>
							        	<div class="row">
											  <div class="col-lg-3">
											    <div class="input-group">
											    	
											     <input type="date" value="${new Date().format('dd/MM/yyyy')}" id="calendar4" class="form-control ">
											    </div>
											  </div>
											  <div class="col-lg-3">
											  	<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'genetics',controller:'geneticOrders']" >
												    <div class="input-group">
												    	<input type="hidden" name="start" value="" class="hiddenCalendar2">
												    	<input type="hidden" name="end" value="" class="hiddenCalendar3">
												     <input type="date"  value="${new Date().format('dd/MM/yyyy')}" id ="calendar5" class=" form-control">
												      <span class="input-group-btn">
												        <button type="submit" class="btn btn-default" >Filtrar</button>
												      </span>
												    </div>
												</g:form>
											</div>
							        </div>
							    </div>
							    <g:if test="${listGenetics}">	
							    	<g:set var="count" value="${1}" />								
							  		<h3 style="margin-top:70px;"><b>Total de aportaciones:</b> ${totalBuys}</h3>
							  		<h3><b>Total de gramos:</b> ${totalGrams}g</h3>
							  		<table class="tableStadistic2 table" id="tableGenetics" >
							 			 	<tr>
								                 <g:each in="${listGenetics}">
								                    <td><b>${it.name.name}:</b> ${it.amount} (${it.name.type.grams * it.amount}) gr</td>                   
								                      <g:if test="${count % 5 == 0 && count!=0}">
								                        </tr><tr>
								                      </g:if>
								                    <g:set var="count" value="${count + 1}" />
								                 </g:each>
								            </tr>
					 				</table>
					 			</g:>

					 				
					 				 <div class="demo-container">
			<div id="placeholder" class="demo-placeholder"></div>
		</div>
					 			
						  		
						  </div>
						

				 </div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script src="${resource(dir:'js/pluginsSativa/chart', file: 'jquery.flot.js')}" type="text/javascript"></script>

<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Sativa
	</div>
</div>

<!-- END PAGE LEVEL SCRIPTS -->
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   var listGen;
   var amounGen;
   var daysGen;
   var now = new Date("${daySelected}")
   var end = new Date()
   var start   = new Date()
   start.setDate(start.getDate()-30)
   if ("${start}" != "") {
   		start = new Date("${start}")
   }
   if ("${end}" != ""){
   		 end = new Date("${end}")
   }
  
  
   var loadGraph = function() {

   	if ("${graph}" != "") {
   		console.log("${graph}")
		listGen   = "${graph?.name}";
		amounGen  = "${graph?.buys}";
		daysGen = "${graph?.days}";


		listGen = listGen.substring(1, listGen.length-2);
		amounGen = amounGen.substring(1, amounGen.length-1);
		daysGen = daysGen.substring(1, daysGen.length-1);
		
		listGen  = listGen.split(',');
		amounGen = amounGen.split(',');
		daysGen  = daysGen.split(',');


		var ticksArr = [];
	
		var maxY = -1;
		for (var j=0; j < listGen.length; j++) {
			ticksArr.push([j, j]);
		}

		var d1 = [];
		for (var i = 0; i < amounGen.length; i ++) {
			var auxVale;
			if (daysGen[i] == 0){
				auxVale = 0;
			}
			else auxVale = parseInt(parseInt(amounGen[i])/parseInt(daysGen[i]));
			d1.push([i, parseInt(auxVale)]);
			if (auxVale > maxY) maxY = auxVale;
		}

		if (maxY == 0)maxY = 1;
	

		setTimeout(function() {
			$.plot("#placeholder", [ d1], {
				series: {
					 bars: {
					        show: true
					    }
				},
				grid: { 
					hoverable: true, 
					clickable: true 
				},
				yaxis: {
					max:maxY,
					min:0
				},
				xaxis: {
					ticks: ticksArr,
					max:listGen.length-1,
					min:0
				},
				 colors: ["#0022FF"]
			});

			$("<div id='tooltip'></div>").css({
				position: "absolute",
				display: "none",
				border: "1px solid #fdd",
				padding: "2px",
				"background-color": "#fee",
				opacity: 0.80
			}).appendTo("body");


			$("#placeholder").bind("plothover", function (event, pos, item) {
					
				if (item) {
					var x = item.datapoint[0].toFixed(2),
						y = item.datapoint[1].toFixed(2);

					$("#tooltip").html(listGen[parseInt(x)]+" "+parseInt(y))
						.css({top: item.pageY+5, left: item.pageX+5})
						.fadeIn(200);
				} else {
					$("#tooltip").hide();
				}
					
			});
		}, 1000);
		}
	}
   
   
   var day = ("0" + now.getDate()).slice(-2);
   var month = ("0" + (now.getMonth() + 1)).slice(-2);
   var today 	 = now.getFullYear()+"-"+(month)+"-"+(day) ;
   day = ("0" + start.getDate()).slice(-2);
   month = ("0" + (start.getMonth() + 1)).slice(-2);
   var auxStart 	 = start.getFullYear()+"-"+(month)+"-"+(day) ;
   day = ("0" + end.getDate()).slice(-2);
   month = ("0" + (end.getMonth() + 1)).slice(-2);
   var auxEnd 	 = end.getFullYear()+"-"+(month)+"-"+(day) ;
   if ("${page}" == "periodic") {
   		$('#tableDivPeriod').tab('show')
   		$('#tablePerPeriod').addClass('active');
   		$('#tablePerDay').removeClass('active');
   		$('#tablePerGeneticPeriod').removeClass('active');
   } 
   else if ("${page}" == "genetics") {
   		$('#tableDivGeneticPeriod').tab('show')
   		$('#tablePerGeneticPeriod').addClass('active');
   		$('#tablePerDay').removeClass('active');
   		$('#tablePerPeriod').removeClass('active');
   		loadGraph();
   } 
   $('#calendar1').val(today)
   $('#calendar2').val(auxStart)
   $('#calendar3').val(auxEnd)
   $('#calendar4').val(auxStart)
   $('#calendar5').val(auxEnd)
	if (now) {
		$('#hiddenCalendar').val(now.toISOString())
	}
	if (start){
   		$('.hiddenCalendar2').val(start.toISOString())
    }
    if (end) {
   		$('.hiddenCalendar3').val(end.toISOString())
   	}
   $('#calendar1').on('change', function(){
   		var auxDate = new Date($('#calendar1').val());
   		$('#hiddenCalendar').val(auxDate.toISOString())
   });
   $('#calendar2').on('change', function(){
   		var auxDate = new Date($('#calendar2').val());
   		$('.hiddenCalendar2').val(auxDate.toISOString())
   });
   $('#calendar3').on('change', function(){
   		var auxDate = new Date($('#calendar3').val());
   		$('.hiddenCalendar3').val(auxDate.toISOString())
   });
    $('#calendar4').on('change', function(){
   		var auxDate = new Date($('#calendar4').val());
   		$('.hiddenCalendar2').val(auxDate.toISOString())
   });
   $('#calendar5').on('change', function(){
   		var auxDate = new Date($('#calendar5').val());
   		$('.hiddenCalendar3').val(auxDate.toISOString())
   });

   $('#tableDivGeneticPeriod').click(function() {
		loadGraph();
    });

	
 
  
});

	</script>
</body>

<!-- END BODY -->
</html>
