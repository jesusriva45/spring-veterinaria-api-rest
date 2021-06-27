package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.entity.HistorialMascota;


public interface IHistorialMascotaService {

	public abstract List<HistorialMascota> findAll();

	public abstract Optional<HistorialMascota> findById(int id);

	public abstract HistorialMascota save(HistorialMascota historial);

	public abstract void delete(int id);
	
	public abstract Optional<HistorialMascota> ListHistorialPorMascota(int id);

}
