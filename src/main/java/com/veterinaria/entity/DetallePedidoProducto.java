package com.veterinaria.entity;


import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "detalle_pedido_producto")
public class DetallePedidoProducto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private DetallePedidoProductoPK detallePedidoProductoPK;
	
	
	@Column(precision = 22)
	private double precio;
	
	@Column(length = 10)
	private int cantidad;
	
	
	//@JsonManagedReference NO VALIDO
	@JsonBackReference(value="detallesProducto")
	@JoinColumn(name = "idpedido", referencedColumnName = "idpedido",nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false)	
	private Pedido pedido;
	
	//@JsonManagedReference	 VALIDO
	
	@ManyToOne(optional = false)	
	@JoinColumn(name = "idproducto", referencedColumnName = "idproducto", nullable = false, insertable = false, updatable = false)
	private Producto producto;

	
	
	

	public DetallePedidoProductoPK getDetallePedidoProductoPK() {
		return detallePedidoProductoPK;
	}

	public void setDetallePedidoProductoPK(DetallePedidoProductoPK detallePedidoProductoPK) {
		this.detallePedidoProductoPK = detallePedidoProductoPK;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detallePedidoProductoPK == null) ? 0 : detallePedidoProductoPK.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		DetallePedidoProducto other = (DetallePedidoProducto) obj;
		if (detallePedidoProductoPK == null) {
			if (other.detallePedidoProductoPK != null)
				return false;
		} else if (!detallePedidoProductoPK.equals(other.detallePedidoProductoPK))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	

	
	
}
