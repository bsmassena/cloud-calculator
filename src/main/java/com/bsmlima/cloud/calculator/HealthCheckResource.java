package com.bsmlima.cloud.calculator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import netflix.karyon.health.HealthCheckHandler;

@Path("/healthcheck")
public class HealthCheckResource implements HealthCheckHandler{
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response healthCheck() {
        return Response.status(getStatus()).build();
    }

	@Override
	public int getStatus() {
		return 200;
	}
	
}
