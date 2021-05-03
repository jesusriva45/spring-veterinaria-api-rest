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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "mascota")
public class Mascota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "idmascota")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmascota;

	@Column(name = "foto")
	private String foto;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "raza")
	private String raza;

	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "estado")
	private int estado;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipomascota")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoMascota tipomascota;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario_cliente")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	/**/
	public int getIdmascota() {
		return idmascota;
	}

	public void setIdmascota(int idmascota) {
		this.idmascota = idmascota;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public TipoMascota getTipomascota() {
		return tipomascota;
	}

	public void setTipomascota(TipoMascota tipomascota) {
		this.tipomascota = tipomascota;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
