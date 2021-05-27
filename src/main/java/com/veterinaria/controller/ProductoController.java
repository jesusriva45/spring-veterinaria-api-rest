package com.veterinaria.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.ProCategoria;
import com.veterinaria.entity.ProMarca;
import com.veterinaria.entity.Producto;
import com.veterinaria.entity.Proveedor;
import com.veterinaria.service.IProductoService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	
	//@GetMapping("/productos")
	@RequestMapping("/productos")
	@ResponseBody
	public List<Producto>  listAll(){
		return productoService.findAll();
	}
	@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@RequestMapping("/registraProducto")
	@ResponseBody
	public Map<String, Object> registra(Producto obj) throws FileNotFoundException{
		Map<String, Object> salida = new HashMap<>();
		Producto objSalida = productoService.save(obj);
		if (objSalida == null) {
			salida.put("MENSAJE", "Registro erróneo");
		}else {
			salida.put("MENSAJE", "Registro exitoso");
		}
		return salida;
	}
	
	@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@PostMapping("/productos")
	public ResponseEntity<Producto> insert(@RequestBody Producto obj) {		
	
		return ResponseEntity.ok(productoService.save(obj));
	}
	
	
	@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@PutMapping("/productos/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto obj, @PathVariable int id) throws NotFoundException, FileNotFoundException{
		//obj.setFecha_reg(new Date())
		Producto prodActual = productoService.findById(id).orElseThrow(() -> new 
				NotFoundException(""));
		
		     /*Employee employee = employeeRepository.findById(employeeId)
		     .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));*/

		prodActual.setNombre(obj.getNombre());
		prodActual.setPrecio(obj.getPrecio());
		prodActual.setStock(obj.getStock());
		prodActual.setSerie(obj.getSerie());
		prodActual.setMarca(obj.getMarca());
		prodActual.setDescripcion(obj.getDescripcion());
		prodActual.setIndicaciones(obj.getIndicaciones());
		prodActual.setFoto1(obj.getFoto1());
		prodActual.setFoto2(obj.getFoto2());
		prodActual.setFoto3(obj.getFoto3());
		prodActual.setProveedor(obj.getProveedor());
		prodActual.setCategoria(obj.getCategoria());				
			
		final Producto updatedProducto = productoService.save(prodActual);
		
	 return ResponseEntity.ok(updatedProducto);
	 
	}
	//@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@DeleteMapping("/productos/{id}")
	public void delete(@PathVariable int id) {
		productoService.delete(id);		
	}
	
	
	
	
	@GetMapping("/productosPrecio/{precioMin}/{precioMax}")
	@ResponseBody
	public HttpEntity<List<Producto>> listByPrice(@PathVariable double precioMin ,@PathVariable double precioMax){
		return ResponseEntity.ok(productoService.findByPrecio(precioMin,precioMax));
	}
	
	//@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN","ROLE_CLIENTE" })
	@GetMapping("/productos/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Producto>> listById(@PathVariable int id){
		return ResponseEntity.ok(productoService.findById(id));
	}
	
	//@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@GetMapping("/productos/categoria")
	public ResponseEntity<List<ProCategoria>> listCategoria(){
		return ResponseEntity.ok(productoService.listAllCategoria());
	}
	
	//@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@GetMapping("/productos/proveedor")
	public ResponseEntity<List<Proveedor>> listProveedor(){
		return ResponseEntity.ok(productoService.listAllProveedor());
	}
	//@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN" })
	@GetMapping("/productos/marca")
	public ResponseEntity<List<ProMarca>> listMarca(){
		return ResponseEntity.ok(productoService.listAllMarca());
	}	

}




