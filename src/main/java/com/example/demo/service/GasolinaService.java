package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Gasolina;

public interface GasolinaService {

	Integer count();

    List<Gasolina> findAll();
    
    List<Gasolina> findByNombre(String nombre);
    
    List<Gasolina> findByType(String type);
    
    List<Gasolina> findByColor(String color);
    
    List<Gasolina> findByPuertas(int puertas);

    Gasolina findOne(Long id);

    Gasolina save(Gasolina gasolina);

    boolean delete(Long id);

    void deleteAll();
	
}
