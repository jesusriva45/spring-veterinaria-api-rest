package com.veterinaria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class ProMarca {
	
	@Column(name = "idmarca", updatable = false, nullable = false, insertable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmarca;

	@Column(name = "nombre")
	private String nombre;


	
	

	public int getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(int idmarca) {
		this.idmarca = idmarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
