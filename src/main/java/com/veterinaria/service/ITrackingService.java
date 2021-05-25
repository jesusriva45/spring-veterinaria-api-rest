package com.veterinaria.service;

import java.util.List;
import java.util.Optional;


import com.veterinaria.entity.Estado;
import com.veterinaria.entity.Tracking;

public interface ITrackingService {
	
	
	public abstract List<Estado> listEstado();
	
	public abstract Optional<Tracking> findById(int id);
	
	public abstract Tracking findByIdPedido(int id_ped);
	
	public abstract Tracking update(Tracking track);
	
	public abstract List<Tracking> findAll();

}
