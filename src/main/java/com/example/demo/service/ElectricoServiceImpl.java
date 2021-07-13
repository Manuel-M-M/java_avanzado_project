package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Electrico;
import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.BatElectrica;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;


@Service
public class ElectricoServiceImpl implements ElectricoService {

	/**
	 * Emulates a database with java hashmap
	 */
    private static final Map<Long, Electrico> electricos = new HashMap<>();

    static{ 
    	
    	Electrico electrico1 = new Electrico(1L, "Honda", "M", "cian", 3,  
				new Bateria(1L),
				new Motor(1L),
				new Aire(1L),
				new BatElectrica(1L, 25, "medium"));
		
    	Electrico electrico2 = new Electrico(2L, "Audi", "G", "morado", 5, 
				new Bateria(2L),
				new Motor(2L),
				new Aire(2L),
				new BatElectrica(2L, 40, "low"));
    	
    	Electrico electrico3 = new Electrico(3L, "Mercedes", "V", "plata", 6, 
				new Bateria(3L),
				new Motor(3L),
				new Aire(3L),
				new BatElectrica(3L, 65, "full"));
    	
    	electricos.put(1L, electrico1);
    	electricos.put(2L, electrico2);
    	electricos.put(3L, electrico3);
    
    }
    
    @Override
    public Integer count() {
        return electricos.keySet().size();
    }

    @Override
    public List<Electrico> findAll() {
        return new ArrayList<>(electricos.values());
    }

    @Override
    public Electrico findOne(Long id) {
        return electricos.get(id);
    }

    @Override
    public Electrico save(Electrico electrico) {
    	
    	
        if (electrico.getId() == null || electrico.getId() == 0L) 
        	electrico.setId(getMaxElectricoId() + 1);  

        
        ((ElectricoService) electrico).delete(electrico.getId()); 

        
        electricos.put(electrico.getId(), electrico);
        return electrico;
    }
    
    /**
     * Devuelve el id más alto del mapa electricos
     * @return
     */
    private Long getMaxElectricoId() {
    	if (electricos.isEmpty())
			return 0L;

        return Collections.max(electricos.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
    
    @Override
    public boolean delete(Long id) {
        if (id == null || !electricos.containsKey(id))
            return false;
        electricos.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!electricos.isEmpty())
        	electricos.clear();
    }

	@Override
	public List<Electrico> findByNombre(String nombre) {
		return new ArrayList<>(electricos.values());
	}

	@Override
	public List<Electrico> findByType(String type) {
		return new ArrayList<>(electricos.values());
	}

	@Override
	public List<Electrico> findByColor(String color) {
		return new ArrayList<>(electricos.values());
	}

	@Override
	public List<Electrico> findByPuertas(int puertas) {
		return new ArrayList<>(electricos.values());
	}
    	
}
	

