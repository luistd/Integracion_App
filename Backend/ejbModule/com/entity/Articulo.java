package com.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.vo.ArticuloVO;

@Entity
public class Articulo implements Serializable{
	private static final long serialVersionUID = 2131959060820503559L;
	@Id
	private String codigo;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Marca marca;
	@Column
	private float precio;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Categoria categoria;
	@Column
	private byte[] foto;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	private Pais origen;
	@Column
	private Integer stock;
	@Column
	private byte[] fichaTecnica;
	@Column
	private String color;
	@Column
	private String talle;
	@Column
	private Integer edadRecomendada;
	@Column
	private String material;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public Pais getOrigen() {
		return origen;
	}
	public void setOrigen(Pais origen) {
		this.origen = origen;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public byte[] getFichaTecnica() {
		return fichaTecnica;
	}
	public void setFichaTecnica(byte[] fichaTecnica) {
		this.fichaTecnica = fichaTecnica;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public Integer getEdadRecomendada() {
		return edadRecomendada;
	}
	public void setEdadRecomendada(Integer edadRecomendada) {
		this.edadRecomendada = edadRecomendada;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArticuloVO crearVO(){
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setCodigo(codigo);
		articuloVO.setDescripcion(descripcion);
		articuloVO.setFoto(foto);
		articuloVO.setNombre(nombre);
		articuloVO.setPrecio(precio);
		articuloVO.setTalle(talle);
		articuloVO.setFichaTecnica(fichaTecnica);
		articuloVO.setColor(color);
		articuloVO.setEdadRecomendada(edadRecomendada);
		articuloVO.setMaterial(material);
		
		if(categoria != null){
			articuloVO.setCategoria(categoria.crearVO());			
		}
		if(marca != null){
			articuloVO.setMarca(marca.crearVO());			
		}
		if(origen != null){
			articuloVO.setOrigen(origen.crearVO());			
		}
		return articuloVO;
	}
}
