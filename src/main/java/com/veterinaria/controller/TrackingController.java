package com.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.Estado;
import com.veterinaria.entity.Tracking;
import com.veterinaria.service.ITrackingService;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class TrackingController {

	
	@Autowired
	private ITrackingService trackingService;
	
	
	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/tracking/{id}")
	public ResponseEntity<Tracking> findByIdPedido(@PathVariable int id) {
		
		return ResponseEntity.ok(trackingService.findByIdPedido(id));
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE" })
	@GetMapping("/tracking/estado")
	public List<Estado> listEstado() {
		
		return trackingService.listEstado();
	}
	
	
	
	
}
