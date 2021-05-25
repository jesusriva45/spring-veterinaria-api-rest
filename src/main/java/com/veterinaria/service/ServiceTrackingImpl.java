package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.ITrackingDao;
import com.veterinaria.entity.Estado;
import com.veterinaria.entity.Tracking;


@Service
public class ServiceTrackingImpl implements ITrackingService{

	@Autowired
	private ITrackingDao trakingDao;
	
	
	@Override
	public List<Estado> listEstado() {
		// TODO Auto-generated method stub
		return trakingDao.listarEstados();
	}

	@Override
	public Optional<Tracking> findById(int id) {
		// TODO Auto-generated method stub
		return trakingDao.findById(id);
	}

	@Override
	public Tracking findByIdPedido(int id_ped) {
		// TODO Auto-generated method stub
		return trakingDao.findByIdPedido(id_ped);
	}

	@Override
	public Tracking update(Tracking track) {
		// TODO Auto-generated method stub
		return trakingDao.save(track);
	}

	@Override
	public List<Tracking> findAll() {
		// TODO Auto-generated method stub
		return trakingDao.findAll();
	}
	

}
