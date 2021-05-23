package com.veterinaria.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idusuario")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusuario;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellidos")
	private String apellidos;

	@Column(name = "dni")
	private String dni;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "correo")
	private String correo;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "fechaReg")
	@Temporal(TemporalType.DATE)
	private Date fechaReg;

	@Column(name = "fechaNac")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;

	/* Muchos usuarios en Una Region - Muchos --> 1 */
	@NotNull()
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ubigeo")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	// @JsonBackReference
	private Ubigeo ubigeo;

	// --------- ATRIBUTOS PARA EL LOGIN-------

	@Column(length = 60)
	private String password;
	@Column(unique = true, length = 20)
	private String username;

	private boolean estado;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="acceso_rol", joinColumns = @JoinColumn(name="idusuario"),
	inverseJoinColumns = @JoinColumn(name = "idrol"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"idusuario","idrol"})})
	private List<Rol> rol;

	
	//@JsonIgnore
	//@OneToMany(mappedBy = "usuario")
	@JsonIgnoreProperties(value={"usuario", "hibernateLazyInitializer", "handler"}, allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	// -----------------------------------

	@PrePersist
	public void prePersist() {
		fechaReg = new Date();
	}

	// ---------------------------------
	
	
	
	

	public List<Rol> getRol() {
		return rol;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setRol(List<Rol> rol) {
		this.rol = rol;
	}

	
	
	

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//--------------------------------------
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Ubigeo getUbigeo() {
		return ubigeo;
	}

	public void setUbigeo(Ubigeo ubigeo) {
		this.ubigeo = ubigeo;
	}

	/*
	 * @JsonBackReference
	 * 
	 * @ManyToOne(fetch=FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "id_ubigeo", referencedColumnName = "id_ubigeo") private
	 * Ubigeo ubigeo;
	 * 
	 */

}
