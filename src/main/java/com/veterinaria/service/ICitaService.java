package com.veterinaria.service;

import java.util.List;
import java.util.Optional;



import com.veterinaria.entity.Cita;


public interface ICitaService {
	
	
	public abstract Optional<Cita> buscarCitaPorId(int id);
	
	public abstract Cita save(Cita cita);
	
	public abstract List<Cita> findByUsuario(int id_user);
	
	public abstract List<Cita> findCitaDniAndEstado(String dni_user, String estado_user);
	
	public abstract List<Cita> findCitaPorDni( String dni_user);

}
