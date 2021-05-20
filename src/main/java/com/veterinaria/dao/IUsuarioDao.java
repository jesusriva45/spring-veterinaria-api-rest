package com.veterinaria.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.veterinaria.entity.AccesoRol;
import com.veterinaria.entity.Rol;
import com.veterinaria.entity.Ubigeo;
import com.veterinaria.entity.Usuario;



public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{
	
	
	//---------- ESTADO DE USUARIO SIN USO---------------------------------
	
	@Query(value = "CALL SP_ESTADO_USUARIO(:id_user, :estado_user)", nativeQuery = true)
	public void estadoUsuario(@Param("id_user")int id_user,@Param("estado_user")boolean estado_user);
	
	//------------------------------------------------------------
	
	
	
	@Query("from Ubigeo")
	public List<Ubigeo> findAllRegiones();
	
	
	
	@Query("select u from Usuario u where u.username =?1")
	public Usuario findByUsernameAndEmail(String username);
	
	public Usuario findByUsername(String username);	
	
	
	//@Query(value = "{call yourSpName(:param1)}", nativeQuery = true)
	//List<Map<String, Object>> methodName(@Param("param1")Long param1);
	
	@Query("from Rol")
	public List<Rol> findAllRol();
	
	
	@Query("from AccesoRol")
	public List<AccesoRol> findAllAccesoRol();
	
	//---------------------------------------
	
	
	//----------------- CLIENTES -------------------------
	/*
	public  abstract  Optional<Usuario> findById (int id);
	
	public  abstract  Optional<Usuario> findByIdUsuarioCliente (int id); 
	
	public abstract Usuario save(Usuario cli);
	*/
	//------------------------------------------------------------
	
	

	
}
