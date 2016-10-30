package com.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SolicitudArticulosVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private List<ItemSolicitudArticuloVO> itemSolicitudArticulo;
	private Date fechaEmision;
	private String estado;
	private List<SolicitudCompraVO> solicitudesCompra;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<ItemSolicitudArticuloVO> getItemSolicitudArticulo() {
		return itemSolicitudArticulo;
	}
	public void setItemSolicitudArticulo(List<ItemSolicitudArticuloVO> itemSolicitudArticulo) {
		this.itemSolicitudArticulo = itemSolicitudArticulo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public List<SolicitudCompraVO> getSolicitudesCompra() {
		return solicitudesCompra;
	}
	public void setSolicitudesCompra(List<SolicitudCompraVO> solicitudesCompra) {
		this.solicitudesCompra = solicitudesCompra;
	}
}