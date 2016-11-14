<!-- 
Template Name: Conquer - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.2.0
Version: 2.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/conquer-responsive-admin-dashboard-template/3716838?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>Administracion Sativa</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<meta name="MobileOptimized" content="320">
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>


<link rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/font-awesome/css', file: 'font-awesome.min.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/simple-line-icons', file: 'simple-line-icons.min.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/bootstrap/css', file: 'bootstrap.min.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/uniform/css', file: 'uniform.default.css')}" />
<link  rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/bootstrap-daterangepicker', file: 'daterangepicker-bs3.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/fullcalendar/fullcalendar', file: 'fullcalendar.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'js/pluginsSativa/jqvmap/jqvmap', file: 'jqvmap.css')}" />

<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss', file: 'style-conquer.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss', file: 'style.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss', file: 'style-responsive.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss', file: 'plugins.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss/pages', file: 'tasks.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss/themes', file: 'default.css')}" />
<link rel="stylesheet"  type="text/css" href="${resource(dir: 'css/sativaCss', file: 'custom.css')}" />


<!-- END THEME STYLES -->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<!-- BEGIN HEADER -->
<div class="header navbar navbar-fixed-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="header-inner">
		<ul class="nav navbar-nav pull-right">
			<li class="dropdown user">
				<a href="index.html#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<sec:ifLoggedIn>
						<span class="username username-hide-on-mobile">Bienvenid@ ${sec.loggedInUserInfo(field: 'username')} </span>
					</sec:ifLoggedIn>

				</a>
			</li>
			<!-- END USER LOGIN DROPDOWN -->
		</ul>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		
	</div>
	<div class="page-sidebar navbar-collapse collapse">
		<ul class="page-sidebar-menu">
			
			<div class="clearfix"></div>
			<li class="sidebar-search-wrapper">
				<form class="search-form" role="form" action="index.html" method="get">
					<div class="input-icon right">
						<i class="icon-magnifier"></i>
						<input type="text" class="form-control" name="query" placeholder="Search...">
					</div>
				</form>
			</li>
			<sec:ifLoggedIn>
				<li class="menuSearchMember">
					<g:link mapping="searchMember">
						<i class="icon-user"></i>
						<span class="title">Buscar socios</span>
					</g:link>
					
				</li>
				<li class="menuListInvite">
					<g:link mapping="listInvitate">
						<i class="icon-star"></i>
						<span class="title">Invitados</span>
					</g:link>
				</li>
				<sec:ifAllGranted roles="ROLE_ADMIN">
				<li class="menuManageMember">
					<g:link mapping="managementMembers">
						<i class="icon-settings"></i>
						<span class="title">Gestion de usuarios</span>
					</g:link>
				</li>
				

				<li class="menuManagerGenetics">
					<g:link mapping="managementGenetics">
					<i class="icon-tag"></i>
					<span class="title">Gestion de genéticas</span>
					</g:link>
				</li>
				<li class="menuStadistics">
					<g:link mapping="stadistics">
					<i class="icon-bar-chart"></i>
					<span class="title">Filtro estadísticas</span>
					</g:link>
				</li>
				<li class="menuManagerPartners">
					<g:link mapping="searchPartner">
					<i class="icon-users"></i>
					<span class="title">Socios colaboradores</span>
					</g:link>
				</li>
				</sec:ifAllGranted>
				<li class="last menuClass">

					<a href="${createLink(uri:'j_spring_security_logout')}">
						<i class="icon-close"></i>
						<span class="title">Desconectar</span>
					</a>
				</li>
			</sec:ifLoggedIn>
		</ul>
		<!-- END SIDEBAR MENU -->

		<a href="/buscar-socio"><img  src="${resource(dir:'css/img', file:'logo2.png')}" id="logo" alt="logo"/></a>	
	</div>