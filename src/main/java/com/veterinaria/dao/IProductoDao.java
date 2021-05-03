package com.veterinaria.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.ProCategoria;
import com.veterinaria.entity.ProMarca;
import com.veterinaria.entity.Producto;
import com.veterinaria.entity.Proveedor;


public interface IProductoDao extends JpaRepository<Producto, Integer>{
	

	@Query("select e from Producto e where e.precio BETWEEN :precioMin and :precioMax")
	public abstract List<Producto> findByPrecio(@Param("precioMin") double precioMin, @Param("precioMax") double precioMax);
	
	
	@Query("from Proveedor")
	public abstract List<Proveedor> listAllProveedor();
	
	
	@Query("from ProCategoria")
	public abstract List<ProCategoria> listAllCategoria();
	
	@Query("from ProMarca")
	public abstract List<ProMarca> listAllMarca();
	
	
	
	
	
}
