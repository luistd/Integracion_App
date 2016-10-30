package com.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.vo.ItemSolicitudArticuloVO;

@Entity
public class ItemSolicitudArticulo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Articulo articulo;
	@Column
	private Integer cantidad;
	@Column
	private String estado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public ItemSolicitudArticuloVO crearVO(){
		ItemSolicitudArticuloVO item = new ItemSolicitudArticuloVO();
		item.setId(id);
		item.setArticulo(articulo.crearVO());
		item.setCantidad(cantidad);
		return item;
	}
}
