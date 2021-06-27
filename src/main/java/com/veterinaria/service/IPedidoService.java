package com.veterinaria.service;

import java.util.List;
import java.util.Optional;
import com.veterinaria.entity.Pedido;


public interface IPedidoService {

	public abstract Pedido insertaPedido(Pedido obj);
	
	public abstract Pedido estadoPedido(Pedido obj);
	
	
	public abstract Optional<Pedido> findById(int id);
	
	public abstract List<Pedido> findByUsuario(int  id_usuario);
	
	public abstract List<Pedido> buscarPorDniUsuario( String dni_user);
	
	public abstract List<Pedido> findPedidoPorDniAndEstado(String dni_user,  String estado_user);
	
}
