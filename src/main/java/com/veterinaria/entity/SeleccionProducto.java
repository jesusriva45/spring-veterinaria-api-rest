package com.veterinaria.entity;

public class SeleccionProducto {

		private int idproducto;
		private String nombre;
		private double precio;
		private int cantidad;
		private double totalParcial;
		

		public double getTotalParcial() {
			totalParcial = precio * cantidad;
			return totalParcial;
		}


		public int getIdproducto() {
			return idproducto;
		}


		public void setIdproducto(int idproducto) {
			this.idproducto = idproducto;
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


		public int getCantidad() {
			return cantidad;
		}


		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		
}
