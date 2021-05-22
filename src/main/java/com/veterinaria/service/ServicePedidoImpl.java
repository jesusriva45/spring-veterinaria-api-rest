package com.veterinaria.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.veterinaria.dao.IDetallePedidoProductoDao;
import com.veterinaria.dao.IDetallePedidoServicioDao;
import com.veterinaria.dao.IPedidoRepositoryDao;
import com.veterinaria.entity.DetallePedidoProducto;
import com.veterinaria.entity.DetallePedidoServicio;
import com.veterinaria.entity.Pedido;

public class ServicePedidoImpl implements IPedidoService {
	
	@Autowired
	private IPedidoRepositoryDao pedidoRepository;
	
	@Autowired
	private IDetallePedidoProductoDao detalleProductoRepository;
	
	@Autowired
	private IDetallePedidoServicioDao detalleServicioDao;

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

	
	
	@Override
	public Pedido insertaPedidoServicio(Pedido obj) {
		Pedido ped = pedidoRepository.save(obj);
		
		for (DetallePedidoServicio d : ped.getDetallePedidoServicio()) {
			d.getDetallePedidoServicioPK().setIdPedido(ped.getIdpedido());
			//detalleServicioDao.actualizaStock(d.getCantidad(), d.getProductoHasBoletaPK().getIdProducto());
			detalleServicioDao.save(d);
		}
		
		return ped;
	}

}
