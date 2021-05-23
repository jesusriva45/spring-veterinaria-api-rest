package com.veterinaria.entity;

import java.io.Serializable;
import java.util.List;

public class PruebaProducUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usaurio;
	
	private List<DetallePedidoProducto> detalle;

	public Usuario getUsaurio() {
		return usaurio;
	}

	public void setUsaurio(Usuario usaurio) {
		this.usaurio = usaurio;
	}

	public List<DetallePedidoProducto> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<DetallePedidoProducto> detalle) {
		this.detalle = detalle;
	}
	
	
	
	

}
