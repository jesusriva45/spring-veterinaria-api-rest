package com.veterinaria.entity;







import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;



@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "idproducto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	
	
	@Column(name = "nombre")
	private String nombre;
	
	
	@Column(name = "precio")
	private double precio;
	
	
	@Column(name = "stock")
	private int stock;
	
	
	@Column(name = "serie")
	private String serie;
	
	
	
	
	
	@Column(name = "descripcion")
	private String descripcion;
	
	
	@Column(name = "indicaciones")
	private String indicaciones;
	

	@Column(name = "foto1")
	private String foto1;	

	
	
	@Column(name = "foto2")
	private String foto2;
	
	@Column(name = "foto3")
	private String foto3;
	

	

	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idmarca", referencedColumnName = "idmarca")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@JsonBackReference
	private ProMarca marca;
	
	
	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idcategoria_producto", referencedColumnName = "idcategoria")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@JsonBackReference
	private ProCategoria categoria;
	
	
	
	
	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idproveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@JsonBackReference
	private Proveedor proveedor;
	
	
	
	
	




	


	public int getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}




	

	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public ProMarca getMarca() {
		return marca;
	}


	public void setMarca(ProMarca marca) {
		this.marca = marca;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	

	public String getIndicaciones() {
		return indicaciones;
	}


	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}


	




	public String getFoto1() {
		return foto1;
	}


	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}


	public String getFoto2() {
		return foto2;
	}


	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}


	public String getFoto3() {
		return foto3;
	}


	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}


	public ProCategoria getCategoria() {
		return categoria;
	}


	public void setCategoria(ProCategoria categoria) {
		this.categoria = categoria;
	}


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	




	

}
