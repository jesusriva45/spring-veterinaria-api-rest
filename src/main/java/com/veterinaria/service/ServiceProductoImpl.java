package com.veterinaria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IProductoDao;
import com.veterinaria.entity.ProCategoria;
import com.veterinaria.entity.ProMarca;
import com.veterinaria.entity.Producto;
import com.veterinaria.entity.Proveedor;

@Service
public class ServiceProductoImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productoDao.findAll();
	}

	@Override
	public Optional<Producto> findById(int id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id);
	}

	@Override
	public List<Producto> findByPrecio(double precioMin, double precioMax) {
		// TODO Auto-generated method stub
		return productoDao.findByPrecio(precioMin, precioMax);
	}

	@Override
	public Producto save(Producto producto)  {
		// TODO Auto-generated method stub

		//System.out.println("sdasd" + producto.getFoto2());
		
		
		return productoDao.save(producto);

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productoDao.deleteById(id);
	}

	// ------------------------------------------------------------------
	@Override
	public List<Proveedor> listAllProveedor() {
		// TODO Auto-generated method stub
		return productoDao.listAllProveedor();
	}

	// ------------------------------------------------------------------
	@Override
	public List<ProCategoria> listAllCategoria() {
		// TODO Auto-generated method stub
		return productoDao.listAllCategoria();
	}

	@Override
	public List<ProMarca> listAllMarca() {
		// TODO Auto-generated method stub
		return productoDao.listAllMarca();
	}

}
