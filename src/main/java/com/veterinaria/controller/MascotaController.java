package com.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.veterinaria.entity.Mascota;
import com.veterinaria.entity.TipoMascota;
import com.veterinaria.entity.Usuario;
import com.veterinaria.service.IMascotaService;
import com.veterinaria.service.IUsuarioService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class MascotaController {

	@Autowired
	private IMascotaService mascotaService;


	
	@Autowired 
	private IUsuarioService usuarioService;
	

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/mascotas")
	public List<Mascota> listAll() {
		return mascotaService.findAll();
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/mascotas/{id}")
	public ResponseEntity<Optional<Mascota>> listById(@PathVariable int id) {
		return ResponseEntity.ok(mascotaService.findById(id));
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@PostMapping("/mascotas")
	public ResponseEntity<Mascota> insert(@RequestBody Mascota obj) {

		return ResponseEntity.ok(mascotaService.save(obj));
	}
	
	
	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/mascotas/mascotas-del-cliente/{id}")
	public ResponseEntity<List<Mascota>> listByIdCliente(@PathVariable int id) {
		return ResponseEntity.ok(mascotaService.ListByIdCliente(id));
	}
	
	

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@PutMapping("/mascotas/{id}")
	public ResponseEntity<Mascota> update(@RequestBody Mascota obj, @PathVariable int id) throws NotFoundException {
		// obj.setFecha_reg(new Date())
		Mascota masActual = mascotaService.findById(id)
				.orElseThrow(() -> new NotFoundException("Mascota not found for this id :: " + id));

		/*
		 * Employee employee = employeeRepository.findById(employeeId) .orElseThrow(()
		 * -> new ResourceNotFoundException("Employee not found for this id :: " +
		 * employeeId));
		 */

		masActual.setNombre(obj.getNombre());
		masActual.setRaza(obj.getRaza());
		masActual.setFoto(obj.getFoto());
		masActual.setFecha_nacimiento(obj.getFecha_nacimiento());
		masActual.setEstado(obj.getEstado());
		masActual.setSexo(obj.getSexo());
		masActual.setTipomascota(obj.getTipomascota());
		masActual.setUsuario(obj.getUsuario());

		final Mascota updatedMascota = mascotaService.save(masActual);
		return ResponseEntity.ok(updatedMascota);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@DeleteMapping("/mascotas/{id}")
	public void delete(@PathVariable int id) {
		mascotaService.delete(id);
	}

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/mascotas/tipomascota")
	public List<TipoMascota> listaTipoMascotas() {
		return mascotaService.findAllTipoMascota();
	}


	
	
	//--------------- CLIENTE LOGUEADO ------------------------------------

	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/mascotas/cliente/{id}")
	public ResponseEntity<Optional<Usuario>> ClienteLogueado(@PathVariable int id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}

}
