package com.veterinaria.service;

import com.veterinaria.entity.Pedido;

public interface IPedidoService {

	public Pedido insertaPedidoProducto(Pedido obj);
	
	public abstract Pedido insertaPedidoServicio(Pedido obj);
}
