package com.veterinaria.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.veterinaria.entity.Mascota;

import com.veterinaria.entity.TipoMascota;

public interface IMascotaDao extends JpaRepository<Mascota, Integer> {
	
	@Query("from TipoMascota")/*nombre de la clase*/
	public List<TipoMascota> findAllTipoMascotas();
	

	

	
	@Query(value = "CALL SP_GET_MASCOTA_DE_CLIENTE(:id_user)", nativeQuery = true)
	public List<Mascota> ListMascotaPorCliente(@Param("id_user")int id_user);

}
