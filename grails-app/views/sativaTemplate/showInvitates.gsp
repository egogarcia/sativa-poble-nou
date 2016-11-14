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
				 <div class="row well">
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'searchInvitate',controller:'member']" >
	                            <div class="row">
	                            	<div class="col-lg-3">
	                            		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Nombre</label>
	                              			<div class="col-lg-9">
	                               	 			<input type="text" class="form-control" name="firstname" />
	                              			 </div>
	                               			
	                            		</div>
	                            	</div>
	                            	<div class="col-lg-3">
	                             		<div class="form-group">
	                              			<label class="col-lg-3 control-label">Apellidos</label>
	                              			<div class="col-lg-9">
			                               	 <input type="text" class="form-control" name="lastname" />
			                               </div>
			                               
			                            </div>
	                            	</div>
	                              	<div class="col-lg-3">
	                              		<div class="form-group">
	                              		   <label class="col-lg-3 control-label">DNI</label>
	                              		   <div class="col-lg-9">
		                               		 <input type="text" class="form-control" name="identificationNumber" />
		                               		</div>
		                               		
		                               	</div>
		                             </div>
		                             <div class="col-lg-2">
		                             	<div class="form-group">
	                            			<input type="submit" class="btn btn-success" value="Buscar" />
										</div>
		                            </div>
	                            </div>
	                            
			              </g:form>
			        </div>
			       <h4><b>TOTAL DE SOCIOS INVITADOS, SIN DERECHO A CONSUMIR: ${listInvitates?.size()}</b></h4>
			        <div class="row">
				 		<table id="tableGuests" class="table table-bordered table-condensed" >
				 			<thead>
				 				<tr>
				 					<th>#</th>
				 					<th></th>
					 				<th>Nombre</th>
					 				<th>DNI</th>
					 				<th>Fecha de entrada</th>
					 				<th>Invitado por</th>
					 				<th>#Entrada</th>
				 				</tr>
				 			</thead>
				 			<tbody>
				 				<g:if test="${historicGuests}">
				 						<g:each in="${historicGuests}" var="mem" status="i">
				 							<tr > 
				 								<td class="valignInvitate">
				 									<g:if test="${offset}">
				 										${(i+1)+offset} ${mem.guest.code}
				 									</g:if>
				 								</td>
				 								<td style="text-align:center">
				 									<g:if test="${mem.guest.image}">
										 				<%
					 										def guestImage
					 										try {
																def imageAux		  = ImageIO.read(new File("/usr/sativaImages/partners/"+mem.guest.image));
																ByteArrayOutputStream bos = new ByteArrayOutputStream();
															 	ImageIO.write(imageAux, "png", bos);
																byte[] imageBytes	  = bos.toByteArray();
																BASE64Encoder encoder = new BASE64Encoder();
													        	guestImage = encoder.encode(imageBytes);
													        }catch(all){}
					 									%>

										 				<img src="data:image/png;base64,${guestImage}" id="${mem.guest.image}" class="seeImage" width="50" height="50"/></a>
											 		</g:if>
											 		<g:else>
														<g:img dir="css/img" id="avatar.png" class="seeImage" file="avatar.png" width="200"/>
								 					</g:else>
				 								</td>
				 								<td class="valignInvitate"> ${mem.guest.firstname} ${mem.guest.lastname}</td>
				 								<td class="valignInvitate">${mem.guest.identificationNumber}</td>
				 								<td class="valignInvitate">${mem.entry}</td>
				 								<td class="valignInvitate">${mem.friend.firstname} ${mem.friend.lastname}</td>
				 								<td class="valignInvitate">${mem.numberEntries}
				 									<g:if test="${mem.numberEntries >= 5}">
				 										<g:img dir="images/imageSativa"  file="warning.png" width="20" height="20"/>
				 									</g:if>
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
				 				<span class="backGuest disabled">< Atras</span> 
				 			</g:if>
				 			<g:else> 
								<span class="backGuest ">< Atras</span> 
				 			</g:else>
				 			<g:if test="${historicGuests.size() < 50}">
				 				<span class="nextGuest disabled">Siguiente > </span>	
				 			</g:if>
				 			<g:else>
				 				<span class="nextGuest">Siguiente > </span>
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
   $('.seeImage').mouseover(function(){
   		var imgSrc = $(this).attr('src')
  		$("#showImageTop").html('<img src="'+imgSrc+'" />');
  		$('#showImageTop').removeClass('hide');
	});
   $('.seeImage').mouseout(function(){
   		$('#showImageTop').addClass('hide');
	});

   $('.nextGuest').click(function(){
   		if (!$(this).hasClass('disabled')){
   			var auxOffset = ${offset};
   			auxOffset = auxOffset + 50;
   			window.location.replace('/invitados?offset='+auxOffset);
   		}
   });
    $('.backGuest').click(function(){
   		if (!$(this).hasClass('disabled')){
   			var auxOffset = ${offset}
   			auxOffset = auxOffset - 50;
   			window.location.replace('/invitados?offset='+auxOffset);
   		}
   });
});
</script>
</body>

<!-- END BODY -->
</html>
<div id="showImageTop" class="hide">
	
</div>