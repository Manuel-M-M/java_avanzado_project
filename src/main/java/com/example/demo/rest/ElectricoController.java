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

import com.example.demo.domain.Electrico;
import com.example.demo.service.ElectricoService;

@Path("/electrico")
@Component
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class ElectricoController {

	private ElectricoService electricoService;

	public ElectricoController(ElectricoService electricoService) {
		this.electricoService = electricoService;
	}
	
	/**
	 * GET http://localhost:8080/api/smartphone
	 */
    @GET
    public List<Electrico> findAll(){
        return electricoService.findAll();
    }
    
    /**
	 * GET http://localhost:8080/api/electrico/Audi
	 * GET http://localhost:8080/api/electrico/Mercedes
	 * GET http://localhost:8080/api/electrico/Honda
	 */
    @Path("{nombre}")
    @GET
    public List<Electrico> findByNombre(@PathParam("nombre")String nombre){
        return electricoService.findByNombre(nombre);
    }
    
    /**
	 * GET http://localhost:8080/api/electrico/M
	 * GET http://localhost:8080/api/electrico/G
	 * GET http://localhost:8080/api/electrico/V
	 */
    @Path("{type}")
    @GET
    public List<Electrico> findByType(@PathParam("type")String type){
        return electricoService.findByType(type);
    }
    
    /**
	 * GET http://localhost:8080/api/electrico/cian
	 * GET http://localhost:8080/api/electrico/morado
	 * GET http://localhost:8080/api/electrico/plata
	 */
    @Path("{color}")
    @GET
    public List<Electrico> findByColor(@PathParam("color")String color){
        return electricoService.findByColor(color);
    }
    
    /**
	 * GET http://localhost:8080/api/electrico/puertas/3
	 * GET http://localhost:8080/api/electrico/puertas/5
	 * GET http://localhost:8080/api/electrico/puertas/6
	 */
    @Path("/puertas/{puertas}")
    @GET
    public List<Electrico> findByPuertas(@PathParam("puertas")int puertas){
        return electricoService.findByPuertas(puertas);
    }

    /**
     * GET
     * http://localhost:8080/api/electrico/1
     * http://localhost:8080/api/electrico/2
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	Electrico electrico = electricoService.findOne(id);
        if (electrico == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(electrico).build();
    }

    /**
     * POST http://localhost:8080/api/electrico
     */
    @POST // CREAR NUEVO
    public Response create(Electrico electrico){
        if (electrico.getId() != 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Electrico result = electricoService.save(electrico);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/electrico
     */
    @PUT // ACTUALIZAR
    public Response update(Electrico electrico){
        if (electrico.getId() == null || electrico.getId() == 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Electrico result = electricoService.save(electrico);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/electrico/1
     * http://localhost:8080/api/electrico/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!electricoService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/smartphone
     */
    @DELETE
    public Response deleteAll(){
    	electricoService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
