package com.veterinaria.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "cita")
public class Cita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idcita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcita;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_registro")
	private Date fecha_registro;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, locale = "es_PE", timezone = "America/Lima")
	@Column(name = "dia_atencion")
	private Date dia_atencion;

	@Column(name = "hora_inicio")
	private String hora_inicio;

	@Column(name = "hora_fin")
	private String hora_fin;

	@Column(name = "costo")
	private double costo;

	@Column(name = "estado")
	private String estado;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idservicio")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Servicio servicio;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	@JsonIgnoreProperties({ "pedidos", "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	@PrePersist
	public void prePersist() {
		fecha_registro = new Date();
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public int getIdcita() {
		return idcita;
	}

	public void setIdcita(int idcita) {
		this.idcita = idcita;
	}

	public Date getDia_atencion() {
		return dia_atencion;
	}

	public void setDia_atencion(Date dia_atencion) {

		/*
		 * Date fecha_atencion = new Date();
		 * 
		 * fecha_atencion.setDate(dia_atencion);
		 */

		this.dia_atencion = dia_atencion;
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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
