package com.example.demo.domain.pieces;

public class BatElectrica {

	private Long id;
	private int capacidad;
	private String carga;
	
	public BatElectrica(Long id, int capacidad, String carga) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.carga = carga;
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

	public String getCarga() {
		return carga;
	}

	public void setCarga(String carga) {
		this.carga = carga;
	}


	@Override
	public String toString() {
		return "BatElectrica [id=" + id + ", capacidad=" + capacidad + ", carga=" + carga + "]";
	}
	
}
