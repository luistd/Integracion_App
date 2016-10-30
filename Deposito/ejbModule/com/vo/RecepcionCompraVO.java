package com.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RecepcionCompraVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	private Date fechaRecepcion;
	
	private List<ItemRecepcionCompraVO> itemRecepcionCompra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public List<ItemRecepcionCompraVO> getItemRecepcionCompra() {
		return itemRecepcionCompra;
	}

	public void setItemRecepcionCompra(List<ItemRecepcionCompraVO> itemRecepcionCompra) {
		this.itemRecepcionCompra = itemRecepcionCompra;
	}
}
