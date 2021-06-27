package com.veterinaria.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.veterinaria.entity.HistorialMascota;
import com.veterinaria.entity.Mascota;

public interface IHistorialMascotaDao extends JpaRepository<HistorialMascota, Integer>{
	
	public Optional<HistorialMascota> findByMascota(Mascota mascota);

}
