<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				 <div class="row well">
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'search',controller:'member']" >
	                            <div class="row">
	                            	<div class="col-lg-4">
	                            		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Nombre</label>
	                              			<div class="col-lg-9">
	                               	 			<input type="text" class="form-control" name="firstname" />
	                              			 </div>
	                               			
	                            		</div>
	                            	</div>
	                            	<div class="col-lg-4">
	                             		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Apellidos</label>
	                              			<div class="col-lg-9">
			                               	 <input type="text" class="form-control" name="lastname" />
			                               </div>
			                               
			                            </div>
	                            	</div>
	                            	 <div class="col-lg-4">
		                             	<div class="form-group">
	                            			<input type="submit" class="btn btn-success" value="Buscar" />
										</div>
		                            </div>
	                              	<div class="col-lg-4">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">DNI</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="text" class="form-control" name="identificationNumber" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                             <div class="col-lg-4">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">Nº Socio</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="text" class="form-control" name="code" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                            
	                            </div>
	                            
			              </g:form>
			        </div>
			        <h4><b>TOTAL DE SOCIOS: ${total}</b></h4>
			        <div class="row">
				 		<table class="table table-bordered table-condensed">
				 			<thead>
				 				<tr>
				 					<th>#</th>
				 					<th># Socio</th>
					 				<th>Nombre</th>
					 				<th>DNI</th>
					 				<th>Estado</th>
					 				<th>Acciones</th>
				 				</tr>
				 			</thead>
				 			<tbody>
				 				<g:if test="${listMembers}">
				 						<g:each in="${listMembers}" var="mem" status="i">
				 							<tr >
				 								<td style="vertical-align:middle">${i+1+offset}</td>
				 								<td style="vertical-align:middle">${mem.code}</td>
				 								<td style="vertical-align:middle">${mem.firstname} ${mem.lastname}</td>
				 								<td style="vertical-align:middle">${mem.identificationNumber}</td>
				 								<td style="vertical-align:middle">
				 									<g:if test="${mem.status.name() == 'PARTNER_STATUS__ACTIVED'}">
				 										<g:img dir="css/img" file="semaforoVerde.jpg"/>
				 									</g:if>
				 									<g:elseif test="${mem.status.name() == 'PARTNER_STATUS__DISABLED'}">
				 										<g:img dir="css/img" file="semaforoAzul.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${mem.status.name() == 'PARTNER_STATUS__BANNED'}">
				 										<g:img dir="css/img" file="semaforoRojo.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${mem.status.name() == 'PARTNER_STATUS__DETOXIFIED'}">
				 										<g:img dir="css/img" file="semaforoNaranja.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${mem.status.name() == 'PARTNER_STATUS__UNKNOWN'}">
				 										<g:img dir="css/img" file="semaforoAmarillo.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${mem.status.name() == 'PARTNER_STATUS__INVITE'}">
				 										<g:img dir="css/img" file="semaforoLila.jpg"/>
				 									</g:elseif>
				 								</td>
				 								<td>
				 									<a class="btn btn-primary" href="${createLink(controller:'member', action:'show', params:[memberId:mem.id])}">
				 										Ver
				 									</a>
				 								</td>
				 							</tr>
				 						</g:each>
				 				</g:if>
				 				<g:else>
				 					
				 				</g:else>
				 			</tbody>
				 		</table>
				 		<p class="paginationGuest">
				 			<g:if test="${offset==0}">
				 				<span class="back disabled">< Atras</span> 
				 			</g:if>
				 			<g:else> 
								<span class="back ">< Atras</span> 
				 			</g:else>
				 			<g:if test="${listMembers.size() < 50}">
				 				<span class="next disabled">Siguiente > </span>	
				 			</g:if>
				 			<g:else>
				 				<span class="next">Siguiente > </span>
				 			</g:else>
				 		</p>
	            	</div>
	        </div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->

<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Sativa
	</div>
</div>

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>
jQuery(document).ready(function() {    
   App.init(); // initlayout and core plugins
   $('.next').click(function(){
		if (!$(this).hasClass('disabled')){
			var auxOffset = ${offset};
			auxOffset = auxOffset + 50;
			window.location.replace('/buscar-socio?offset='+auxOffset);
		}
	});
	$('.back').click(function(){
		if (!$(this).hasClass('disabled')){
			var auxOffset = ${offset};
			auxOffset = auxOffset - 50;
			window.location.replace('/buscar-socio?offset='+auxOffset);
		}
	});

});
</script>
</body>

<!-- END BODY -->
</html>