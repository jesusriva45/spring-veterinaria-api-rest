package com.veterinaria.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "detalle_pedido_servicio")
public class DetallePedidoServicio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private DetallePedidoServicioPK detallePedidoServicioPK;
	
	
	@Column(name = "fecha_atencion")
	private Date fechaAtencion;
	
	
	@JsonBackReference(value="detallePedidoServicio")
	@ManyToOne(optional = false)
	@JoinColumn(name = "idpedido", referencedColumnName = "idpedido", nullable = false, insertable = false, updatable = false)
	private Pedido pedido;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "idservicio", referencedColumnName = "idservicio", nullable = false, insertable = false, updatable = false)
	private Servicio servicio;
	
	

	public DetallePedidoServicioPK getDetallePedidoServicioPK() {
		return detallePedidoServicioPK;
	}

	public void setDetallePedidoServicioPK(DetallePedidoServicioPK detallePedidoServicioPK) {
		this.detallePedidoServicioPK = detallePedidoServicioPK;
	}
//
	public Date getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Date fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
	
	
	
}
