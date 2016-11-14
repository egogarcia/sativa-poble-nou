<!DOCTYPE html>
	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
		<div class="modal fade" id="deleteMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1>ELIMINAR USUARIO</h1>
				</div>
				<div class="modal-body">
						<p>¿Estas seguro que quieres eliminar al usuario?</p>
				</div>
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<a id="btnDeleteMember" class="btn btn-danger" >Eliminar</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				 <div class="row well">
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'all',controller:'member']" >
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
	                            <div class="row">
	                            <g:set var="isGreen" value="false"/>
	                            <g:set var="isYellow" value="false"/>
	                            <g:set var="isOrange" value="false"/>
	                            <g:set var="isRed" value="false"/>
	                            <g:set var="isGrey" value="false"/>
	                            <g:set var="isBlue" value="false"/>

	                            
	                            <g:each in="${statusMembers}">
	                            	<g:if test="${it == "PARTNER_STATUS__ACTIVED"}">
	                            		<g:set var="isGreen" value="true"/>
	                            	</g:if>
	                            	<g:if test="${it == "PARTNER_STATUS__UNKNOWN"}">
	                            		<g:set var="isYellow" value="true"/>
	                            	</g:if>
	                            	<g:if test="${it == "PARTNER_STATUS__DETOXIFIED"}">
	                            		<g:set var="isOrange" value="true"/>
	                            	</g:if>
	                            	<g:if test="${it == "PARTNER_STATUS__BANNED"}">
	                            		<g:set var="isRed" value="true"/>
	                            	</g:if>
	                            </g:each>
	                            <g:each in="${typeMemebers}">
	                            <g:if test="${it == "CONSUM_LUDIC"}">
	                            		<g:set var="isGrey" value="true"/>
	                            	</g:if>
	                            	<g:if test="${it == "CONSUM_THERAPEUTIC"}">
	                            		<g:set var="isBlue" value="true"/>
	                            	</g:if>

	                            </g:each>

	                            


	                            	<div class="col-lg-2">
	                            		<g:img dir="css/img" file="semaforoVerde.jpg"/>
	                            		<g:if test="${isGreen == 'true'}">
	                            			<input type="checkbox" class="statusChecks" checked name="greenStatus"  />
	                            		</g:if>
	                            		<g:else>
	                            			<input type="checkbox" class="statusChecks" name="greenStatus"  />
	                            		</g:else>
	                            	</div>
	                            	<div class="col-lg-2">
	                            		<g:img dir="css/img" file="semaforoAmarillo.jpg"/>
	                            		<g:if test="${isYellow == 'true'}">
	                            			<input type="checkbox" class="statusChecks" checked name="yellowStatus"  />
	                            		</g:if>
	                            		<g:else>
	                            			<input type="checkbox" class="statusChecks" name="yellowStatus"  />
	                            		</g:else>
	                            	</div>
	                            	<div class="col-lg-2">
	                            		<g:img dir="css/img" file="semaforoNaranja.jpg"/>
	                            		<g:if test="${isOrange == 'true'}">
	                            			<input type="checkbox" class="statusChecks" checked name="orangeStatus"  />
	                            		</g:if>
	                            		<g:else>
	                            			<input type="checkbox" class="statusChecks" name="orangeStatus"  />
	                            		</g:else>
	                            	</div>
									<div class="col-lg-2">
	                            		<g:img dir="css/img" file="semaforoRojo.jpg"/>
	                            		<g:if test="${isRed == 'true'}">
	                            			<input type="checkbox" class="statusChecks" checked name="redStatus"  />
	                            		</g:if>
	                            		<g:else>
	                            			<input type="checkbox" class="statusChecks" name="redStatus"  />
	                            		</g:else>
	                            	</div>
	                            	<div class="col-lg-2">
	                            		<div class="therapeuticDiv"></div>
	                            		<g:if test="${isBlue == 'true'}">
	                            			<input type="checkbox" class="statusChecks" checked name="thrapeuticStatus"  />
	                            		</g:if>
	                            		<g:else>
	                            			<input type="checkbox" class="statusChecks" name="thrapeuticStatus"  />
	                            		</g:else>
	                            	</div>
	                            		<div class="col-lg-2">
	                            		<div class="ludicDiv"></div>
	                            		<g:if test="${isGrey == 'true'}">
	                            			<input type="checkbox" class="statusChecks" checked name="ludicStatus"  />
	                            		</g:if>
	                            		<g:else>
	                            			<input type="checkbox" class="statusChecks" name="ludicStatus"  />
	                            		</g:else>
	                            	</div>

	                            	

	                            </div>

	                            
			              </g:form>
			        </div>
			        <div class="row">
			        	<h4><b>TOTAL DE USUARIOS: ${listMembers?.totalCount}</b></h4>

				 		<table class="table table-bordered table-condensed">
				 			<thead>
				 				<tr>
					 				<th>Nº de Socio</th>
					 				<th>Nombre</th>
					 				<th>DNI</th>
					 				<th>Estado</th>
					 				<th>Acciones</th>
					 				<th></th>
				 				</tr>
				 			</thead>
				 			<tbody>
				 				<g:if test="${listMembers}">
				 						<g:each in="${listMembers}">
				 							<tr>
				 								<td style="vertical-align:middle">${it.code}</td>
				 								<td style="vertical-align:middle">${it.firstname} ${it.lastname}</td>
				 								<td style="vertical-align:middle">${it.identificationNumber}</td>
				 								<td style="vertical-align:middle">
				 									<g:if test="${it.status?.name() == 'PARTNER_STATUS__ACTIVED'}">
				 										<g:img dir="css/img" file="semaforoVerde.jpg"/>
				 									</g:if>
				 									<g:elseif test="${it.status?.name() == 'PARTNER_STATUS__DISABLED'}">
				 										<g:img dir="css/img" file="semaforoAzul.jpg "/>
				 									</g:elseif>
				 									<g:elseif test="${it.status?.name() == 'PARTNER_STATUS__BANNED'}">
				 										<g:img dir="css/img" file="semaforoRojo.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${it.status?.name() == 'PARTNER_STATUS__DETOXIFIED'}">
				 										<g:img dir="css/img" file="semaforoNaranja.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${it.status?.name() == 'PARTNER_STATUS__UNKNOWN'}">
				 										<g:img dir="css/img" file="semaforoAmarillo.jpg"/>
				 									</g:elseif>
				 									<g:elseif test="${it.status?.name() == 'PARTNER_STATUS__INVITE'}">
				 										<g:img dir="css/img" file="semaforoLila.jpg"/>
				 									</g:elseif>
				 								</td>
				 								<td>
				 									<a class="btn btn-primary" href="${createLink(controller:'member', action:'showEdit', params:[memberId:it.id])}">
				 										Editar
				 									</a>
				 									<a class="btn btn-danger deleteMember" id="${it.id}" >
				 										Eliminar
				 									</a>
				 								</td>

				 								<td>
				 									<g:if test="${it.consum?.name() == 'CONSUM_THERAPEUTIC'}">
				 										<div class="therapeuticDiv"></div>
				 									</g:if>
				 									<g:else>
				 										<div class="ludicDiv"></div>
				 									</g:else>

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
   ManagementMember.init();
	$('.next').click(function(){
		if (!$(this).hasClass('disabled')){
			var auxOffset = ${offset};
			auxOffset = auxOffset+ 50;
			window.location.replace('/gestionar-usuarios?offset='+auxOffset);
		}
	});
	$('.back').click(function(){
		if (!$(this).hasClass('disabled')){
			var auxOffset = ${offset};
			auxOffset = auxOffset- 50;
			window.location.replace('/gestionar-usuarios?offset='+auxOffset);
		}
	});

	$('.statusChecks').change(function() {
		$('#myForm').submit();
	});

});
</script>
</body>

<!-- END BODY -->
</html>