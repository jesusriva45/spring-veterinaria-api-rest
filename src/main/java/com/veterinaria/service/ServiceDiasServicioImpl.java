package com.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IDiasServicioDao;
import com.veterinaria.entity.DiasServicio;

@Service
public class ServiceDiasServicioImpl implements IDiasServicioService {

	
	@Autowired
	private IDiasServicioDao diasServcioDao;
	
	
	
	@Override
	public List<DiasServicio> listaDiasDeAtencionPorServico(int id_servicio) {
		// TODO Auto-generated method stub
		return diasServcioDao.listaDiasDeAtencionPorServico(id_servicio);
	}

}
