package com.example.demo.domain;

import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.TanqueGasolina;

public class Gasolina extends Car {
	
	private TanqueGasolina tgasolina;
	
	public Gasolina() {}

	
	public Gasolina(Long id, String nombre, String type, String color, int puertas, Bateria bateria, Motor motor,
			Aire aire, TanqueGasolina tanquegasolina) {
		super(id, nombre, type, color, puertas, bateria, motor, aire);
	}


	public TanqueGasolina getTgasolina() {
		return tgasolina;
	}

	public void setTgasolina(TanqueGasolina tgasolina) {
		this.tgasolina = tgasolina;
	}


	@Override
	public String toString() {
		return "Gasolina [tgasolina=" + tgasolina + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getType()=" + getType() + ", getColor()=" + getColor() + ", getPuertas()=" + getPuertas()
				+ ", getBateria()=" + getBateria() + ", getMotor()=" + getMotor() + ", getAire()=" + getAire()
				+ "]";
	}


	


	
	
	
	

}
