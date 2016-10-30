package com.vo;

import java.io.Serializable;

public class ArticuloVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String nombre;
	private String descripcion;
	private MarcaVO marca;
	private float precio;
	private CategoriaVO categoria;
	private byte[] foto;
	private PaisVO origen;
	private byte[] fichaTecnica;
	private String color;
	private String talle;
	private Integer edadRecomendada;
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
	public MarcaVO getMarca() {
		return marca;
	}
	public void setMarca(MarcaVO marca) {
		this.marca = marca;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public CategoriaVO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaVO categoria) {
		this.categoria = categoria;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public PaisVO getOrigen() {
		return origen;
	}
	public void setOrigen(PaisVO origen) {
		this.origen = origen;
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
}
