package com.veterinaria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veterinaria.entity.SeleccionProducto;
import com.veterinaria.entity.SeleccionServicio;
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
	
	
	
	
	
	
	
}
