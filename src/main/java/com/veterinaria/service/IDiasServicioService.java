package com.veterinaria.service;

import java.util.List;


import com.veterinaria.entity.DiasServicio;

public interface IDiasServicioService {
	
	public List<DiasServicio> listaDiasDeAtencionPorServico(int id_servicio);

}
