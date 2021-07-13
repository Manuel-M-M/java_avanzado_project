package com.example.demo.domain;

import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.BatElectrica;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;

public class Electrico extends Car {

	private BatElectrica batelectrica;

	public Electrico() {}

	public Electrico(Long id, String nombre, String type, String color, int puertas, Bateria bateria, Motor motor,
			Aire aire, BatElectrica batelectrica2) {
		super(id, nombre, type, color, puertas, bateria, motor, aire);
		this.batelectrica = batelectrica;
	}

	
	public BatElectrica getBatelectrica() {
		return batelectrica;
	}

	public void setBatelectrica(BatElectrica batelectrica) {
		this.batelectrica = batelectrica;
	}

	
	@Override
	public String toString() {
		return "Electrico [batelectrica=" + batelectrica + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getType()=" + getType() + ", getColor()=" + getColor() + ", getPuertas()=" + getPuertas()
				+ ", getBateria()=" + getBateria() + ", getMotor()=" + getMotor() + ", getAire()=" + getAire()
				+ "]";
	}
	
}
