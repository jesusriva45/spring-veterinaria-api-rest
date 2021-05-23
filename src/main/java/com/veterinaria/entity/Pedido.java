package com.veterinaria.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


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
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_pedido")
	private Date fecha_pedido;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "idusuario")
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;
	
	//listado del detalle del producto
	
	//@JsonManagedReference	 VALIDO
	//@JsonManagedReference
	@JsonManagedReference(value="detallesProducto")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	//@MapKey(name = "pedido")
	private List<DetallePedidoProducto> detallesProducto;

	//listado del detalle del servicio
	//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	//@JsonManagedReference	 VALIDO
	@JsonManagedReference(value="detallePedidoServicio")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	//@MapKey(name = "id")
	private List<DetallePedidoServicio> detallePedidoServicio;
	
	
	
	@PrePersist
	public void prePersist() {
		fecha_pedido = new Date();
	}

	
	
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

	@SuppressWarnings("deprecation")
	public Date getFecha_pedido() {
		
		fecha_pedido.setHours(fecha_pedido.getHours()-7);
		
		return fecha_pedido;
	}

	public void setFecha_pedido(Date fecha_pedido) {
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
