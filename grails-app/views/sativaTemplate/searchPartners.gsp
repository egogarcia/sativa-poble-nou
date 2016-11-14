<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				<g:if test="${error}">
					<div class="alert alert-danger">${error}</div>
				</g:if>
				 <div class="row well">
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'add',controller:'partner']" >
	                            <div class="row">
	                            	<div class="col-lg-4">
	                            		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Login</label>
	                              			<div class="col-lg-9">
	                               	 			<input type="text" class="form-control" name="username" />
	                              			 </div>
	                               			
	                            		</div>
	                            	</div>
	                            	<div class="col-lg-4">
	                             		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Contraseña</label>
	                              			<div class="col-lg-9">
			                               	 <input type="password" class="form-control" name="password" />
			                               </div>
			                               
			                            </div>
	                            	</div>
	                              	<div class="col-lg-4">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">Repetir contraseña</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="password" class="form-control" name="repeatPassword" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                             <div class="col-lg-4">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">Nuevo colaborador</label>
	                              		   <div class="col-lg-9">
		                               		 <select id="selectParner" name="partnerId" class="form-control"><option>Selecciona el colaborador</option>
													<g:if test="${listMembers}">
									 						<g:each in="${listMembers}">
									 							<option value="${it.id}">
									 								${it.firstname} ${it.lastname}
									 							</option>
									 						</g:each>
									 				</g:if>
		                               		 </select>
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                             <div class="col-lg-4"></div>
		                             <div class="col-lg-2">
		                             	<div class="form-group">
	                            			<input id="btnNewPartner" type="submit" class="btn btn-success" value="Nuevo colaborador" />
										</div>
		                            </div>
	                            </div>
	                            
			              </g:form>
			        </div>
			        <div class="row">
				 		<table class="table table-bordered table-condensed">
				 			<thead>
				 				<tr>
					 				<th>Login</th>
					 				<th>Nombre</th>
					 				<th>Acabar colaboración</th>
				 				</tr>
				 			</thead>
				 			<tbody>
				 				<g:if test="${listPartners}">
				 						<g:each in="${listPartners}">
				 							<tr>
				 								<td>${it.username}</td>
				 								<td>${it.firstname} ${it.lastname}</td>
				 								<td>
				 									
				 									<a href="${createLink(controller:'partner', action:'remove', params:[partnerId:it.id])}">
				 										<g:img dir="css/img" file="borrar.jpg"/>
				 									</a>
				 								</td>
				 							</tr>
				 						</g:each>
				 				</g:if>
				 				<g:else>
				 					
				 				</g:else>
				 			</tbody>
				 		</table>
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


$('#selectParner').change(function() {
		var params = "id="+$('#selectParner').val();
   		$.ajax({
			cache: false,
			data: params,
			type: 'POST',
			url: '/partner/isFull?time='+new Date().getTime(),
			dataType:'json',
			success: function(data) {
				if(data != true){
					alert('Este usuario no esta activo del todo')
					$('#btnNewPartner').hide();
				}
				else {
					$('#btnNewPartner').show();	
				}
			},
			xhrFields: {
				withCredentials: true
			}
		});
	});
});
</script>
</body>

<!-- END BODY -->
</html>