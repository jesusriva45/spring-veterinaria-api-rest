package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veterinaria.dao.IServicioDao;
import com.veterinaria.entity.SerCategoria;
import com.veterinaria.entity.Servicio;


@Service
public class ServiceServicioImpl implements IServicioService {

	@Autowired
	private IServicioDao servicioDao;
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>) servicioDao.findAll();
	}

	@Override
	@Transactional
	public Optional<Servicio> findById(int id) {
		// TODO Auto-generated method stub
		return servicioDao.findById(id);	
	}

	
	@Override
	@Transactional
	public Servicio save(Servicio servicio) {
		// TODO Auto-generated method stub
		return servicioDao.save(servicio);
	}
	
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		servicioDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<SerCategoria> ListAllCategoria() {
		// TODO Auto-generated method stub
		return servicioDao.listAllCategoria();
	}
	
	

}
