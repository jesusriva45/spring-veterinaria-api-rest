package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "categoria_producto")
public class ProCategoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "idcategoria", updatable = false, nullable = false, insertable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcategoria;
	
	
	@Column(name = "descripcion")
	private String descripcion;


	public int getIdcategoria() {
		return idcategoria;
	}


	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	
	
	
	
	
	

	

}
