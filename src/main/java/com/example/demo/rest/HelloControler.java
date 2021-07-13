package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;


@Component
@Path("/hello")
public class HelloControler {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String metodo1() {
		return "Hola desde método 1";
	}
}
