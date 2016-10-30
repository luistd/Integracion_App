function guardarArticulo(){
	var articulo = {};
	articulo.codigo = $("#formularioArticulo [name='codigo']").val();
	articulo.nombre = $("#formularioArticulo [name='nombre']").val();
	articulo.descripcion = $("#formularioArticulo [name='descripcion']").val();
	articulo.precio = $("#formularioArticulo [name='precio']").val();
	var marca = {};
	marca.id = $("#formularioArticulo [name='marca'] option:selected").val();
	marca.nombre = $("#formularioArticulo [name='marca'] option:selected").text();
	articulo.marca = marca;
	
	var origen = {};
	origen.id = $("#formularioArticulo [name='origen'] option:selected").val();
	origen.nombre = $("#formularioArticulo [name='origen'] option:selected").text();
	articulo.origen = origen;
	
	var categoria = {};
	categoria.id = $("#categoria_articulo option:selected").val();
	articulo.categoria = categoria;
	
	var categoria = $("#categoria_articulo option:selected").text();
	if(categoria == 'Electrodom\u00e9sticos'){
		//articulo.fichaTecnica = $("");
	}else if(categoria == 'Moda'){
		articulo.color = $("#formularioArticulo [name='color']").val();
		articulo.talle = $("#formularioArticulo [name='talle']").val();
	}else if(categoria == 'Muebles'){
		articulo.material = $("#formularioArticulo [name='material']").val();
	}else if(categoria == 'Ni\u00f1os'){
		articulo.edadRecomendada = $("#formularioArticulo [name='edadRecomendada']").val();
	}
	
	
     $.ajax({
        type: 'post',
        url: 'guardar-articulo',
        data: JSON.stringify(articulo),
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: function (data) {
        	agregarArticuloATabla(articulo);
        }
    });
}

function seleccionCategoria(){
	var categoria = $("#categoria_articulo option:selected").text();
	if(categoria == 'Electrodom\u00e9sticos'){
		$("#categoria_electrodomestico, #boton_siguiente_categoria").show();
		$("#categoria_moda, #categoria_mueble, #categoria_ninios").hide().find("input").val("");
	}else if(categoria == 'Moda'){
		$("#categoria_moda, #boton_siguiente_categoria").show();
		$("#categoria_electrodomestico, #categoria_mueble, #categoria_ninios").hide().find("input").val("");
	}else if(categoria == 'Muebles'){
		$("#categoria_mueble, #boton_siguiente_categoria").show();
		$("#categoria_electrodomestico, #categoria_moda, #categoria_ninios").hide().find("input").val("");
	}else if(categoria == 'Ni\u00f1os'){
		$("#categoria_ninios, #boton_siguiente_categoria").show();
		$("#categoria_electrodomestico, #categoria_moda, #categoria_mueble").hide().find("input").val("");
	}else{
		$("#boton_siguiente_categoria").hide();
	}
}

$('.next').click(function() {
	var nextId = $(this).parents('.tab-pane').next().attr("id");
	$('[href=#' + nextId + ']').tab('show');
	return false;
});

$('.previous').click(function() {
	var prevtId = $(this).parents('.tab-pane').prev().attr("id");
	$('[href=#' + prevtId + ']').tab('show');
	return false;
});

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
	//update progress
	var step = $(e.target).data('step');
	var percent = (parseInt(step) / 3) * 100;

	$('.progress-bar').css({
		width : percent + '%'
	});
	$('.progress-bar').text("Paso " + step + " de 3");
	//e.relatedTarget // previous tab
});

$('.first').click(function() {
	$('#myWizard a:first').tab('show')
});