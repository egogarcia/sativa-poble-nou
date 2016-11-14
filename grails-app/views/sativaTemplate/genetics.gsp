<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
			<div class="container-fluid">
				<div class="row well">
			 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'create',controller:'genetic']" >
              <div class="row">
                <g:if test="${error}">
                  <div class="alert alert-danger">${error}</div>
                </g:if>
              	<div class="col-lg-4">
                  <div class="form-group">
                      <label class="col-lg-3 control-label">Nombre</label>
                      <div class="col-lg-9">
                        <input type="text" class="form-control" name="name" />
                       </div>
                      
                  </div>
                </div>
                <div class="col-lg-4">
                  <div class="form-group">
                      <label class="col-lg-3 control-label">Tipos genetico</label>
                      <div class="col-lg-9">
                       <select  class="form-control" name="type">
                          <g:each in="${listTypes}">
                            <option value="${it.id}">${it.name}</option>
                        </g:each>
                       </select>
                     </div>
                  </div>
                </div>
                <div class="col-lg-4 pull-right">
                  <div class="form-group pull-right" id="newGenetic">
                      <button class="btn btn-primary" type="submit" >Nueva genetica</button>
                  </div>
                </div>
          </g:form>
				</div>
        <hr />
				<div class="row">
          <ul class="nav nav-tabs" role="tablist">
              <li class="active"><a href="#tableListEnabledGenetics" role="tab" data-toggle="tab">Activar/Desactivar genéticas</a></li>
              <li><a href="#removeGenetics" role="tab" data-toggle="tab">Borrar genéticas</a></li>
          </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="tableListEnabledGenetics">
                  <g:set var="count" value="${1}" />
        					<table id="tableGenetics" class="table">
                    	<tr>
                          <g:each in="${listGenetics}">
                            <td>

                              <g:if test="${it.status.name()=='GENETIC_STATUS__ENABLED'}">
                                <a href="${createLink(controller:'genetic', action:'disabled', params:[geneticId:it.id])}">
                                  <g:img dir="css/img" file="publicado.png" />
                                </a>
                              </g:if>
                              <g:elseif test="${it.status.name()=='GENETIC_STATUS__DISABLED'}">
                                <a href="${createLink(controller:'genetic', action:'enabled', params:[geneticId:it.id])}">
                                  <g:img dir="css/img" file="despublicado.png" />
                                </a>
                              </g:elseif>
                              ${it.name} <a style="padding:5px;color:white;background-color:${it.type.color};border-color:${it.type.color};">${it.type.grams}g</a></td>                   
                              <g:if test="${count % 3 == 0 && count!=0}">
                                </tr><tr>
                              </g:if>
                            <g:set var="count" value="${count + 1}" />
                         </g:each>
                      </tr>
        					</table>
              </div>
              <div class="tab-pane" id="removeGenetics">
                     <g:set var="count" value="${1}" />
                  <table id="tableGenetics" class="table">
                      <tr>
                          <g:each in="${listGenetics}">
                            <td>

                              ${it.name} <a href="${createLink(controller:'genetic', action:'remove', params:[geneticId:it.id])}"><g:img width="20" dir="css/img" file="delete-genetic.png" /></a></td>                   
                              <g:if test="${count % 3 == 0 && count!=0}">
                                </tr><tr>
                              </g:if>
                            <g:set var="count" value="${count + 1}" />
                         </g:each>
                      </tr>
                  </table>
              </div>
          </div>

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

});
</script>
</body>

<!-- END BODY -->
</html>