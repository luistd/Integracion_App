package com.facade;

import java.util.List;

import com.vo.ArticuloVO;
import com.vo.CategoriaVO;
import com.vo.MarcaVO;
import com.vo.PaisVO;
import com.vo.RecepcionCompraVO;
import com.vo.SolicitudArticulosVO;

public interface IFacade {
	List<PaisVO> obtenerPaises();
	List<MarcaVO> obtenerMarcas();
	void guardarArticulo(ArticuloVO articuloVO);
	List<ArticuloVO> obtenerArticulos();
	void eliminarArticulo(String codigo);
	ArticuloVO buscarArticuloPorId(String codigo);
	List<CategoriaVO> obtenerCategorias();
	List<ArticuloVO> buscarArticulo(ArticuloVO articulo);
	void guardarSolicitudArticulos(SolicitudArticulosVO solicitudVO);
	void guardarRecepcionCompra(RecepcionCompraVO recepcionCompraVO);
	List<SolicitudArticulosVO> obtenerSolicitudesArticulosPendientes();
}
