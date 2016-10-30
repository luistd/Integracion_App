package com.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.vo.ItemRecepcionCompraVO;
import com.vo.RecepcionCompraVO;

@Entity
public class RecepcionCompra implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private Date fechaRecepcion;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemRecepcionCompra> itemRecepcionCompra;

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

	public List<ItemRecepcionCompra> getItemRecepcionCompra() {
		return itemRecepcionCompra;
	}

	public void setItemRecepcionCompra(List<ItemRecepcionCompra> itemRecepcionCompra) {
		this.itemRecepcionCompra = itemRecepcionCompra;
	}
	
	public RecepcionCompraVO crearVO(){
		RecepcionCompraVO recepcion = new RecepcionCompraVO();
		recepcion.setId(id);
		recepcion.setFechaRecepcion(fechaRecepcion);
		List<ItemRecepcionCompraVO> items = new ArrayList<ItemRecepcionCompraVO>();
		for(ItemRecepcionCompra item : itemRecepcionCompra){
			items.add(item.crearVO());
		}
		recepcion.setItemRecepcionCompra(items);
		return recepcion;
	}
}
