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

import com.veterinaria.entity.SerCategoria;
import com.veterinaria.entity.Servicio;
import com.veterinaria.service.IServicioService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/servicio")
public class ServicioController {

	@Autowired
	private IServicioService servicioService;

	//@Secured({"ROLE_ADMIN"})
	@GetMapping("/servicios")
	public List<Servicio> listAll() {
		return servicioService.findAll();
	}

	//@Secured({"ROLE_ADMIN"})
	@GetMapping("/servicios/{id}")
	public ResponseEntity<Optional<Servicio>> listById(@PathVariable int id) {
		return ResponseEntity.ok(servicioService.findById(id));
	}

	@Secured({"ROLE_VENDEDOR","ROLE_ADMIN"})
	@PostMapping("/servicios")
	public ResponseEntity<Servicio> insert(@RequestBody Servicio obj) {
		return ResponseEntity.ok(servicioService.save(obj));
	}

	@Secured({"ROLE_VENDEDOR","ROLE_ADMIN"})
	@PutMapping("/servicios/{id}")
	public ResponseEntity<Servicio> update(@RequestBody Servicio obj, @PathVariable int id) throws NotFoundException {
		Servicio serActual = servicioService.findById(id)
				.orElseThrow(() -> new NotFoundException("Servicio not found for this id :: " + id));

		serActual.setFoto1(obj.getFoto1());
		serActual.setFoto2(obj.getFoto2());
		serActual.setNombre(obj.getNombre());
		serActual.setPrecio(obj.getPrecio());
		serActual.setDescripcion(obj.getDescripcion());
		
		serActual.setFecha_atencion(obj.getFecha_atencion());
		serActual.setSerCategoria(obj.getSerCategoria());

		final Servicio updatedServicio = servicioService.save(serActual);
		return ResponseEntity.ok(updatedServicio);

	}
	@Secured({"ROLE_VENDEDOR","ROLE_ADMIN"})
	@DeleteMapping("/servicios/{id}")
	public void delete(@PathVariable int id) {
		servicioService.delete(id);
	}

	@GetMapping("/servicios/categoria")
	public List<SerCategoria> listarCategoria() {
		return servicioService.ListAllCategoria();
	}
}
