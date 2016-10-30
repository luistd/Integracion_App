function eliminarArticulo(codigo){				
     $.ajax({
        type: 'post',
        url: 'eliminar-articulo',
        data: codigo,
        contentType: "application/json; charset=utf-8",
        traditional: true,
        success: function (data) {
        	if(data){
        		$("#articulo_"+codigo).remove();
        		$("#mensajeOk").find("b").html("Artículo eliminado.");
        		$("#mensajeOk").show();
        		$("#mensajeError").hide();
        	}else{
        		$("#mensajeError").find("b").html("Error al eliminar el artículo.");
        		$("#mensajeError").show();
        		$("#mensajeOk").hide();
        	}
        }
    });
}