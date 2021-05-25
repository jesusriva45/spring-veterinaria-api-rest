package com.veterinaria.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IDetallePedidoProductoDao;
import com.veterinaria.dao.IDetallePedidoServicioDao;
import com.veterinaria.dao.IPedidoRepositoryDao;
import com.veterinaria.dao.ITrackingDao;
import com.veterinaria.entity.DetallePedidoProducto;
import com.veterinaria.entity.DetallePedidoServicio;
import com.veterinaria.entity.Estado;
import com.veterinaria.entity.Pedido;
import com.veterinaria.entity.Tracking;

@Service
public class ServicePedidoImpl implements IPedidoService {
	
	@Autowired
	private IPedidoRepositoryDao pedidoRepository;
	
	@Autowired
	private IDetallePedidoProductoDao detalleProductoRepository;
	
	@Autowired
	private IDetallePedidoServicioDao detalleServicioDao;
	
	@Autowired
	private ITrackingDao trackingDao;

	@Override
	@Transactional
	public Pedido insertaPedido(Pedido obj) {
		Pedido cabecera = pedidoRepository.save(obj);
		
		Estado est = new Estado();
		
		est.setIdestado(1);
		
		Tracking tracking = new Tracking();
		tracking.setPedido(cabecera);
		tracking.setEstado(est);
		
		trackingDao.save(tracking);
		
		for (DetallePedidoProducto d : cabecera.getDetallesProducto()) {
			
			d.getDetallePedidoProductoPK().setIdpedido(cabecera.getIdpedido());
			//detalleProductoRepository.actualizaStock(d.getCantidad(), d.getProducto().getIdproducto());
			detalleProductoRepository.save(d);
		}
		for (DetallePedidoServicio d : cabecera.getDetallePedidoServicio()) {
			d.getDetallePedidoServicioPK().setIdPedido(cabecera.getIdpedido());
			//detalleServicioDao.actualizaStock(d.getCantidad(), d.getProductoHasBoletaPK().getIdProducto());
			detalleServicioDao.save(d);
		}
		return cabecera ;
	}

	


	@Override
	@Transactional
	public Optional<Pedido> findById(int id) {
		// TODO Auto-generated method stub
		return pedidoRepository.findById(id);
	}

}
