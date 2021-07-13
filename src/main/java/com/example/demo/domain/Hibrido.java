package com.example.demo.domain;

import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.TanqueHidrogeno;

public class Hibrido extends Car {

	private TanqueHidrogeno thidrogeno;
	
	public Hibrido() {}

	
	public Hibrido(Long id, String nombre, String type, String color, int puertas, Bateria bateria, Motor motor,
			Aire aire, TanqueHidrogeno tanquehidrogeno) {
		super(id, nombre, type, color, puertas, bateria, motor, aire);
	}

	
	public TanqueHidrogeno getThidrogeno() {
		return thidrogeno;
	}

	public void setThidrogeno(TanqueHidrogeno thidrogeno) {
		this.thidrogeno = thidrogeno;
	}

	
	@Override
	public String toString() {
		return "Hibrido [thidrogeno=" + thidrogeno + ", getId()=" + getId() + ", getNombre()=" + getNombre()
				+ ", getType()=" + getType() + ", getColor()=" + getColor() + ", getPuertas()=" + getPuertas()
				+ ", getBateria()=" + getBateria() + ", getMotor()=" + getMotor() + ", getAire()=" + getAire()
				+ "]";
	}
	
}
