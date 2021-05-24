package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.AccesoRol;


public interface IAccesoRolDao extends JpaRepository<AccesoRol, Integer>{

	
	
	//public AccesoRol asignarRol(AccesoRolId accesorolId);
	//---------- NO SE ESTÁ USANDO ---------------------
	@Query(value =  "CALL SP_ASIGNAR_ROL(:id_user, :id_rol)",  nativeQuery = true)
	public AccesoRol asignarRol(@Param("id_user")int id_user, @Param("id_rol")int id_rol);
	
}
