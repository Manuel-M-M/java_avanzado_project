package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Hibrido;

public interface HibridoService {

	Integer count();

    List<Hibrido> findAll();
    
    List<Hibrido> findByNombre(String nombre);
    
    List<Hibrido> findByType(String type);
    
    List<Hibrido> findByColor(String color);
    
    List<Hibrido> findByPuertas(int puertas);

    Hibrido findOne(Long id);

    Hibrido save(Hibrido hibrido);

    boolean delete(Long id);

    void deleteAll();
	
}
