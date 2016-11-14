<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="row">
				 	<div class="col-lg-4"></div>
				 	<div class="col-lg-4 well">
				 		<g:if test="${error}">
				 			<div class="alert alert-danger">${error}</div>
				 		</g:if>
				 		<form class="form-vertical" method="POST" name="formPrescriptors" action="/j_spring_security_check" id="1">
						 
	                            <div class="form-group">
	                              <label>Colaborador</label>
	                                <input type="text" class="form-control" name="j_username" />
	                                <div class="wsperror firstname_error hide"></div>
	                            </div>
	                            <div class="form-group">
	                              <label>Contraseña</label>
	                                <input type="password" class="form-control"  name="j_password">
	                                <div class="wsperror lastname_error hide"></div>
	                            </div>
	                            <div class="form-group">
	                            	<input type="submit" class="pull-right btn btn-success" value="Entrar" />
									
	                            </div>
			              </form>
	                </div>
	                <div class="col-lg-4"></div>
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
});
</script>
</body>

<!-- END BODY -->
</html>