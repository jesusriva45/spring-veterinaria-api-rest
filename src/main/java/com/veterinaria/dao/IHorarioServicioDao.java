package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.HorarioServicio;

public interface IHorarioServicioDao extends JpaRepository<HorarioServicio, Integer> {
	
	
	@Query(value =  "CALL SP_LISTAR_HORARIO_SERVICIO_POR_DIA(:dia)",  nativeQuery = true)
	public List<HorarioServicio> listaHorarioPorDia(@Param("dia")String dia);

}
