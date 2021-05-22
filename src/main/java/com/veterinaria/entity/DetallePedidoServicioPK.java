package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallePedidoServicioPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "idpedido", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idPedido;
	
	
	@Column(name = "idservicio", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idServicio;


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public int getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
