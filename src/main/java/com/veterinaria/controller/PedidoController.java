package com.veterinaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veterinaria.entity.SeleccionProducto;
import com.veterinaria.service.IPedidoService;
import com.veterinaria.service.IProductoService;
import com.veterinaria.service.IUsuarioService;

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
	public List<SeleccionProducto> listaP(){
		return seleccionadosP;
	}
	
	@RequestMapping("/eliminaSeleccionProducto")
	@ResponseBody
	public List<SeleccionProducto> eliminar(int idProducto) {
		for (SeleccionProducto x : seleccionadosP) {
			if (x.getIdproducto() == idProducto) {
				seleccionadosP.remove(x);
				break;
			}
		}
		return seleccionadosP;
	}
	
		
}
