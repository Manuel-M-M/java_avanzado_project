package com.example.demo.domain.pieces;

public class TanqueGasolina {

	private Long id;
	private int capacidad;
	private String tamaño;
	
	public TanqueGasolina(Long id, int capacidad, String tamaño) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.tamaño = tamaño;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}


	@Override
	public String toString() {
		return "TanqueGasolina [id=" + id + ", capacidad=" + capacidad + ", tamaño=" + tamaño + "]";
	}
	
}
