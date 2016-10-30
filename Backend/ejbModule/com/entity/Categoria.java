package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vo.CategoriaVO;

@Entity
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1592671387832293428L;

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
	
	public CategoriaVO crearVO(){
		CategoriaVO categoriaVO = new CategoriaVO();
		categoriaVO.setId(id);
		categoriaVO.setNombre(nombre);
		return categoriaVO;
	}
}
