package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.entity.Ubigeo;

public interface IUbigeoService {
	
	
	public abstract List<Ubigeo> findAll();
	
	public abstract Optional<Ubigeo> findById (int id);
	
	//public abstract List<Ubigeo> findByPrecio(double precioMin, double precioMax);	

	public abstract Ubigeo save(Ubigeo producto);
	
	public abstract void delete(int id);
	
	
	
	public abstract List<String> listaDepartamentos();
	public abstract List<String> listaProvincias(String departamento);
	public abstract List<Ubigeo> listaDistritos(String departamento, String provincia);

}
