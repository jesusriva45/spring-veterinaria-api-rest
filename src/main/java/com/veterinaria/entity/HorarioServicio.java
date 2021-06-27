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


@Entity
@Table(name = "horario_servicio")
public class HorarioServicio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 10)
	private int id_horario_servicio;

	@Column(name = "hora_inicio")
	private String hora_inicio;

	@Column(name = "hora_fin")
	private String hora_fin;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_dias_servicio")
	private DiasServicio diasServicio;

	public int getId_horario_servicio() {
		return id_horario_servicio;
	}

	public void setId_horario_servicio(int id_horario_servicio) {
		this.id_horario_servicio = id_horario_servicio;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public DiasServicio getDiasServicio() {
		return diasServicio;
	}

	public void setDiasServicio(DiasServicio diasServicio) {
		this.diasServicio = diasServicio;
	}
	
	
	
	
	

}
