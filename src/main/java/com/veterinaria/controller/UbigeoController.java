package com.veterinaria.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.Ubigeo;
import com.veterinaria.service.IUbigeoService;





@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class UbigeoController {
	
	@Autowired
	private IUbigeoService ubigeoService;

	@GetMapping("/departamentos")
	public List<String> verDepartamentos() {
		return ubigeoService.listaDepartamentos();
	}
	
	@GetMapping("/provincias/{departamento}")
	public List<String> verProvincias(@PathVariable String departamento) {
		return ubigeoService.listaProvincias(departamento);
	}
	
	@GetMapping("/distritos/{departamento}/{provincia}")
	public List<Ubigeo> verDistritos(@PathVariable String departamento, @PathVariable String provincia) {
		return ubigeoService.listaDistritos(departamento, provincia);
	}
	
	
	
}
