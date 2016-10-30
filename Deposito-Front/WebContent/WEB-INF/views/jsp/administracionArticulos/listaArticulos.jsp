<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Dep�sito</title>
		<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
	</head>
	
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Lista de Art�culos</a>
			</div>
		  </div>
		</nav>
		
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="margin-bottom:20px;">
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 pull-right">
				<a class="btn btn-primary btn-block btn-primary" href="#" role="button">
					<span class="glyphicon glyphicon-filter" aria-hidden="true"></span>
					Buscar
				</a>
			</div>
		</div>

		<div class="col-sm-8 col-md-8 col-lg-8 col-md-offset-2">
			<table id="listaArticulos" class="table table-striped">
				<thead>
					<tr>
						<th>C�digo</th>
						<th>Nombre</th>
						<th>Descripci�n</th>
						<th>Precio</th>
						<th>Marca</th>
						<th>Origen</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${articulos}" var="articulo">
						<tr id="articulo_${articulo.codigo}">
							<td>${articulo.codigo}</td>
							<td>${articulo.nombre}</td>
							<td>${articulo.descripcion}</td>
							<td>${articulo.precio}</td>
							<td>${articulo.marca.nombre}</td>
							<td>${articulo.origen.nombre}</td>
							<td>
								<span class="glyphicon glyphicon-pencil" aria-hidden="true" style="font-size:20px; cursor:pointer"></span>
								<span class="glyphicon glyphicon-trash" aria-hidden="true" style="font-size:20px; cursor:pointer" onClick="eliminarArticulo('${articulo.codigo}');"></span>
							</td>
						</tr>					
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>		
		<script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/listaArticulos.js"></script>
	</body>
</html>