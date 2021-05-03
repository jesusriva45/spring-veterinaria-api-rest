package com.veterinaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IAccesoRolDao;

import com.veterinaria.entity.AccesoRol;



@Service
public class ServiceAccesoRolImpl implements IAccesoRolService{
	
	
	@Autowired
	private IAccesoRolDao accesoDao;	
	
	@Override
	public Optional<AccesoRol> findIdAccesoRol(int id) {
		// TODO Auto-generated method stub
		
		return  accesoDao.findById(id);
	}
	
	
	//------------ ASIGNA Y ACTUALIZA EL ROL DE UN USUARIO ------------------------
	
	@Override
	public AccesoRol saveRol(AccesoRol obj) {
		// TODO Auto-generated method stub
		
		//AccesoRol acceso = new  AccesoRol(new AccesoRolId());	
		
		//acceso.setId(obj);		
		
		return accesoDao.save(obj);
	}



	
}
