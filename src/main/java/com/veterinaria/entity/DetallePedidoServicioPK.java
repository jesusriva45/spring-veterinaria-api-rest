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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpedido;
		result = prime * result + idservicio;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePedidoServicioPK other = (DetallePedidoServicioPK) obj;
		if (idpedido != other.idpedido)
			return false;
		if (idservicio != other.idservicio)
			return false;
		return true;
	}
	
	
	

}
