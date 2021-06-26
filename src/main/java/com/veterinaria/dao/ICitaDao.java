package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.Cita;
import com.veterinaria.entity.Usuario;

public interface ICitaDao extends JpaRepository<Cita, Integer>{
	
	
	public abstract List<Cita> findByUsuario(Usuario usuario);
	
	@Query("select c from Cita c where c.usuario.dni =:dni_user and c.estado =:estado_user")
	public abstract List<Cita> findCitaPorDniAndEstado(@Param("dni_user") String dni_user, @Param("estado_user") String estado_user);

	@Query("select c from Cita c where c.usuario.dni =:dni_user")
	public abstract List<Cita> findCitaPorDni(@Param("dni_user") String dni_user);
	
}
