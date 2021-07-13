package com.example.demo.domain.pieces;

public class Bateria {

	private Long id;
	private Boolean on = false;
	
	public Bateria(Long id) {
		super();
		this.id = id;
	}
	
	public void start() {
		this.on = true;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getOff() {
		return on;
	}

	public void setOff(Boolean off) {
		this.on = off;
	}

	@Override
	public String toString() {
		return "Bateria [id=" + id + ", off=" + on + "]";
	}
	
}
