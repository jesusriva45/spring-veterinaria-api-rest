package com.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veterinaria.entity.Pedido;

public interface IPedidoRepositoryDao extends JpaRepository<Pedido,Integer> {

}
