package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;



@Entity
@Table(name = "acceso_rol")
//@IdClass(AccesoRol.class)
public class AccesoRol  implements Serializable{

	/**
	 * s
	 */
	private static final long serialVersionUID = 1L;

	
	//@EmbeddedId
	//private AccesoRolId id;
	@Column(name = "idusuario", updatable = true, nullable = true, insertable = true)
	@Id
	private int idusuario;


	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name = "idrol")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Rol rol;


	


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	
	
	
	


}
