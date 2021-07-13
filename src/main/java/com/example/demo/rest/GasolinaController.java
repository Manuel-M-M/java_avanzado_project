package com.example.demo.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.Gasolina;
import com.example.demo.service.GasolinaService;

@Path("/gasolina")
@Component
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class GasolinaController {

	private GasolinaService gasolinaService;
	
	public GasolinaController(GasolinaService gasolinaService) {
		this.gasolinaService = gasolinaService;
	}
	
	/**
	 * GET http://localhost:8080/api/gasolina
	 */
    @GET
    public List<Gasolina> findAll(){
        return gasolinaService.findAll();
    }
    
    /**
	 * GET http://localhost:8080/api/gasolina/Audi
	 * GET http://localhost:8080/api/gasolina/Mercedes
	 * GET http://localhost:8080/api/gasolina/Honda
	 */
    @GET
    public List<Gasolina> findByNombre(String nombre){
        return gasolinaService.findByNombre(nombre);
    }
    
    /**
	 * GET http://localhost:8080/api/gasolina/M
	 * GET http://localhost:8080/api/gasolina/G
	 * GET http://localhost:8080/api/gasolina/V
	 */
    @GET
    public List<Gasolina> findByType(String type){
        return gasolinaService.findByType(type);
    }
    
    /**
	 * GET http://localhost:8080/api/gasolina/cian
	 * GET http://localhost:8080/api/gasolina/morado
	 * GET http://localhost:8080/api/gasolina/plata
	 */
    @GET
    public List<Gasolina> findByColor(String color){
        return gasolinaService.findByColor(color);
    }
    
    /**
	 * GET http://localhost:8080/api/gasolina/puertas/3
	 * GET http://localhost:8080/api/gasolina/puertas/5
	 * GET http://localhost:8080/api/gasolina/puertas/6
	 */
    @Path("/puertas/{puertas}")
    @GET
    public List<Gasolina> findByPuertas(@PathParam("puertas")int puertas){
        return gasolinaService.findByPuertas(puertas);
    }

    /**
     * GET
     * http://localhost:8080/api/gasolina/1
     * http://localhost:8080/api/gasolina/2
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	Gasolina gasolina = gasolinaService.findOne(id);
        if (gasolina == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(gasolina).build();
    }

    /**
     * POST http://localhost:8080/api/gasolina
     */
    @POST // CREAR NUEVO
    public Response create(Gasolina gasolina){
        if (gasolina.getId() != 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Gasolina result = gasolinaService.save(gasolina);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/gasolina
     */
    @PUT // ACTUALIZAR
    public Response update(Gasolina gasolina){
        if (gasolina.getId() == null || gasolina.getId() == 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Gasolina result = gasolinaService.save(gasolina);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/gasolina/1
     * http://localhost:8080/api/gasolina/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!gasolinaService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/hibrido
     */
    @DELETE
    public Response deleteAll(){
    	gasolinaService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
