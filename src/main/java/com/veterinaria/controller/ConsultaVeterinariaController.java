package com.veterinaria.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.ConsultaVeterinaria;

import com.veterinaria.service.IConsultaVeterinariaService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200", "https://patazas-62d1c.web.app", "https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class ConsultaVeterinariaController {

	@Autowired
	private IConsultaVeterinariaService consultaVetService;

	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@RequestMapping("/consulta")
	@ResponseBody
	public List<ConsultaVeterinaria> listAll() {
		return consultaVetService.findAll();
	}

	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@RequestMapping("/consulta/{id}")
	@ResponseBody
	public Optional<ConsultaVeterinaria> listById(@PathVariable int id) {
		return consultaVetService.findById(id);
	}

	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@RequestMapping("/consulta/historial/{id}")
	@ResponseBody
	public List<ConsultaVeterinaria> listByConsultaPorHistorial(@PathVariable int id) {

		return consultaVetService.ListConsultasPorMascota(id);
	}

	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@PostMapping("/consulta")
	public ResponseEntity<?> insert(@RequestBody ConsultaVeterinaria obj, BindingResult result) {

		ConsultaVeterinaria consulta = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			
			obj.setEstado("EN TRATAMIENTO");
			obj.setFecha_modificacion(new Date());
			obj.setDiagnostico("Veterinario : " + obj.getUsuario().getNombres()+" "+obj.getUsuario().getApellidos() +"\n"+ 
			"Teléfono : "+  obj.getUsuario().getTelefono()+"\n"+
			"Fecha : "+ obj.getFecha_modificacion());
			

			consulta = consultaVetService.save(obj);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Consulta registrada con éxito!");
		response.put("consulta", consulta);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@PutMapping("/consulta/{id}")
	public ResponseEntity<ConsultaVeterinaria> update(@RequestBody ConsultaVeterinaria obj, @PathVariable int id)
			throws NotFoundException {
		ConsultaVeterinaria consActual = consultaVetService.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuario not found for this id :: " + id));

		/*
		 * Employee employee = employeeRepository.findById(employeeId) .orElseThrow(()
		 * -> new ResourceNotFoundException("Employee not found for this id :: " +
		 * employeeId));
		 */

		consActual.setFecha_modificacion(obj.getFecha_modificacion());
		consActual.setDiagnostico(obj.getDiagnostico());
		consActual.setUsuario(obj.getUsuario());

		final ConsultaVeterinaria updatedConsulta = consultaVetService.save(consActual);
		return ResponseEntity.ok(updatedConsulta);
	}

}
