package com.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IHorarioServicioDao;
import com.veterinaria.entity.HorarioServicio;

@Service
public class ServiceHorarioServicioImpl implements IHorarioServicioService{

	
	@Autowired
	private IHorarioServicioDao horarioDao;
	
	@Override
	public List<HorarioServicio> listaHorarioPorDia(String dia) {
		// TODO Auto-generated method stub
		return horarioDao.listaHorarioPorDia(dia);
	}

}
