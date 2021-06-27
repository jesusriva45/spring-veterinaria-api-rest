package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.DiasServicio;


public interface IDiasServicioDao extends JpaRepository<DiasServicio, Integer>{
	
	@Query(value =  "CALL SP_LISTAR_DIAS_POR_SERVICIO(:id_servicio)",  nativeQuery = true)
	public List<DiasServicio> listaDiasDeAtencionPorServico(@Param("id_servicio")int id_servicio);

}
