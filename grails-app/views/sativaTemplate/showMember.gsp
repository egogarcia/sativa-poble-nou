<!DOCTYPE html>

	<g:render template="/sativaTemplate/menuTemplate" model="${username}" />
	<script src="${resource(dir:'js/scriptsSativa', file: 'signature.js')}" type="text/javascript"></script>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
				 <div class="container-fluid">
				 	<div class="alert  hide alert-danger" id="alertDanger"></div>
				 	<div class="row" id="divShowMember">
				 		<div class="col-lg-3">
				 			<g:if test="${member.image}">
				 			<img src="data:image/png;base64,${imagePerson}" width="225" height="180"/>
					 		</g:if>
					 		<g:else>
								<g:img dir="css/img" file="avatar.png" width="200"/>
					 		</g:else>
					 		<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
				 			 	<a href="#disabledMember" class="btn btn-block btn-danger" data-toggle="modal" class="config">Desactivar socio</a>
				 			
				 				<g:if test="${member.status.name() != 'PARTNER_STATUS__INVITE'}">
				 			 		<a href="#renovationMember" id="renovationMemberBtn" class="btn  btn-block btn-primary" data-toggle="modal" class="config">Pagar cuota</a>
				 			 	</g:if>
				 			 	<g:form name="myForm" id="formFriend" role="form"  class="form-horizontal" url="[action:'invite',controller:'member']" >
				 			 		<input type="hidden" name="memberId" value="${member.id}" />
				 			 		<g:if test="${member.status.name() != 'PARTNER_STATUS__INVITE'}">
				 			 			<button type="submit" class="btn btn-block  btn-warning">Invitar a un amigo</button>
				 			 		</g:if>
				 				 </g:form>
				 			</g:if>
				 			
				 			<g:if test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
				 				<sec:ifAllGranted roles="ROLE_ADMIN">
				 			 		<a href="#disabledMember" class="btn btn-block  btn-success" data-toggle="modal" class="config">Activar socio</a>
				 			 	</sec:ifAllGranted>
				 			</g:if>

				 			<div class="showCards">
				 			<g:if test="${yellowCard > 0}">
					 			<g:each in="${1..yellowCard}">
					 				<div>
						 				<g:img dir="css/img" file="yellowCard.jpg" width="50"/>
					 				</div>
					 			</g:each>
							</g:if>
				 			</div>

				 			 
				 			
				 		</div>
				 		<div class="col-lg-5">
							<p><b>Numero de socio:</b> ${member.code}</p>
				 			<p><b>Nombre:</b> ${member.firstname}</p>
				 			<p><b>Apellidos:</b> ${member.lastname}</p>
				 			<p><b>DNI:</b>  ${member.identificationNumber}</p>
				 			<p><b>Domicilio:</b>  ${member.address}</p>
				 			<p><b>Teléfono:</b>  ${member.phone}</p>
				 			<p><b>Fecha de nacimiento:</b> <g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy" date="${member.birthday}"/> </p>
				 			<p><b>Fecha de inscripción:</b> <g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${member.dateCreated}"/> </p>
				 			<p><b>Última cuota:</b> <g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${member.dateRenovation}"/> </p>
				 			<p><b>Tarjeta:</b>  ${card?.code}</p>
				 			<p><b>Consumo:</b>  ${member.consum.getHumanName()}</p>
			 				<g:if test="${member.status.name() == 'PARTNER_STATUS__INVITE'}">
								<p><b>Invitado por:</b><br />${member.lastFriend().firstname} ${member.lastFriend().lastname}</p>
							</g:if>
				 		</div>
				 		<div class="col-lg-4">
				 			<video id="video" width="300" height="225" class="gapPhoto videoWebcam" autoplay></video>
				 			<a id="snap" class="btn btn-block btn-warning">
				 				<i class="icon-camera"></i>
				 				 HACER FOTO
				 			</a>
				            <div id="divCanvas"  class="hide" >  
				                <p><b>Imagen:</b></p>
				               <canvas name="canvas" id="canvas" width="310" height="200"></canvas>
				               <g:form name="myForm" id="formPhoto" role="form"  class="form-horizontal" url="[action:'photo',controller:'member']" >
				               		<input type="hidden" name="image" id="foto_canvas" value="">
				               		<input type="hidden" name="memberId" value="${member.id}" />
				               		<a id="savePhoto" class="btn btn-block btn-primary" >Guardar foto</a>
				           		</g:form>
				            </div>
				            <h2>Consumo</h2>
				            <p><b>Total mensual:</b> ${grams.monthly}g</p>
				            <p><b>Total anual:</b> ${grams.anualy}g</p>
				            <h2>Histórico</h2>
				            <g:if  test="${listCustomEvents.size() == 0}">
					 			No hay comentarios
					 		</g:if>
					 		<g:else>
					            <table id="tableHistoricCustom" class="table table-bordered table-condensed">

						 			<g:each in="${listCustomEvents}">
						 				<tr><td class="center"><b>${it.writer}</b><br /><small><g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/></small></td>
						 				<td class="alignTd" >${it.observation}</td>	
						 				<td class="alignTd"><a href="${createLink(controller:'event', action:'removed', params:[eventId:it.id, partnerId:member.id])}"><img width="20" src="/css/img/delete-genetic.png"></a></td>
						 				</tr>
						 			</g:each>
					 			</table>
				 			</g:else>	
				 		</div>
				 	</div>
				 	<g:if test="${(member.status.name() != 'PARTNER_STATUS__INVITE' && member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED') || grams.monthly > 90.00 }">
				 
					 
				 	<div class="row" id="listActiveGenetics">
				 			<g:each in="${listGenetics}">
					 			<a  style="background-color:${it.type.color};border-color:${it.type.color};"  id="genetic_${it.id}" price="${it.type.price}" class="geneticAdd btn btn-success btn-lg"> ${it.name}</a>
					 		</g:each>
				 		
				 	</div>
				 	<hr />
				 	
				 	<div class="row">
				 		<div class="col-lg-11">
						 	<div class="row" id="divBill">
						 		<div id="resumBill"></div>
						 		<div class="pull-right" id="resumBillTotal"></div>
						 			<img id="saveSignature" src="" class="hide imagenGenerada">
						 			<input type="hidden" name="memberId" value="${member.id}" />
						 			<input type="hidden" name="signature" id="firma_canvas" value="">
						 			<a id="signElectric" class="btn btn-primary" disabled>Firma elctrónica</a>
						 	</div>
					 	</div>
				 	</div>
				 	</g:if>
				 	<div class="row">
				 		<g:cookie name="myCookie" />
				 		<h3>Historial del usuario</h3>
				 		<g:form name="myForm" role="form"  class="form-horizontal" url="[action:'create',controller:'event']" >
					 		<textarea  name="observation" class="textareaHistoric"></textarea>
					 		<input type="hidden" name="partnerId" value="${member.id}" />
					 		<input type="submit" class="btn btn-success" value="Publicar comentario" />
				 		</g:form>
				 		<table id="tableHistoric" class="table table-bordered table-condensed">
				 			<g:each in="${listEvents}">
				 				
				 				<tr><td class="center"><b>${it.writer}</b><br /><small><g:formatDate timeZone="${TimeZone.getTimeZone('Europe/Madrid')}" format="dd-MM-yyyy HH:mm" date="${it.dateCreated}"/></small></td>
				 					<g:if test="${it.type.name() == 'EVENT_TYPE__ACTIVATE'}"><td class="textGreen"></g:if>
				 					<g:elseif test="${it.type.name() == 'EVENT_TYPE__DISABLED'}"><td class="textRed"></g:elseif>
				 					<g:elseif test="${it.type.name() == 'EVENT_TYPE__RENOVATE'}"><td class="textBlue"></g:elseif>
				 					<g:else><td ></g:else>
				 					${it.observation}</td>
				 					
				 				</tr>
				 			</g:each>
				 		</table>
				 	</div>
				 </div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->

<div class="modal fade" id="disabledMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED'}">
					<h4 class="modal-title">DESACTIVAR SOCIO</h4>
				</g:if>
				<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
	 			 	<h4 class="modal-title">ACTIVAR SOCIO</h4>
	 			</g:elseif>
			</div>
			
			<g:set var="controllerBtn" value="" />
			<g:set var="actionBtn" value="" />
			<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
				<g:set var="actionBtn" value="remove" />
			</g:if>
			<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
				<g:set var="actionBtn" value="activate" />
			</g:elseif>

		
			<g:form name="myForm" role="form"  class="form-horizontal" url="[controller:'member', action:actionBtn ]" >
				<div class="modal-body">
					<input type="hidden" name="memberId" value="${member.id}" />
					 <g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
						 <p>¿Estas seguro que quieres desactivarlo?.<br /> Escribe el motivo de la baja</p>
						 <textarea name="observation" id="textareaDisabled"></textarea>
					 </g:if>
					 <g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
		 			 	 <p>¿Estas seguro que quieres reactivarlo?.</p>
		 			</g:elseif>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<g:if test="${member.status.name() != 'PARTNER_STATUS__BANNED' && member.status.name() != 'PARTNER_STATUS__DISABLED' }">
						<input type="submit" class="btn btn-danger" value="Desactivar" />
					</g:if>
					<g:elseif test="${member.status.name() == 'PARTNER_STATUS__BANNED'}">
						<input type="submit" class="btn btn-success" value="Activar" />
					</g:elseif>
				</div>
			</g:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<div class="modal fade" id="renovationMember" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				 <h4 class="modal-title">RENOVAR SOCIO</h4>
			</div>
			
			<g:set var="controllerBtn" value="" />
			<g:set var="actionBtn" value="" />
			
			<g:form name="myForm" role="form"  class="form-horizontal" url="[controller:'member', action:'renovation']" >
				<div class="modal-body">
					<input type="hidden" name="memberId" value="${member.id}" />
					<p>¿Estas seguro que quieres renovarlo?.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<input type="submit" class="btn btn-primary" value="Renovar" />
				</div>
			</g:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>

<div class="modal fade" id="notificationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				 <h4 class="modal-title">ÚLTIMO MENSAJE <small id="dateNotification"></small></h4>
			</div>
			
			<g:set var="controllerBtn" value="" />
			<g:set var="actionBtn" value="" />
			
			<g:form name="myForm" role="form"  class="form-horizontal" url="[controller:'event', action:'viewed']" >
				<div class="modal-body">
					<input type="hidden" name="partnerId" value="${member.id}" />
					<input type="hidden" id="eventId" name="eventId" value="" />
					<p id="messageText"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Ignorar</button>
					<input type="submit" class="btn btn-primary" value="Aceptar" />
				</div>
			</g:form>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>


<div id="scrennEncima" class="hide">
    <div id="canvasFirma">
        <canvas class="roundCorners" id="newSignature" width="1000" height="500"></canvas>
        <script>signatureCapture();</script>
        <button type="button" class="btn btn-success" id="generarFirma" onclick="signatureSave()">guardar firma</button>
        <button type="button" class="btn btn-danger" id="limpiarFirma" onclick="signatureClear()">borrar firma</button>
        
    </div>
</div>

<div class="footer">
	<div class="footer-inner">
		 2014 &copy; Sativa
	</div>
</div>

<g:render template="/sativaTemplate/scriptsTemplate"  />
<script>
jQuery(document).ready(function() { 
   var carroGenetics = [];   
   var carroObject	 = [];

 
   App.init(); // initlayout and core plugins
   if ("${grams.monthly}" > 90 || "${member.status.name()}" == 'PARTNER_STATUS__BANNED' || "${member.status.name()}" == 'PARTNER_STATUS__DISABLED') {
   		$('#divShowMember').css("border", "red solid 2px").css("padding", 20); 
   }
   if ("${grams.monthly}" > 90) {
   		$('#listActiveGenetics').html("<h4 style='color:red'>Este socio ya ha retirado mas de 90gr</h4>");
   }

   

   $('#savePhoto').click(function() {
   		$('#formPhoto').submit()
   		$('#divCanvas').addClass('hide');

   });


   if ("${notification}" != "") {
   		var dateCreatedNotification = new Date("${notification?.dateCreated}");
   		$('#dateNotification').html(dateCreatedNotification.toLocaleString());
   		$('#eventId').val("${notification?.id}");
   		$('#messageText').html("${notification?.observation}");
   		$('#notificationModal').modal('show');
	}
  
	$('.geneticAdd').click(function() {
		$('#signElectric').removeAttr('disabled');
		var priceUnit = parseFloat($(this).attr('price'))
		var auxId = $(this).attr('id').split('_')[1];
		var numCount = 0
		var auxPrice = parseFloat(0)
		$('#resumBill').html("");

		if( $.inArray(auxId, carroGenetics) != -1) {
			carroObject[$.inArray(auxId, carroGenetics)].amount++
			carroObject[$.inArray(auxId, carroGenetics)].price = (carroObject[$.inArray(auxId, carroGenetics)].amount*priceUnit).toFixed(2)
		}
		else {
			carroGenetics.push(auxId)
			carroObject.push({geneticId:auxId, amount:1, price:priceUnit});				
		}

		$.each(carroObject, function(key, value) {
			auxPrice += parseFloat(value.price)
			numCount += value.amount;
			var contentLabel = '<p class="label label-success"><b>'+$('#genetic_'+value.geneticId).html()+' x'+value.amount+'</b> <img id="geneticClose_'+value.geneticId+'" class="removeGenetic" src="/images/imageSativa/botonBorrar.png"</p>'
			if ($('#resumBill .label-success').length%4 ==0 && $('#resumBill .label-success').length > 1){
				contentLabel += "<p></p><br />"
			}
			$('#resumBill').append(contentLabel);
		});
		$('#resumBillTotal').html("<b>TOTAL= "+numCount+"</b>");

	
	})

	$('#resumBill').on('click', '.removeGenetic', function(e) {
			
			var idAux = $(this).attr('id').split('_')[1];
			var indexGenetic = $.inArray(idAux, carroGenetics);
			var numCount = 0
			var auxPrice = parseFloat(0)
			carroGenetics.splice(indexGenetic,1);
			carroObject.splice(indexGenetic,1);

			$('#resumBill').html("");
			$.each(carroObject, function(key, value) {
				auxPrice += parseFloat(value.price)
				numCount += value.amount;
				$('#resumBill').append('<p class="label label-success"><b>'+$('#genetic_'+value.geneticId).html()+' x'+value.amount+'</b> <img id="geneticClose_'+value.geneticId+'" class="removeGenetic" src="/images/imageSativa/botonBorrar.png"</p>');
			});
			$('#resumBillTotal').html("<b>TOTAL= "+numCount+"</b>");
		});

	$('#signElectric').click(function() {
		$("html, body").animate({ scrollTop: 0 }, "slow");
		$("#scrennEncima").removeClass('hide');
		$('#saveSignature').removeClass('hide');
	});



	$("#generarFirma").click(function() { 
        $("#scrennEncima").addClass('hide');
        $('#registerBuy').removeAttr('disabled');
        var listGenetics =""
		var listAmount	 =""
		$.each(carroObject, function(key, value) {
			listGenetics += value.geneticId
			listAmount	 += value.amount
			if (key+1 != carroObject.length) {
				listGenetics +=',';
				listAmount +=',';
			}
		})

		var params = '{"memberId":"${member.id}", "signature":"'+$('#firma_canvas').val()+'","listGenetics":"'+listGenetics+'","listAmount":"'+listAmount+'"}'
		
		params = $.parseJSON(params);
		$.ajax({
			cache: false,
			data: params,
			type: 'POST',
			url: '/geneticOrders/create?time='+new Date().getTime(),
			dataType:'json',
			success: function(data) {
				if (data == "success") window.location.reload()
				else  {
					$('#alertDanger').html(data);
   					$('#alertDanger').removeClass('hide');
				}
			},
			error: function(jqXHR, textStatus, errorThrown){
				var jdata = jqXHR.responseText
				if (jdata == "success") window.location.reload()
				else  {
					$('#alertDanger').html(jdata);
   					$('#alertDanger').removeClass('hide');
				}
			},
			xhrFields: {
				withCredentials: true
			}
		});
    });   

	





    // Put event listeners into place
    window.addEventListener("DOMContentLoaded", function() {
        // Grab elements, create settings, etc.
        var canvas = document.getElementById("canvas"),
            context = canvas.getContext("2d"),
            video = document.getElementById("video"),
            videoObj = { "video": true },
            errBack = function(error) {
                console.log("Video capture error: ", error.code); 
            };
    
        // Put video listeners into place
        if(navigator.getUserMedia) { // Standard
            navigator.getUserMedia(videoObj, function(stream) {
                video.src = stream;
                video.play();
            }, errBack);
        } else if(navigator.webkitGetUserMedia) { // WebKit-prefixed
            navigator.webkitGetUserMedia(videoObj, function(stream){
                video.src = window.webkitURL.createObjectURL(stream);
                video.play();
            }, errBack);
        } else if(navigator.mozGetUserMedia) { // WebKit-prefixed
            navigator.mozGetUserMedia(videoObj, function(stream){
                video.src = window.URL.createObjectURL(stream);
                video.play();
            }, errBack);
        }
    
        document.getElementById("snap").addEventListener("click", function(e) {
        	$('#divCanvas').removeClass('hide');
            context.drawImage(video, 0, 0, 310, 200);
            var jpegUrl = canvas.toDataURL("image/jpeg");
            document.getElementById('foto_canvas').value = jpegUrl.split(',')[1];
            e.preventDefault(); 
        });
    }, false);

});
</script>
</body>

<!-- END BODY -->
</html>