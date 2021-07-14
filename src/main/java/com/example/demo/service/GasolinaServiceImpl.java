package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Electrico;
import com.example.demo.domain.Gasolina;
import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.TanqueGasolina;

@Service
public class GasolinaServiceImpl implements GasolinaService {

	/**
	 * Emulates a database with java hashmap
	 */
    private static final Map<Long, Gasolina> gasolinas = new HashMap<>();

    static{ 
    	
    	Gasolina gasolina1 = new Gasolina(1L, "Honda", "M", "cian", 3,  
				new Bateria(1L),
				new Motor(1L),
				new Aire(1L),
				new TanqueGasolina(1L, 150, "medio"));
		
    	Gasolina gasolina2 = new Gasolina(2L, "Mercedes", "G", "morado", 5, 
				new Bateria(2L),
				new Motor(2L),
				new Aire(2L),
				new TanqueGasolina(2L, 180, "pequeño"));
    	
    	Gasolina gasolina3 = new Gasolina(3L, "Audi", "V", "plata", 6, 
				new Bateria(3L),
				new Motor(3L),
				new Aire(3L),
				new TanqueGasolina(3L, 200, "grande"));
    	
    	gasolinas.put(1L, gasolina1);
    	gasolinas.put(2L, gasolina2);
    	gasolinas.put(3L, gasolina3);
    
    }
    
    @Override
    public Integer count() {
        return gasolinas.keySet().size();
    }

    @Override
    public List<Gasolina> findAll() {
        return new ArrayList<>(gasolinas.values());
    }

    @Override
    public Gasolina findOne(Long id) {
        return gasolinas.get(id);
    }

    @Override
    public Gasolina save(Gasolina gasolina) {
    	
    	
        if (gasolina.getId() == null || gasolina.getId() == 0L) 
        	gasolina.setId(getMaxGasolinaId() + 1); 

        
        ((GasolinaService) gasolina).delete(gasolina.getId()); 

        
        gasolinas.put(gasolina.getId(), gasolina);
        return gasolina;
    }
    
    /**
     * Devuelve el id más alto del mapa gasolinas
     * @return
     */
    private Long getMaxGasolinaId() {
    	if (gasolinas.isEmpty())
			return 0L;

        return Collections.max(gasolinas.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
    
    @Override
    public boolean delete(Long id) {
        if (id == null || !gasolinas.containsKey(id))
            return false;
        gasolinas.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!gasolinas.isEmpty())
        	gasolinas.clear();
    }

	@Override
	public List<Gasolina> findByNombre(String nombre) {
		List<Gasolina> results = new ArrayList<Gasolina>();
		for(Gasolina gasolina : gasolinas.values())
			if(gasolina.getNombre().equals(nombre))
				results.add(gasolina);
		return results;
	}

	@Override
	public List<Gasolina> findByType(String type) {
		List<Gasolina> results = new ArrayList<Gasolina>();
		for(Gasolina gasolina : gasolinas.values())
			if(gasolina.getType().equals(type))
				results.add(gasolina);
		return results;
	}

	@Override
	public List<Gasolina> findByColor(String color) {
		List<Gasolina> results = new ArrayList<Gasolina>();
		for(Gasolina gasolina : gasolinas.values())
			if(gasolina.getColor().equals(color))
				results.add(gasolina);
		return results;
	}

	@Override
	public List<Gasolina> findByPuertas(int puertas) {
		List<Gasolina> results = new ArrayList<Gasolina>();
		for(Gasolina gasolina : gasolinas.values())
			if(gasolina.getPuertas() == puertas)
				results.add(gasolina);
		return results;
	}
	
}
