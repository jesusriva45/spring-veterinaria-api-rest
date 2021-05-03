package com.veterinaria.entity;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name = "rol")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "idrol")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	
	
	@Column(name = "descripcion", unique=true, length = 20)
	private String descripcion;


	public int getIdrol() {
		return idrol;
	}



	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	

}
