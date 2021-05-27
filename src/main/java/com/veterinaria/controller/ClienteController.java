package com.veterinaria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.AccesoRol;
import com.veterinaria.entity.Rol;
import com.veterinaria.entity.Usuario;
import com.veterinaria.service.IAccesoRolService;
import com.veterinaria.service.IUsuarioService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IUsuarioService usuarioService;
	

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IAccesoRolService accesoService;
	
	
	
	//--- Prueba ---
	//-------------------- REGISTRO DE CLIENTE ---------------------------
	
	
	
	@PostMapping("/cliente")
	public ResponseEntity<?> insertCliente(@RequestBody Usuario obj, BindingResult result){			
			
	
		Usuario user = null;
		
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
			obj.setEstado(true);
			obj.setUsername(obj.getDni());
			obj.setPassword(passwordEncoder.encode(obj.getPassword()));
			user = usuarioService.save(obj);
			
			Rol rol = new Rol();
			
			AccesoRol accesoRol  =new AccesoRol();
			
			
			accesoRol.setIdusuario(obj.getIdusuario());
			rol.setIdrol(2);			
			
			accesoRol.setRol(rol);

			
			accesoService.saveRol(accesoRol);
			
			
		} catch (DataAccessException  e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con éxito!");
		response.put("usuario", user);	
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
	}
	
	
	@Secured({ "ROLE_CLIENTE"})	
	@PutMapping("/usuario-sistema/pass/{id}")
	public ResponseEntity<Usuario> updatePassword(@RequestBody Usuario obj, @PathVariable int id) throws NotFoundException {
		Usuario usuActual = usuarioService.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuario not found for this id :: " + id));


		//usuActual.setPassword(passwordEncoder.encode(obj.getPassword()));
		usuActual.setPassword(passwordEncoder.encode(obj.getPassword()));
		//objUser.setEstado(true);

		final Usuario updatedUsuario = usuarioService.save(usuActual);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	@Secured({ "ROLE_CLIENTE","ROLE_ADMIN","ROLE_VENDEDOR"})	
	@PutMapping("/usuario-sistema/{id}")
	public ResponseEntity<Usuario> update(@RequestBody Usuario obj, @PathVariable int id) throws NotFoundException {
		Usuario usuActual = usuarioService.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuario not found for this id :: " + id));

		/*
		 * Employee employee = employeeRepository.findById(employeeId) .orElseThrow(()
		 * -> new ResourceNotFoundException("Employee not found for this id :: " +
		 * employeeId));
		 */

		usuActual.setNombres(obj.getNombres());
		usuActual.setApellidos(obj.getApellidos());
		usuActual.setDni(obj.getDni());
		usuActual.setTelefono(obj.getTelefono());
		usuActual.setCorreo(obj.getCorreo());
		usuActual.setFechaNac(obj.getFechaNac());
		usuActual.setDireccion(obj.getDireccion());
		usuActual.setUbigeo(obj.getUbigeo());
		usuActual.setUsername(obj.getUsername());
		//usuActual.setPassword(obj.getPassword());
		//objUser.setEstado(true);

		final Usuario updatedUsuario = usuarioService.save(usuActual);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	
	
}
