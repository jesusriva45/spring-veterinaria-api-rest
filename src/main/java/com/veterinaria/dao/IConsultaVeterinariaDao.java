package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.ConsultaVeterinaria;
import com.veterinaria.entity.HistorialMascota;

public interface IConsultaVeterinariaDao extends JpaRepository<ConsultaVeterinaria, Integer>{
	
	
	public List<ConsultaVeterinaria> findByHistorialMascota(HistorialMascota historial);

}
