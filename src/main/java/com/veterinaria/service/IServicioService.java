package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.entity.SerCategoria;
import com.veterinaria.entity.Servicio;

public interface IServicioService {
	
	public abstract List<Servicio> findAll();
	
	public abstract Servicio save(Servicio servicio);
	
	public abstract void delete(int id);
	
	public abstract List<SerCategoria> ListAllCategoria();
	
	public  abstract  Optional<Servicio> findById (int id);

}
