package com.veterinaria.service;

import java.util.List;



import com.veterinaria.entity.HorarioServicio;

public interface IHorarioServicioService {
	
	public abstract List<HorarioServicio> listaHorarioPorDia(String dia);

}
