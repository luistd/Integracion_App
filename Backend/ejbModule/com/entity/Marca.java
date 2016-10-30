package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vo.MarcaVO;

@Entity
public class Marca implements Serializable{
	private static final long serialVersionUID = 8642283018730052199L;

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
	
	public MarcaVO crearVO(){
		MarcaVO marcaVO = new MarcaVO();
		marcaVO.setId(id);
		marcaVO.setNombre(nombre);
		return marcaVO;
	}
}
