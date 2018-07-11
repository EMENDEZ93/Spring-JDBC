package com.springcourse;

import org.springframework.beans.factory.annotation.Autowired;

public class Administrador {

	private int idAd;
	private String nombre;

	@Autowired
	private Direccion direccion;

	public Administrador(){
	}	
	
	public void setIdAd(int idAd) {
		this.idAd = idAd;
	}

	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

	public void imprimirDireccion(){
		System.out.println("Java 201");
	}

}
