package com.veterinaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.veterinaria.dao.IDetallePedidoProductoDao;
import com.veterinaria.dao.IPedidoRepositoryDao;
import com.veterinaria.entity.DetallePedidoProducto;
import com.veterinaria.entity.Pedido;

public class ServicePedidoImpl implements IPedidoService {
	
	@Autowired
	private IPedidoRepositoryDao pedidoRepository;
	
	@Autowired
	private IDetallePedidoProductoDao detalleProductoRepository;

	@Override
	@Transactional
	public Pedido insertaPedidoProducto(Pedido obj) {
		Pedido cabecera = pedidoRepository.save(obj);
		for (DetallePedidoProducto d : cabecera.getDetallesProducto()) {
			d.getDetallePedidoProductoPK().setIdpedido(cabecera.getIdpedido());
			detalleProductoRepository.actualizaStock(d.getCantidad(), d.getDetallePedidoProductoPK().getIdproducto());
			detalleProductoRepository.save(d);
		}
		return cabecera ;
	}

}
