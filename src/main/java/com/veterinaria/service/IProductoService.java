package com.veterinaria.service;


import java.util.List;
import java.util.Optional;

import com.veterinaria.entity.ProCategoria;
import com.veterinaria.entity.ProMarca;
import com.veterinaria.entity.Producto;
import com.veterinaria.entity.Proveedor;

public interface IProductoService {
	
	public abstract List<Producto> findAll();
	
	public abstract Optional<Producto> findById (int id);
	
	public abstract List<Producto> findByPrecio(double precioMin, double precioMax);	

	public abstract Producto save(Producto producto);
	
	public abstract void delete(int id);
	
	//----------------------------------------------------
	
	public abstract List<Proveedor> listAllProveedor();
	
	
	//---------------------------------------------------
	public abstract List<ProCategoria> listAllCategoria();
	
	
	//---------------------------------------------------
	public abstract List<ProMarca> listAllMarca();
	

}
