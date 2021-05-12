package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veterinaria.dao.IUbigeoDao;
import com.veterinaria.entity.Ubigeo;



@Service
public class ServiceUbigeoImpl implements IUbigeoService {

	@Autowired
	private IUbigeoDao ubigeoDao;
	
	@Override
	public List<Ubigeo> findAll() {
		// TODO Auto-generated method stub
		return ubigeoDao.findAll();
	}

	@Override
	public Optional<Ubigeo> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ubigeo save(Ubigeo producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	//------------ LISTADO DE UBIGEO POR UBICACION EXACTA ------------
	@Override
	public List<String> listaDepartamentos() {
		// TODO Auto-generated method stub
		return ubigeoDao.listaDepartamentos();
	}

	@Override
	public List<String> listaProvincias(String departamento) {
		// TODO Auto-generated method stub
		return ubigeoDao.listaProvincias(departamento);
	}

	@Override
	public List<Ubigeo> listaDistritos(String departamento, String provincia) {
		// TODO Auto-generated method stub
		return ubigeoDao.listaDistritos(departamento, provincia);
	}

}
