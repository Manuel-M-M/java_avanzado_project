package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Hibrido;
import com.example.demo.domain.pieces.Aire;
import com.example.demo.domain.pieces.Bateria;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.TanqueHidrogeno;

@Service
public class HibridoServiceImpl  implements HibridoService{

	/**
	 * Emulates a database with java hashmap
	 */
    private static final Map<Long, Hibrido> hibridos = new HashMap<>();

    static{ 
    	
    	Hibrido hibrido1 = new Hibrido(1L, "Audi", "M", "cian", 3,  
				new Bateria(1L),
				new Motor(1L),
				new Aire(1L),
				new TanqueHidrogeno(1L, 150, "Xerg"));
		
    	Hibrido hibrido2 = new Hibrido(2L, "Honda", "G", "morado", 5, 
				new Bateria(2L),
				new Motor(2L),
				new Aire(2L),
				new TanqueHidrogeno(2L, 180, "Lark"));
    	
    	Hibrido hibrido3 = new Hibrido(3L, "Mercedes", "V", "plata", 6, 
				new Bateria(3L),
				new Motor(3L),
				new Aire(3L),
				new TanqueHidrogeno(3L, 200, "Ztr"));
    	
    	hibridos.put(1L, hibrido1);
    	hibridos.put(2L, hibrido2);
    	hibridos.put(3L, hibrido3);
    
    }
    
    @Override
    public Integer count() {
        return hibridos.keySet().size();
    }

    @Override
    public List<Hibrido> findAll() {
        return new ArrayList<>(hibridos.values());
    }

    @Override
    public Hibrido findOne(Long id) {
        return hibridos.get(id);
    }

    @Override
    public Hibrido save(Hibrido hibrido) {
    	
    	
        if (hibrido.getId() == null || hibrido.getId() == 0L) 
        	hibrido.setId(getMaxHibridoId() + 1); 

        
        ((HibridoService) hibrido).delete(hibrido.getId()); 

        
        hibridos.put(hibrido.getId(), hibrido);
        return hibrido;
    }
    
    /**
     * Devuelve el id más alto del mapa hibridos
     * @return
     */
    private Long getMaxHibridoId() {
    	if (hibridos.isEmpty())
			return 0L;

        return Collections.max(hibridos.entrySet(),
                (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())
        ).getKey();
    }
    
    @Override
    public boolean delete(Long id) {
        if (id == null || !hibridos.containsKey(id))
            return false;
        hibridos.remove(id);
        return true;
    }

    @Override
    public void deleteAll() {
        if (!hibridos.isEmpty())
        	hibridos.clear();
    }

	@Override
	public List<Hibrido> findByNombre(String nombre) {
		return new ArrayList<>(hibridos.values());
	}

	@Override
	public List<Hibrido> findByType(String type) {
		return new ArrayList<>(hibridos.values());
	}

	@Override
	public List<Hibrido> findByColor(String color) {
		return new ArrayList<>(hibridos.values());
	}

	@Override
	public List<Hibrido> findByPuertas(int puertas) {
		return new ArrayList<>(hibridos.values());
	}
	
}
