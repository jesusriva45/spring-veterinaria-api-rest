package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.veterinaria.entity.Raza;

public interface IRazaDao extends JpaRepository<Raza, Integer>{
	@Query(value = "CALL SP_RAZA_POR_TIPO_MASCOTA(:idtipo)", nativeQuery = true)
	public List<Raza> ListaRazaPorTipoMascota(@Param("idtipo")int idtipo);

}
