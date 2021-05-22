package com.veterinaria.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 10)
	private int idpedido;
	
	@Column(name = "fecha_pedido")
	private String fecha_pedido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idusuario", nullable = false)
	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<DetallePedidoProducto> detallesProducto;

	//listado del detalle del servicio
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<DetallePedidoServicio> detallePedidoServicio;
	
	
	

	public int getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public String getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<DetallePedidoProducto> getDetallesProducto() {
		return detallesProducto;
	}

	public void setDetallesProducto(List<DetallePedidoProducto> detallesProducto) {
		this.detallesProducto = detallesProducto;
	}
	
	public List<DetallePedidoServicio> getDetallePedidoServicio() {
		return detallePedidoServicio;
	}

	public void setDetallePedidoServicio(List<DetallePedidoServicio> detallePedidoServicio) {
		this.detallePedidoServicio = detallePedidoServicio;
	}

}
