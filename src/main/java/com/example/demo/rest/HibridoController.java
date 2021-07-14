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

import com.example.demo.domain.Hibrido;
import com.example.demo.service.HibridoService;

@Path("/hibrido")
@Component
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON)
public class HibridoController {

	private HibridoService hibridoService;
	
	public HibridoController(HibridoService hibridoService) {
		this.hibridoService = hibridoService;
	}
	
	/**
	 * GET http://localhost:8080/api/hibrido
	 */
    @GET
    public List<Hibrido> findAll(){
        return hibridoService.findAll();
    }
    
    /**
	 * GET http://localhost:8080/api/hibrido/nombre/Audi
	 * GET http://localhost:8080/api/hibrido/Mercedes
	 * GET http://localhost:8080/api/hibrido/Honda
	 */
    @Path("/nombre/{nombre}")
    @GET
    public List<Hibrido> findByNombre(@PathParam("nombre")String nombre){
        return hibridoService.findByNombre(nombre);
    }
    
    /**
	 * GET http://localhost:8080/api/hibrido/M
	 * GET http://localhost:8080/api/hibrido/G
	 * GET http://localhost:8080/api/hibrido/V
	 */
    @Path("/type/{type}")
    @GET
    public List<Hibrido> findByType(@PathParam("type")String type){
        return hibridoService.findByType(type);
    }
    
    /**
	 * GET http://localhost:8080/api/hibrido/cian
	 * GET http://localhost:8080/api/hibrido/morado
	 * GET http://localhost:8080/api/hibrido/plata
	 */
    @Path("/color/{color}")
    @GET
    public List<Hibrido> findByColor(@PathParam("color")String color){
        return hibridoService.findByColor(color);
    }
    
    /**
	 * GET http://localhost:8080/api/hibrido/puertas/3
	 * GET http://localhost:8080/api/hibrido/puertas/5
	 * GET http://localhost:8080/api/hibrido/puertas/6
	 */
    @Path("/puertas/{puertas}")
    @GET
    public List<Hibrido> findByPuertas(@PathParam("puertas")int puertas){
        return hibridoService.findByPuertas(puertas);
    }

    /**
     * GET
     * http://localhost:8080/api/hibrido/1
     * http://localhost:8080/api/hibrido/2
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	Hibrido hibrido = hibridoService.findOne(id);
        if (hibrido == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(hibrido).build();
    }

    /**
     * POST http://localhost:8080/api/hibrido
     */
    @POST // CREAR NUEVO
    public Response create(Hibrido hibrido){
        if (hibrido.getId() != 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Hibrido result = hibridoService.save(hibrido);
        return Response.ok(result).build();
    }

    /**
     * PUT http://localhost:8080/api/hibrido
     */
    @PUT // ACTUALIZAR
    public Response update(Hibrido hibrido){
        if (hibrido.getId() == null || hibrido.getId() == 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Hibrido result = hibridoService.save(hibrido);
        return Response.ok(result).build();
    }


    /**
     * DELETE
     * http://localhost:8080/api/hibrido/1
     * http://localhost:8080/api/hibrido/2
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!hibridoService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/hibrido
     */
    @DELETE
    public Response deleteAll(){
    	hibridoService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
