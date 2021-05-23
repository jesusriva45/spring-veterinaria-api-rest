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
@Table(name="servicio")
public class Servicio implements Serializable{
	
	
	private static final long serialVersionUID=1L;
	
	@Column(name="idservicio")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idservicio;
	
	@Column(name="foto1")
	private String foto1;
	
	@Column(name="foto2")
	private String foto2;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fecha_atencion")
	
	private String fecha_atencion;
	
	/*Muchos usuarios en Una Region - Muchos --> 1*/
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idcategoria_servicio")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@JsonBackReference
	private SerCategoria serCategoria;
	
	

	
	
	public int getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
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



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha_atencion() {
		return fecha_atencion;
	}

	public void setFecha_atencion(String fecha_atencion) {
		this.fecha_atencion = fecha_atencion;
	}



	public SerCategoria getSerCategoria() {
		return serCategoria;
	}



	public void setSerCategoria(SerCategoria serCategoria) {
		this.serCategoria = serCategoria;
	}



	


}
