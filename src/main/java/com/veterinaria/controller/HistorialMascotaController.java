package com.veterinaria.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.veterinaria.entity.HistorialMascota;
import com.veterinaria.service.IHistorialMascotaService;

@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class HistorialMascotaController {
	
	@Autowired
	private IHistorialMascotaService historialService;
	
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE" })
	@RequestMapping("/historial")
	@ResponseBody
	public List<HistorialMascota> listAll() {
		return historialService.findAll();
	}
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE" })
	@RequestMapping("/historial/mascota/{id}")
	@ResponseBody
	public Optional<HistorialMascota> listByConsultaPorHistorial(@PathVariable int id) {
		return historialService.ListHistorialPorMascota(id);
	}

	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE" })
	@PostMapping("/historial")
	public ResponseEntity<?> insert(@RequestBody HistorialMascota obj, BindingResult result){			
			
	
		HistorialMascota historial = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}	
		
		try {
			
			historial = historialService.save(obj);				
			
		} catch (DataAccessException  e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Historial registrado con éxito!");
		response.put("historial", historial);	
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	
	
}
