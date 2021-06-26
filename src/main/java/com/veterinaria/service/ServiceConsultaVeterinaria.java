package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IConsultaVeterinariaDao;
import com.veterinaria.entity.ConsultaVeterinaria;
import com.veterinaria.entity.HistorialMascota;


@Service
public class ServiceConsultaVeterinaria implements IConsultaVeterinariaService{

	
	@Autowired
	private IConsultaVeterinariaDao consultaVetDao;
	
	@Override
	public List<ConsultaVeterinaria> findAll() {
		// TODO Auto-generated method stub
		return consultaVetDao.findAll();
	}

	@Override
	public Optional<ConsultaVeterinaria> findById(int id) {
		// TODO Auto-generated method stub
		return consultaVetDao.findById(id);
	}

	@Override
	public ConsultaVeterinaria save(ConsultaVeterinaria consulta) {		
		
		return consultaVetDao.save(consulta);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		consultaVetDao.deleteById(id);
	}

	@Override
	public List<ConsultaVeterinaria> ListConsultasPorMascota(int id) {
		// TODO Auto-generated method stub
		
		HistorialMascota historial = new HistorialMascota();
		
		historial.setIdhistorial(id);
		
		return consultaVetDao.findByHistorialMascota(historial);
	}

}
