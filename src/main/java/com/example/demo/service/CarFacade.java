package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.Electrico;
import com.example.demo.domain.Gasolina;
import com.example.demo.domain.Hibrido;
import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.BatElectrica;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.TanqueGasolina;
import com.example.demo.domain.pieces.TanqueHidrogeno;

public class CarFacade {
	
	private CarFacade() {}
	
	public static Car createElectrico() {
		//Car pieces
		Aire aire = new Aire(1L);
		Bateria bateria = new Bateria(1L);
		Motor motor = new Motor(1L);
		
		//Electrico exclusive pieces
		BatElectrica batelectrica = new BatElectrica(1L, 50, "full");
		
		Electrico electrico = new Electrico(1L, "Honda", "X2", "blanco", 2, bateria, motor, aire, batelectrica);
		electrico.getAire().start();
		electrico.getBateria().start();
		electrico.getMotor().start();
		
		return electrico;
	}
	
	public static Car createHibrido() {
		//Car pieces
		Aire aire = new Aire(1L);
		Bateria bateria = new Bateria(1L);
		Motor motor = new Motor(1L);
		
		//Hibrido exclusive pieces
		TanqueHidrogeno tanquehidrogeno = new TanqueHidrogeno(1L, 80, "Xerg");
		
		Hibrido hibrido = new Hibrido(1L, "Audi", "T23", "negro", 4, bateria, motor, aire, tanquehidrogeno);
		hibrido.getAire().start();
		hibrido.getBateria().start();
		hibrido.getMotor().start();
		
		return hibrido;
	}
	
	public static Car createGasolina() {
		//Car pieces
		Aire aire = new Aire(1L);
		Bateria bateria = new Bateria(1L);
		Motor motor = new Motor(1L);
		
		//Gasolina exclusive pieces
		TanqueGasolina tanquegasolina = new TanqueGasolina(1L, 120, "grande");
		
		Gasolina gasolina = new Gasolina(1L, "Mercedes", "T23", "negro", 4, bateria, motor, aire, tanquegasolina);
		gasolina.getAire().start();
		gasolina.getBateria().start();
		gasolina.getMotor().start();
		
		return gasolina;
	}

}
