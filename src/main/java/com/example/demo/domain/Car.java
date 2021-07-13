package com.example.demo.domain;

import com.example.demo.domain.pieces.*;

public abstract class Car {

	private Long id;
	private String nombre;
	private String type;
	private String color;
	private int puertas;
	private Bateria bateria;
	private Motor motor;
	private Aire aire;
	
	//Empty constructor
	protected Car() {
		
	}
	
	//Constructor
	public Car(Long id, String nombre, String type, String color, int puertas, Bateria bateria, Motor motor,
			Aire aire) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.type = type;
		this.color = color;
		this.puertas = puertas;
		this.bateria = bateria;
		this.motor = motor;
		this.aire = aire;
	}
	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Bateria getBateria() {
		return bateria;
	}

	public void setBateria(Bateria bateria) {
		this.bateria = bateria;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Aire getAire() {
		return aire;
	}

	public void setAire(Aire aire) {
		this.aire = aire;
	}

	//toString
	@Override
	public String toString() {
		return "Car [id=" + id + ", nombre=" + nombre + ", type=" + type + ", color=" + color + ", puertas=" + puertas
				+ ", bateria=" + bateria + ", motor=" + motor + ", aire=" + aire + "]";
	}

}
