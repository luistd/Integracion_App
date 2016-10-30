package com.vo;

import java.io.Serializable;

public class ItemSolicitudCompraVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private ArticuloVO articulo;
	private Integer cantidad;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ArticuloVO getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
