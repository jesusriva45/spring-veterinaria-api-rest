package com.veterinaria.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.Pedido;
import com.veterinaria.entity.Usuario;

public interface IPedidoRepositoryDao extends JpaRepository<Pedido,Integer> {
	
		public abstract List<Pedido> findByUsuario(Usuario usuario);
		
		
		@Query("select p from Pedido p where p.usuario.dni =:dni_user and p.estado =:estado_user")
		public abstract List<Pedido> findPedidoPorDniAndEstado(@Param("dni_user") String dni_user, @Param("estado_user") String estado_user);
		
		@Query("select p from Pedido p where p.usuario.dni =:dni_user")
		public abstract List<Pedido> buscarPorDniUsuario(@Param("dni_user") String dni_user);

}
