<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="boxBorder"> 
    <div class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
		<label>Categoría</label>
		<select id="categoria_articulo" name="categoria" class="form-control form-group" onChange="seleccionCategoria();">
			<option value=""> - Seleccionar - </option>
			<c:forEach items="${categorias}" var="categoria">
				<option value="${categoria.id}">${categoria.nombre}</option>
			</c:forEach>
		</select>
	</div>
	<div id="boton_siguiente_categoria" class="col-xs-3 col-sm-3 col-md-3 col-lg-3 pull-right boton-articulo" style="display:none; top: 200px;">
		<a class="btn btn-primary btn-block btn-primary next" href="#" role="button">
			<span class="glyphicon" aria-hidden="true"></span>
			Siguiente &#62;
		</a>
	</div>
</div>