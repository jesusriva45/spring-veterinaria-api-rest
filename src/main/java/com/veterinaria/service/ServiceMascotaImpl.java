package com.veterinaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.veterinaria.dao.IMascotaDao;
import com.veterinaria.dao.IRazaDao;
import com.veterinaria.entity.Mascota;
import com.veterinaria.entity.Raza;
import com.veterinaria.entity.TipoMascota;

@Service
public class ServiceMascotaImpl implements IMascotaService {

	@Autowired
	private IMascotaDao mascotaDao;	
	
	@Autowired
	private IRazaDao razaaDao;	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Mascota> findAll() {
		return mascotaDao.findAll();
	}

	@Override
	public Optional<Mascota> findById(int id) {
		return mascotaDao.findById(id);
	}

	@Override
	public Mascota save(Mascota mascota) {
		return mascotaDao.save(mascota);
	}

	@Override
	public void delete(int id) {
		mascotaDao.deleteById(id);
		
	}

	@Override
	public List<TipoMascota> findAllTipoMascota() {
		return mascotaDao.findAllTipoMascotas();
	}

	

	@Override
	public List<Mascota> ListByIdCliente(int id_user) {
		// TODO Auto-generated method stub
		return mascotaDao.ListMascotaPorCliente(id_user);
	}

	@Override
	public List<Raza> ListRazaPorTipoMascota(int idtipo) {
		// TODO Auto-generated method stub
		return razaaDao.ListaRazaPorTipoMascota(idtipo);
	}

}
