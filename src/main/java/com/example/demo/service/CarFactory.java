package com.example.demo.service;

import com.example.demo.domain.Car;

public class CarFactory {

	private static final String ELECTRICO = "electrico";
	private static final String HIBRIDO = "hibrido";
	private static final String GASOLINA = "gasolina";
	
	private CarFactory() {}
	
	public static Car createByType(String type) {
		
		return switch (type) {
		case ELECTRICO -> CarFacade.createElectrico();
		case HIBRIDO -> CarFacade.createHibrido();
		case GASOLINA -> CarFacade.createGasolina();
		default -> throw new IllegalArgumentException("Unexpected value: " + type);
		};
		
	}
	
}
