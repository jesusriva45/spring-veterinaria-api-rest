package com.veterinaria.service;

import java.util.List;


import com.veterinaria.entity.ProCategoria;

public interface IProCategoriaService {
	
	public abstract List<ProCategoria> findAll();
	
	//public abstract Optional<ProCategoria> findById (int id);
	
	//public abstract List<Ubigeo> findByPrecio(double precioMin, double precioMax);	



}
