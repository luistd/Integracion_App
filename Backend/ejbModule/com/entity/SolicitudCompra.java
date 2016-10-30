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

import com.vo.ItemSolicitudCompraVO;
import com.vo.SolicitudCompraVO;

@Entity
public class SolicitudCompra implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private Date fechaEmision;
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemSolicitudCompra> itemSolicitudCompra;
	
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
	public List<ItemSolicitudCompra> getItemSolicitudCompra() {
		return itemSolicitudCompra;
	}
	public void setItemSolicitudCompra(List<ItemSolicitudCompra> itemSolicitudCompra) {
		this.itemSolicitudCompra = itemSolicitudCompra;
	}
	
	public SolicitudCompraVO crearVO(){
		SolicitudCompraVO solicitud = new SolicitudCompraVO();
		solicitud.setFechaEmision(fechaEmision);
		solicitud.setId(id);
		List<ItemSolicitudCompraVO> items = new ArrayList<ItemSolicitudCompraVO>();
		for(ItemSolicitudCompra item : itemSolicitudCompra){
			items.add(item.crearVO());
		}
		return solicitud;		
	}
}
