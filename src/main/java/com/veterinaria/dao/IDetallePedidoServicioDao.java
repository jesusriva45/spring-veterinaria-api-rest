package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.DetallePedidoServicio;

public interface IDetallePedidoServicioDao extends JpaRepository<DetallePedidoServicio, Integer> {
	
	

}
