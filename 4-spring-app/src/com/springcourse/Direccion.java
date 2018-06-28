package com.springcourse;

import org.springframework.stereotype.Component;

@Component
public class Direccion {
	
	private String calle;
	private String cp;
	
	public Direccion() {	
	}

	public Direccion(String calle, String cp) {
		this.calle = calle;
		this.cp = cp;
	}
	
	@Override
	public String toString() {
		return "Direccion [calle= " + calle +", cp="+cp+"]";
	}
	
}
