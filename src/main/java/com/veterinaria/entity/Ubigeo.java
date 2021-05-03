package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "ubigeo")
public class Ubigeo implements Serializable {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "idubigeo", updatable = false, nullable = false, insertable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idubigeo;
	
	
	@Column(name = "departamento")
	private String departamento;
	
	
	@Column(name = "provincia")
	private String provincia;
	
	
	@Column(name = "distrito")
	private String distrito;


	public int getIdubigeo() {
		return idubigeo;
	}


	public void setIdubigeo(int idubigeo) {
		this.idubigeo = idubigeo;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	/*MARCA*/
	

	//Si a UBIGEO se le da un UPDATE el resultado se muestra tambien en USUARIO
	
	
	
	/*
	@OneToMany(mappedBy = "ubigeo",cascade = CascadeType.ALL)
	
	private List<Usuario> usuario;*/


	
	
	
	
	
	
}
