package com.veterinaria.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "detalle_pedido_producto")
public class DetallePedidoProducto {
	
	@EmbeddedId
	private DetallePedidoProductoPK detallePedidoProductoPK;
	
	
	@Column(precision = 22)
	private double precio;
	
	@Column(length = 10)
	private int cantidad;
	
	//@ManyToOne(optional = false)
	@JoinColumn(name = "idpedido", nullable = false, insertable = false, updatable = false)
	@JsonBackReference
	@ManyToOne(optional = false)
	private Pedido pedido;
	
	
	@ManyToOne(optional = false)
	@JsonBackReference
	@JoinColumn(name = "idproducto", nullable = false, insertable = false, updatable = false)
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

	
	
}
