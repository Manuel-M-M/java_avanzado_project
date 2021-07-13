package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.service.CarFactory;

/**
 * CRUD
 * 
 * RETRIEVE ONE id RETRIEVE ALL
 */
@Component
@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
public class CarController {

	/**
	 * http://localhost:8080/api/car/electrico
	 * http://localhost:8080/api/car/hibrido
	 * http://localhost:8080/api/car/gasolina
	 * http://localhost:8080/api/car/pickUp (NO EXISTE, DARÁ 404 NOT
	 * FOUND)
	 * 
	 * @param type
	 * @return
	 */
	@GET
	@Path("/{type}")
	public Response createByType(@PathParam("type") String type) {

		try {
			return Response
					.ok()
					.entity(CarFactory.createByType(type))
					.build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
