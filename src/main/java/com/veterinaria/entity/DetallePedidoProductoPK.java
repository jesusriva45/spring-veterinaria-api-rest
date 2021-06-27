package com.veterinaria.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetallePedidoProductoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "idpedido", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idpedido;
	
	@Column(name = "idproducto", unique = true, nullable = false, length = 10, insertable = true, updatable = false)
	private int idproducto;

	
	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idpedido;
		result = prime * result + idproducto;
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
		DetallePedidoProductoPK other = (DetallePedidoProductoPK) obj;
		if (idpedido != other.idpedido)
			return false;
		if (idproducto != other.idproducto)
			return false;
		return true;
	}

	
	

}
