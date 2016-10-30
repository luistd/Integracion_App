package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vo.PaisVO;

@Entity
public class Pais implements Serializable{
	private static final long serialVersionUID = 3926152653785992935L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public PaisVO crearVO(){
		PaisVO paisVO = new PaisVO();
		paisVO.setId(id);
		paisVO.setNombre(nombre);
		return paisVO;
	}
}
