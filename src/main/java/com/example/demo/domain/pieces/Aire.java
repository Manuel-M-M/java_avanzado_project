package com.example.demo.domain.pieces;

public class Aire {
	
	private Long id;
	private Boolean on = true;
	
	public Aire(Long id) {
		super();
		this.id = id;
	}
	
	public void stop() {
		this.on = false;
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
		return "Aire [id=" + id + ", on=" + on + "]";
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}
	
}
