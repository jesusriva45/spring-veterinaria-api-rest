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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "raza")
public class Raza implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "idraza")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idraza;
	
	@Column(name = "descripcion")
	private String descripcion;
	

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipomascota")
	private TipoMascota tipomascota;



	public int getIdraza() {
		return idraza;
	}



	public void setIdraza(int idraza) {
		this.idraza = idraza;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public TipoMascota getTipomascota() {
		return tipomascota;
	}



	public void setTipomascota(TipoMascota tipomascota) {
		this.tipomascota = tipomascota;
	}
	
	
	
	
	
	
	
	
	

}
