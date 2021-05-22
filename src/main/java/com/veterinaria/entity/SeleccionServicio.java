package com.veterinaria.entity;

public class SeleccionServicio {
	
	private int idServicio;
	private String nombre;
	private double precio;
	private String fecha;
	private int cantidad;
	private double totalParcial;
	
	
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getTotalParcial() {
		totalParcial=precio*cantidad;
		return totalParcial;
	}
	public void setTotalParcial(double totalParcial) {
		this.totalParcial = totalParcial;
	}
	
	
	
	

}
	