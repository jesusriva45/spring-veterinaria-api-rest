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
@Table(name = "proveedor")
public class Proveedor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "idproveedor", updatable = false, nullable = false, insertable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproveedor;
	
	@Column(name = "ruc")
	private String ruc;
	
	@Column(name = "razon_social")
	private String razon_social;

	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "telefono")
	private String telefono;
	
	/*Muchos proveedores en Una Region - Muchos --> 1*/
	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idubigeo")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	//@JsonBackReference
	private Ubigeo ubigeo;
	
	

	public int getIdproveedor() {
		return idproveedor;
	}

	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	
	
	
	
	

		

}
