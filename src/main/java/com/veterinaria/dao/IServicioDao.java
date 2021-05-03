package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veterinaria.entity.SerCategoria;
import com.veterinaria.entity.Servicio;

public interface IServicioDao extends JpaRepository<Servicio, Integer> {

	@Query("from SerCategoria")
	public List<SerCategoria> listAllCategoria();
}
