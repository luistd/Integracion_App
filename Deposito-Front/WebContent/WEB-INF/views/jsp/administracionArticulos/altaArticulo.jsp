<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Dep�sito</title>
		<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	
	<style>
		.boxBorder {
			-webkit-box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
			-moz-box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
			height: 250px;
			padding-top: 10px;
		}
	</style>
	
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Alta de Art�culo</a>
			</div>
		  </div>
		</nav>
		
		<jsp:include page="../comunes/mensajesValidacion.jsp" />
		
		<div class="container" style="padding-top: 100px">  
	    	<div class="progress">
	     		<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 20%;">Paso 1 de 3</div>
  			</div>
  
			<div class="navbar" style="margin-bottom: 0px">
			   <div class="navbar-inner">
			         <ul class="nav nav-pills">
			            <li class="active"><a href="#step1" data-toggle="tab" data-step="1">Categor�a</a></li>
			            <li><a href="#step2" data-toggle="tab" data-step="2">Datos Generales</a></li>
			            <li><a href="#step3" data-toggle="tab" data-step="3">Stock</a></li>
			         </ul>
			   </div>
			</div>

			<div class="tab-content">
				<div class="tab-pane fade in active" id="step1">
					<jsp:include page="categoriaArticulo.jsp" />
				</div>
			   
				<div class="tab-pane fade" id="step2">
					<jsp:include page="datosGeneralesArticulo.jsp" />
				</div>
				
				<div class="tab-pane fade" id="step3">
					<jsp:include page="stockArticulo.jsp" />
				</div>
			</div>
		</div>
				
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>		
		<script src="resources/js/vista/bootstrap.min.js"></script>
		<script src="resources/js/negocio/altaArticulo.js"></script>
	</body>
</html>