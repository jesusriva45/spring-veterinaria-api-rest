package com.veterinaria.service;

import java.util.Optional;

import com.veterinaria.entity.AccesoRol;

public interface IAccesoRolService {
	
	public abstract Optional<AccesoRol> findIdAccesoRol(int id);
	

	//---------- ASIGNAR ROL A UN  USUARIO-------------------------
	
	
		public AccesoRol saveRol(AccesoRol obj);
		//----------- SIN USO ----------------------------
		

}
