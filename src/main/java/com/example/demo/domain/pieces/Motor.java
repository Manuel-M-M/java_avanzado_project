package com.example.demo.domain.pieces;

public class Motor {

	private Long id;
	private Boolean on = false;
	
	public Motor(Long id) {
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

	public Boolean getOn() {
		return on;
	}

	public void setOn(Boolean on) {
		this.on = on;
	}

	@Override
	public String toString() {
		return "Motor [id=" + id + ", on=" + on + "]";
	}
	
}
