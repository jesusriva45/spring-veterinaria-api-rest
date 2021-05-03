package com.veterinaria.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.Rol;


public interface IRolDao extends JpaRepository<Rol, Integer>{
	
	
	@Query(value = "CALL SP_GET_ROL(:id_user)", nativeQuery = true)
	public Optional<Rol> rolUsuario(@Param("id_user")int id_user);

}
