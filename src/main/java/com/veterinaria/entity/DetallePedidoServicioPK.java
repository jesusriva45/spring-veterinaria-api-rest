package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallePedidoServicioPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "idpedido", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idpedido;
	
	
	@Column(name = "idservicio", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idservicio;


	public int getIdPedido() {
		return idpedido;
	}


	public void setIdPedido(int idPedido) {
		this.idpedido = idPedido;
	}


	public int getIdServicio() {
		return idservicio;
	}


	public void setIdServicio(int idServicio) {
		this.idservicio = idServicio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
