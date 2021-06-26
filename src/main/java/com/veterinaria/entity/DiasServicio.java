package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dias_servicio")
public class DiasServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 10)
	private int id_dias_servicio;

	@Column(name = "dias")
	private String dias;

	public int getId_dias_servicio() {
		return id_dias_servicio;
	}

	public void setId_dias_servicio(int id_dias_servicio) {
		this.id_dias_servicio = id_dias_servicio;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}
	
	



}
