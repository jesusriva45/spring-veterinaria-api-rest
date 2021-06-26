package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.veterinaria.entity.ConsultaVeterinaria;


public interface IConsultaVeterinariaService {
	
	public abstract List<ConsultaVeterinaria> findAll();

	public abstract Optional<ConsultaVeterinaria> findById(int id);

	public abstract ConsultaVeterinaria save(ConsultaVeterinaria consulta);

	public abstract void delete(int id);
	
	
	public abstract List<ConsultaVeterinaria> ListConsultasPorMascota(int id);

}
