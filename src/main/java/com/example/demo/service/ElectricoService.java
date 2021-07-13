package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Electrico;

public interface ElectricoService {

	Integer count();

    List<Electrico> findAll();
    
    List<Electrico> findByNombre(String nombre);
    
    List<Electrico> findByType(String type);
    
    List<Electrico> findByColor(String color);
    
    List<Electrico> findByPuertas(int puertas);

    Electrico findOne(Long id);

    Electrico save(Electrico electrico);

    boolean delete(Long id);

    void deleteAll();
	
}
