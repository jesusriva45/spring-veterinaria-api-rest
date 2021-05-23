package com.veterinaria.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veterinaria.entity.Pedido;
import com.veterinaria.entity.SeleccionProducto;
import com.veterinaria.entity.SeleccionServicio;
import com.veterinaria.entity.Usuario;
import com.veterinaria.service.IPedidoService;
import com.veterinaria.service.IProductoService;
import com.veterinaria.service.IUsuarioService;


@CrossOrigin(origins = { "http://localhost:4200" })
@Controller
@RequestMapping("/api")
public class PedidoController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IPedidoService pedidoService;
	
	//aca se almacenan los productos seleccionados
	private List<SeleccionProducto> seleccionadosP = new ArrayList<SeleccionProducto>();

	@RequestMapping("/verPedido")
	public String verPedido() {
		return "pedido";
	}
	
	@RequestMapping("/agregarSeleccionProducto")
	@ResponseBody
	public List<SeleccionProducto> agregarProducto(SeleccionProducto obj){
		seleccionadosP.add(obj);
		return seleccionadosP;
	}
	
	@RequestMapping("/listaSeleccionProducto")
	@ResponseBody
	public List<SeleccionProducto> listaProductos(){
		return seleccionadosP;
	}
	
	
	@RequestMapping("/eliminaSeleccionProducto")
	@ResponseBody
	public List<SeleccionProducto> eliminarProducto(int idProducto) {
		for (SeleccionProducto x : seleccionadosP) {
			if (x.getIdproducto() == idProducto) {
				seleccionadosP.remove(x);
				break;
			}
		}
		return seleccionadosP;
	}
	
	
	///Servicio
	
	private List<SeleccionServicio> seleccionaS = new ArrayList<SeleccionServicio>();
	
	/*
	@RequestMapping("/verPedidoProducto")
	public String verPedidoProducto() {
		return "pedido";
	}
	
	@RequestMapping("/verPedidoServicio")
	public String verPedidoservicio() {
		return "pedido";
	}
	*/
	
	
	@RequestMapping("/agregarSeleccionServicio")
	@ResponseBody
	public List<SeleccionServicio> agregarServicio(SeleccionServicio obj){
		seleccionaS.add(obj);
		return seleccionaS;
	}
	
	
	@RequestMapping("/listaSeleccionServicio")
	@ResponseBody
	public List<SeleccionServicio> lista(){
		return seleccionaS;
	}
	
	
	@RequestMapping("/eliminaSeleccionServicio")
	@ResponseBody
	public List<SeleccionServicio> eliminarServicio(int idServicio) {
		for (SeleccionServicio x : seleccionaS) {
			if (x.getIdServicio() == idServicio) {
				seleccionaS.remove(x);
				break;
			}
		}
		return seleccionaS;
	}
	
	
	
	@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_CLIENTE" })
	//@GetMapping("/usuarios/{id}")
	@RequestMapping("/pedido/{id}")
	@ResponseBody
	public ResponseEntity<Optional<Pedido>> listById(@PathVariable int id) {
		return ResponseEntity.ok(pedidoService.findById(id));
	}
	
	
	@Secured({ "ROLE_VENDEDOR", "ROLE_ADMIN", "ROLE_CLIENTE" })
	//@GetMapping("/usuarios/{id}")
	@RequestMapping("/pedidos")
	@ResponseBody
	public ResponseEntity<?> registrarPedido(@RequestBody Usuario obj, BindingResult result){
		
		Usuario user = null;
		
		Map<String, Object> response = new HashMap<>();
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
}
