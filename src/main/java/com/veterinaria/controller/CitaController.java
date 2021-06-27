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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.DiasServicio;
import com.veterinaria.entity.HistorialMascota;
import com.veterinaria.entity.HorarioServicio;
import com.veterinaria.entity.Mascota;
import com.veterinaria.entity.Cita;
import com.veterinaria.service.ICitaService;
import com.veterinaria.service.IDiasServicioService;
import com.veterinaria.service.IHorarioServicioService;
import com.veterinaria.utils.EmailService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200", "https://patazas-62d1c.web.app", "https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class CitaController {
	
	@Autowired
	private IHorarioServicioService horarioService;
	
	
	@Autowired 
	private IDiasServicioService diasServicioService;
	
	@Autowired
	private ICitaService citaService;
	
	@Autowired
	private EmailService emailService;
	
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@GetMapping("/cita/horario/{dia}")
	public ResponseEntity<List<HorarioServicio>> listAllHorarioServicio(@PathVariable String dia) {
		return ResponseEntity.ok(horarioService.listaHorarioPorDia(dia));
	}
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@GetMapping("/cita/dias/{id_servicio}")
	public ResponseEntity<List<DiasServicio>> listAllDiasServicio(@PathVariable int id_servicio) {
		return ResponseEntity.ok(diasServicioService.listaDiasDeAtencionPorServico(id_servicio));
	}
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@GetMapping("/cita/{dni}/{estado}")
	public ResponseEntity<List<Cita>> listAllCitasDniAndEstado(@PathVariable String dni, @PathVariable String estado) {
		return ResponseEntity.ok(citaService.findCitaDniAndEstado(dni,estado));
	}
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@GetMapping("/cita/user_dni/{dni}")
	public ResponseEntity<List<Cita>> listAllCitasDni(@PathVariable String dni) {
		return ResponseEntity.ok(citaService.findCitaPorDni(dni));
	}
	
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA","ROLE_VENDEDOR" })
	@GetMapping("/cita/usuario/{id}")
	public ResponseEntity<List<Cita>> listByIdUsuario(@PathVariable int id) {
		return ResponseEntity.ok(citaService.findByUsuario(id));
	}
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA" })
	@GetMapping("/cita/{id}")
	public ResponseEntity<Optional<Cita>> findCitaById(@PathVariable int id) {
		return ResponseEntity.ok(citaService.buscarCitaPorId(id));
	}
	
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA" })
	@PostMapping("/cita")
	public ResponseEntity<?> insert(@RequestBody Cita obj, BindingResult result) {

		

		Cita cita = null;
		
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
			
			
			obj.setCosto(obj.getServicio().getPrecio());
			
			obj.setEstado("PENDIENTE");
			
			
			cita = citaService.save(obj);			
			
			
			
			
		} catch (DataAccessException  e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Cita registrada con éxito!");
		response.put("cita", cita);	
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_RECEPCIONISTA" })
	@PutMapping("/cita/estado/{id}")
	public ResponseEntity<Cita> update(@RequestBody Cita obj, @PathVariable int id) throws NotFoundException {
		// obj.setFecha_reg(new Date())
		Cita citaActual = citaService.buscarCitaPorId(id)
				.orElseThrow(() -> new NotFoundException("Mascota not found for this id :: " + id));

		/*
		 * Employee employee = employeeRepository.findById(employeeId) .orElseThrow(()
		 * -> new ResourceNotFoundException("Employee not found for this id :: " +
		 * employeeId));
		 */

		citaActual.setEstado(obj.getEstado());
		
		//String subject, String to, String text
		
		String body = "<h2>Nro : B-CT-000000"+obj.getIdcita()+"</h2><br>"+
						"<h4>Servicio Adquirido : "+ obj.getServicio().getNombre() +"</h4><br>"+
						"<h4> Costo : S/." + obj.getCosto()  + "</h4><br>"+
						"";
		
		emailService.sendEmailMessagePagoCita("Cita - Pago realizado",obj.getUsuario().getCorreo(),body);
	

		final Cita updatedCita = citaService.save(citaActual);
		return ResponseEntity.ok(updatedCita);
	}
	

}
