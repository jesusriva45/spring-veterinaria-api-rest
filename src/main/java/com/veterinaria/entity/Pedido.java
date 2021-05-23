package com.veterinaria.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name="pedido")
public class Pedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, length = 10)
	private int idpedido;
	
	@Column(name = "fecha_pedido")
	private String fecha_pedido;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "idusuario")
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;
	
	//listado del detalle del producto
	
	//@JsonManagedReference	 VALIDO
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<DetallePedidoProducto> detallesProducto;

	//listado del detalle del servicio
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	//@JsonManagedReference	 VALIDO
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	private List<DetallePedidoServicio> detallePedidoServicio;
	
	
	public Pedido() {
		detallesProducto = new ArrayList<>();
		
		detallePedidoServicio = new ArrayList<>();		
	}
	

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
