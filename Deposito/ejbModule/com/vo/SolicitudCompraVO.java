package com.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SolicitudCompraVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date fechaEmision;
	private List<ItemSolicitudCompraVO> itemSolicitudCompra;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public List<ItemSolicitudCompraVO> getItemSolicitudCompra() {
		return itemSolicitudCompra;
	}
	public void setItemSolicitudCompra(List<ItemSolicitudCompraVO> itemSolicitudCompra) {
		this.itemSolicitudCompra = itemSolicitudCompra;
	}
}
