package com.springcourse;

public class Administrador {

	private int idAd;
	private String nombre;
	

	public Administrador(){
	}	
	
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Administrador(int idAd, String nombre){
		this.idAd = idAd;
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + "]";
	}
	
	
	public void imprimirDireccion(){
		System.out.println("Java 201");
	}

}
