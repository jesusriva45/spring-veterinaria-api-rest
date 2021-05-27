package com.veterinaria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;

import com.veterinaria.entity.AccesoRol;


import com.veterinaria.entity.Rol;
import com.veterinaria.entity.Ubigeo;
import com.veterinaria.entity.Usuario;
import com.veterinaria.service.IAccesoRolService;

import com.veterinaria.service.IUsuarioService;

import javassist.NotFoundException;

//@PreAuthorize("hasAnyRole({'ROL_VENDEDOR',''})")
@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	

	@Lazy
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	private IAccesoRolService accesoService;

	// ------------------------------------

	// @PreAuthorize("hasRole(‘ROLE_CLIENTE’) AND hasRole(‘ROLE_VENDEDOR’)")
	//@Secured({"ROLE_VENDEDOR","ROLE_ADMIN"})
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@Secured({ "ROLE_VETERINARIO", "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Optional<Usuario>> listById(@PathVariable int id) {
		return ResponseEntity.ok(usuarioService.findById(id));
	}

	/*@Secured({"ROLE_ADMIN"})
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){			
			
			
		
	//return ResponseEntity.ok(usuarioService.save(obj));	
		 obj.setEstado(true);
		
			return ResponseEntity.ok(usuarioService.save(obj));
	}*/
	
	
	//------------------ REGISTRO DE USUARIO ------------------------
	//----- POR DEFECTO SE REGISTRA COMO CLIENTE --------------------
	/*
	 * SERA USADO POR EL ADMIN Y CUALQUIER USUARIO QUE DESEE REGISTRARSE EN
	 * LA PAGINA WEB COMO CLIENTE
	 */
	
	@PostMapping("/usuarios")
	public ResponseEntity<?> insert(@RequestBody Usuario obj, BindingResult result){			
			
	
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
			obj.setPassword(passwordEncoder.encode("12345"));
			
			user = usuarioService.save(obj);
			
			Rol rol = new Rol();
			
			AccesoRol accesoRol  =new AccesoRol();
			
			//Cliente cliente = new Cliente();
			
			accesoRol.setIdusuario(obj.getIdusuario());
			rol.setIdrol(2);			
			
			accesoRol.setRol(rol);
			
			//cliente.setUsuario(obj);
			
			//clienteService.save(cliente);
			
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
	
	
	
	

	@Secured({"ROLE_ADMIN","ROLE_VENDEDOR","ROLE_CLIENTE"})	
	@PutMapping("/usuarios/{id}")
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
	
	
	
	//--------------------------- REINICIAR PASSWORD ----------------------------
	@Secured({"ROLE_ADMIN"})	
	@PutMapping("/usuarios/reset-pass/{id}")
	public ResponseEntity<Usuario> resetPassword(@RequestBody Usuario obj, @PathVariable int id) throws NotFoundException {
		Usuario usuActual = usuarioService.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuario not found for this id :: " + id));


		//usuActual.setPassword(passwordEncoder.encode(obj.getPassword()));
		usuActual.setPassword(passwordEncoder.encode("12345"));
		//objUser.setEstado(true);

		final Usuario updatedUsuario = usuarioService.save(usuActual);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	
	//--------------------------- ACTUALIZAR PASSWORD ----------------------------
	@Secured({"ROLE_ADMIN","ROLE_VENDEDOR","ROLE_CLIENTE"})	
	@PutMapping("/usuarios/pass/{id}")
	public ResponseEntity<Usuario> updatePassword(@RequestBody Usuario obj, @PathVariable int id) throws NotFoundException {
		Usuario usuActual = usuarioService.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuario not found for this id :: " + id));


		//usuActual.setPassword(passwordEncoder.encode(obj.getPassword()));
		usuActual.setPassword(passwordEncoder.encode(obj.getPassword()));
		//objUser.setEstado(true);

		final Usuario updatedUsuario = usuarioService.save(usuActual);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	
	
	//----------------------- ELIMINAR USUARIO ------------------------
	@Secured({ "ROLE_ADMIN" })
	@DeleteMapping("/usuarios/{id}")
	public void delete(@PathVariable int id) {
		usuarioService.delete(id);
	}

	//@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/usuarios/ubigeo")
	public List<Ubigeo> listarRegiones() {
		return usuarioService.findAllRegiones();
	}
	
	

	//---------------- ACTUALIZAR ESTADO DE USUARIO ------------------------
	
	/*@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_CLIENTE" })
	@PutMapping("/usuarios/estado/{id}/{estado}")
	public void actualizarEstadoUser(@PathVariable int id, @PathVariable String estado) {
		
		boolean status = Boolean.parseBoolean(estado);
		
		usuarioService.updateEstadoUser(id,status);
	}
	*/
	
	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/usuarios/estado/{id}")
	public ResponseEntity<Usuario> updateEstado(@RequestBody Usuario obj, @PathVariable int id) throws NotFoundException {
		Usuario usuActual = usuarioService.findById(id)
				.orElseThrow(() -> new NotFoundException("Usuario not found for this id :: " + id));
	
		usuActual.setEstado(obj.isEstado());

		final Usuario updatedUsuario = usuarioService.save(usuActual);
		return ResponseEntity.ok(updatedUsuario);
	}
	
	
	

	
	
	//-------------------- LISTA TODOS LOS ROLES ---------------------------------
	
	@Secured({  "ROLE_ADMIN"})
	@GetMapping("/usuarios/rol")
	public List<Rol> listarRoles() {
		return usuarioService.findAllRol();
	}
	
	
	//------MUESTRA UNA LISTA DE LOS USUARIOS QUE ESTAN ASIGNADOS CON UN ROL (SOLO MUESTRA ID) ------------------------
	//---------- NO SE ESTA USANDO -----------------
	
	@Secured({  "ROLE_ADMIN" })
	@GetMapping("/usuarios/acceso")
	public List<AccesoRol> listarAccesoRoles() {
		return usuarioService.findAllAccesoRol();
	}
	
	
	//---------------- MUESTRA EL ID DE UN USUARIO Y EL ID DE ROL QUE SE LE ASIGNO -----------------
		@Secured({  "ROLE_ADMIN" })
		@GetMapping("/usuarios/acceso/{id}")
		public ResponseEntity<Optional<AccesoRol>> findUsuarioAccesoRol(@PathVariable int id) {
			return ResponseEntity.ok(accesoService.findIdAccesoRol(id));
		}
		
	
	
	
	//--------------------- ASIGNAR ROL A UN USUARIO ----------------------------------
	/*@Secured({ "ROLE_ADMIN" })
	@PutMapping("/usuarios/acceso")
	public  AccesoRol asignarRolUsuario(@RequestBody AccesoRolId obj) {
		
		return usuarioService.asignarRol(obj);
	}*/
	
	//------------------- ASIGNA UN ROL A UN USUARIO -----------------------
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/usuarios/acceso")
	public ResponseEntity<AccesoRol> insert(@RequestBody AccesoRol obj){		
	
			return ResponseEntity.ok(accesoService.saveRol(obj));
	}
	
	

	//------------------------------ ACTUALIZA EL ROL DE UN USUARIO ------------------------
	@Secured({ "ROLE_ADMIN" })
	@PutMapping("/usuarios/acceso/{id}")
	public ResponseEntity<AccesoRol> update(@RequestBody AccesoRol obj, @PathVariable int id) throws NotFoundException {
		AccesoRol rolActual = accesoService.findIdAccesoRol(id)
				.orElseThrow(() -> new NotFoundException("AccesoRol not found for this id :: " + id));
			
		rolActual.setIdusuario(obj.getIdusuario());
		rolActual.setRol(obj.getRol());		
		
		final AccesoRol updatedAccesoRol = accesoService.saveRol(rolActual);
		return ResponseEntity.ok(updatedAccesoRol);
	}	
	
	
	
	
	
	
	
	
	//------- MUESTRA EL ROL DEL USUARIO SELECCIONADO -------------
	@Secured({  "ROLE_ADMIN" })
	@GetMapping("/usuarios/rol_user/{id}")
	public ResponseEntity<Optional<Rol>> findUsuarioRol(@PathVariable int id) {
		return ResponseEntity.ok(usuarioService.rolUsuario(id));
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
