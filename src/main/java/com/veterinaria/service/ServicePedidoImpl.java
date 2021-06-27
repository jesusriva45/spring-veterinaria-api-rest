package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IDetallePedidoProductoDao;
import com.veterinaria.dao.IDetallePedidoServicioDao;
import com.veterinaria.dao.IPedidoRepositoryDao;
import com.veterinaria.dao.ITrackingDao;
import com.veterinaria.entity.Cita;
import com.veterinaria.entity.DetallePedidoProducto;
import com.veterinaria.entity.DetallePedidoServicio;
import com.veterinaria.entity.Estado;
import com.veterinaria.entity.Pedido;
import com.veterinaria.entity.Tracking;
import com.veterinaria.entity.Usuario;

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




	@Override
	public List<Pedido> findByUsuario(int id_usuario) {
		// TODO Auto-generated method stub
		
		Usuario usuario = new Usuario();
		usuario.setIdusuario(id_usuario);;
		
		return pedidoRepository.findByUsuario(usuario);
	}




	@Override
	public List<Pedido> buscarPorDniUsuario(String dni_user) {
		// TODO Auto-generated method stub
		return pedidoRepository.buscarPorDniUsuario(dni_user);
	}




	@Override
	public List<Pedido> findPedidoPorDniAndEstado(String dni_user, String estado_user) {
		// TODO Auto-generated method stub
		return pedidoRepository.findPedidoPorDniAndEstado(dni_user, estado_user);
	}




	@Override
	public Pedido estadoPedido(Pedido obj) {
		// TODO Auto-generated method stub
		return pedidoRepository.save(obj);
	}

}
