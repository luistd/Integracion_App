package com.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.vo.ArticuloVO;
import com.vo.CategoriaVO;
import com.vo.MarcaVO;
import com.vo.PaisVO;
import com.vo.RecepcionCompraVO;
import com.vo.SolicitudArticulosVO;

@Remote
public interface ArticuloServiceRemote {
	List<PaisVO> obtenerPaises();
	List<MarcaVO> obtenerMarcas();
	void guardarArticulo(ArticuloVO articuloVO);
	void eliminarArticulo(String codigo);
	List<ArticuloVO> obtenerArticulos();
	ArticuloVO buscarArticuloPorId(String codigo);
	List<CategoriaVO> obtenerCategorias();
	List<ArticuloVO> buscarArticulo(ArticuloVO articulo);
	void guardarSolicitudArticulos(SolicitudArticulosVO solicitudVO);
	void guardarRecepcionCompra(RecepcionCompraVO recepcionCompraVO);
	List<SolicitudArticulosVO> obtenerSolicitudesArticulosPendientes();
}
