package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipomascota")
public class TipoMascota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "idtipomascota")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtipomascota;
	
	@Column(name = "descripcion")
	private String descripcion;

	
	
	/**/
	public int getIdtipomascota() {
		return idtipomascota;
	}

	public void setIdtipomascota(int idtipomascota) {
		this.idtipomascota = idtipomascota;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
