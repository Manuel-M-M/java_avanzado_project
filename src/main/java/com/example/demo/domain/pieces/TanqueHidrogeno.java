package com.example.demo.domain.pieces;

public class TanqueHidrogeno {

	private Long id;
	private int capacidad;
	private String marca;
	
	public TanqueHidrogeno(Long id, int capacidad, String marca) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.marca = marca;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "TanqueHidrogeno [id=" + id + ", capacidad=" + capacidad + ", marca=" + marca + "]";
	}
	
}
