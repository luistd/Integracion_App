<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="boxBorder"> 
	<form id="formularioArticulo" name="articulo">
	  	<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<label>C�digo</label>
			<input name="codigo" class="form-control form-group"/>
		</div>
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<label>Nombre</label>
			<input name="nombre" class="form-control form-group"/>
		</div>
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<label>Descripci�n</label>
			<input name="descripcion" class="form-control form-group"/>
		</div>
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<label>Precio</label>
			<input name="precio" class="form-control form-group"/>
		</div>
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<label>Marca</label>
			<select name="marca" class="form-control form-group">
				<c:forEach items="${marcas}" var="marca">
					<option value="${marca.id}">${marca.nombre}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
			<label>Origen</label>
			<select name="origen" class="form-control form-group">
				<c:forEach items="${paises}" var="pais">
					<option value="${pais.id}">${pais.nombre}</option>
				</c:forEach>
			</select>
		</div>
		
		<jsp:include page="datosElectrodomesticosArticulo.jsp" />
		<jsp:include page="datosModaArticulo.jsp" />
		<jsp:include page="datosMuebleArticulo.jsp" />
		<jsp:include page="datosNiniosArticulo.jsp" />
	</form>
	
	
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="top:52px; padding:0px">
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 pull-right boton-articulo">
			<a class="btn btn-primary btn-block btn-primary next" href="#" role="button">
				Siguiente &#62;
			</a>
		</div>
		<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 pull-right boton-articulo">
			<a class="btn btn-primary btn-block btn-primary previous" href="#" role="button">
				&#60; Anterior 
			</a>
		</div>
	</div>
</div>