package com.veterinaria.service;

import java.util.List;
import java.util.Optional;



import com.veterinaria.entity.AccesoRol;

import com.veterinaria.entity.Rol;
import com.veterinaria.entity.Ubigeo;
import com.veterinaria.entity.Usuario;

public interface IUsuarioService  {

	public abstract   List<Usuario> findAll();
	
	public  abstract  Optional<Usuario> findById (int id);
	
	public abstract   Usuario save(Usuario usuario);
	
	public abstract   void delete(int id);	
	
	public abstract List<Ubigeo> findAllRegiones();
	
	public abstract Usuario findByUsername(String username);
	
	
	//----------------- ROLES DE USUARIO ---------------------
	
	public abstract List<AccesoRol> findAllAccesoRol();
	
	public abstract List<Rol> findAllRol();
	
	
	
	

	
	
	//------ BUSCA ROL DE USUARIO POR ID DE USUARIO ----------------
	
	public abstract Optional<Rol> rolUsuario(int id_user);

	
	
	//------------------- ACTUALIZAR ESTADO DE USUARIO SIN USO -------------------
	public abstract void updateEstadoUser(int id_user, boolean estado_user);
	
	
	

	//AccesoRol asignarRol(AccesoRolId obj);
	
	
	
	
	
	//----------------- CLIENTES -------------------------
	

	
	public abstract Usuario saveUserCliente(Usuario cli);
	
	//------------------------------------------------------------
	
	
	
	
	
	
	
	

}
