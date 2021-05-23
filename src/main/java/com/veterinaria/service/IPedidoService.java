package com.veterinaria.service;

import java.util.Optional;

import com.veterinaria.entity.Pedido;

public interface IPedidoService {

	public abstract Pedido insertaPedidoProducto(Pedido obj);
	
	public abstract Pedido insertaPedidoServicio(Pedido obj);
	
	public abstract Optional<Pedido> findById(int id);
	
}
