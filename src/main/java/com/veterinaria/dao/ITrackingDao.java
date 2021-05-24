package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.Tracking;
import com.veterinaria.entity.Estado;

public interface ITrackingDao extends JpaRepository<Tracking, Integer>{
	
	@Query("from Estado")
	public List<Estado> listarEstados();
	
	@Query(value =  "CALL SP_TRACKING_POR_PEDIDO(:id_ped)",  nativeQuery = true)
	public Tracking findByIdPedido(@Param("id_ped")int id_ped);
	
	

}
