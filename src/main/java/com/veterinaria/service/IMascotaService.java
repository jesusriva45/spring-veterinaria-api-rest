package com.veterinaria.service;

import java.util.List;
import java.util.Optional;




import com.veterinaria.entity.Mascota;
import com.veterinaria.entity.TipoMascota;

public interface IMascotaService {
	
	public abstract   List<Mascota> findAll();
	
	public  abstract  Optional<Mascota> findById (int id);
	
	public abstract   Mascota save(Mascota mascota);
	
	public abstract   void delete(int id);	
	
	public abstract List<TipoMascota> findAllTipoMascota();
	
	
	
	public abstract List<Mascota> ListByIdCliente(int id_user);
	
	
	
	

}
