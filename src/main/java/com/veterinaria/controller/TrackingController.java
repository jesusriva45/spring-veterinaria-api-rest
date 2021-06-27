package com.veterinaria.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veterinaria.entity.Estado;
import com.veterinaria.entity.Pedido;
import com.veterinaria.entity.Tracking;
import com.veterinaria.service.IPedidoService;
import com.veterinaria.service.ITrackingService;

import javassist.NotFoundException;

@CrossOrigin(origins = { "http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app" })
@RestController
@RequestMapping("/api")
public class TrackingController {

	
	@Autowired
	private ITrackingService trackingService;
	
	@Autowired
	private IPedidoService pedidoService;
	
	
	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_VETERINARIO","ROLE_VENDEDOR" })
	@GetMapping("/tracking/{id}")
	public ResponseEntity<Tracking> findByIdPedido(@PathVariable int id) {
		
		return ResponseEntity.ok(trackingService.findByIdPedido(id));
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_CLIENTE","ROLE_VETERINARIO","ROLE_VENDEDOR" })
	@GetMapping("/tracking/estado")
	public List<Estado> listEstado() {
		
		return trackingService.listEstado();
	}
	
	
	@Secured({ "ROLE_ADMIN", "ROLE_VETERINARIO","ROLE_VENDEDOR" })
	@Transactional
	@PutMapping("/tracking/{id}")
	public Tracking update(@RequestBody Tracking track,  @PathVariable int id) throws NotFoundException {
		
		Tracking trackActual = trackingService.findById(id).
				orElseThrow(() -> new NotFoundException(""+ id));
		
		
		trackActual.setEstado(track.getEstado());
		
		
		
		if(track.getEstado().getIdestado() == 4) {
			Pedido pedidoTrack = new Pedido();
			
			pedidoTrack = pedidoService.findById(track.getPedido().getIdpedido()).
					orElseThrow(() -> new NotFoundException(""+ id));
			
			
			pedidoTrack.setEstado("FINALIZADO");
			pedidoService.estadoPedido(pedidoTrack);
		
		}
		
		
		return trackingService.update(track);
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_VETERINARIO","ROLE_VENDEDOR" })
	@GetMapping("/tracking")
	public ResponseEntity<List<Tracking>> listAll() {
		return ResponseEntity.ok(trackingService.findAll());
	}
	
	
	
}
