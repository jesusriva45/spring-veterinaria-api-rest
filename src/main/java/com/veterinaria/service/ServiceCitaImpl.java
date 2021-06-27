package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.ICitaDao;
import com.veterinaria.entity.Cita;
import com.veterinaria.entity.Usuario;

@Service
public class ServiceCitaImpl implements ICitaService{

	@Autowired
	private ICitaDao citaDao;
	
	
	@Override
	public Optional<Cita> buscarCitaPorId(int id) {
		// TODO Auto-generated method stub
		return citaDao.findById(id);
	}

	@Override
	public Cita save(Cita cita) {
		// TODO Auto-generated method stub
		return citaDao.save(cita);
	}

	@Override
	public List<Cita> findByUsuario(int id) {
		// TODO Auto-generated method stub
			
		Usuario usuario = new Usuario();
		
		usuario.setIdusuario(id);
		
		return citaDao.findByUsuario(usuario);
	}

	@Override
	public List<Cita> findCitaDniAndEstado(String dni_user,String estado_user) {
		// TODO Auto-generated method stub
		return citaDao.findCitaPorDniAndEstado(dni_user,estado_user);
	}

	@Override
	public List<Cita> findCitaPorDni(String dni_user) {
		// TODO Auto-generated method stub
		return citaDao.findCitaPorDni(dni_user);
	}

	
	
}
