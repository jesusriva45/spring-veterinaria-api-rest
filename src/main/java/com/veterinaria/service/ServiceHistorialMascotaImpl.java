package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IHistorialMascotaDao;
import com.veterinaria.entity.HistorialMascota;
import com.veterinaria.entity.Mascota;


@Service
public class ServiceHistorialMascotaImpl implements IHistorialMascotaService{

	
	@Autowired
	private IHistorialMascotaDao historialDao;
	
	
	@Override
	public List<HistorialMascota> findAll() {
		// TODO Auto-generated method stub
		return historialDao.findAll();
	}

	@Override
	public Optional<HistorialMascota> findById(int id) {
		// TODO Auto-generated method stub
		return historialDao.findById(id);
	}

	@Override
	public HistorialMascota save(HistorialMascota historial) {
		// TODO Auto-generated method stub
		return historialDao.save(historial);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		historialDao.deleteById(id);
	}

	@Override
	public Optional<HistorialMascota> ListHistorialPorMascota(int id) {
		// TODO Auto-generated method stub
		
		Mascota mascota = new Mascota();
		
		mascota.setIdmascota(id);
		
		return historialDao.findByMascota(mascota);
	}

}
