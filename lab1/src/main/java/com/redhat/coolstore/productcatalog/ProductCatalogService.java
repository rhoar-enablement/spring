package com.redhat.coolstore.productcatalog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/products")
public class ProductCatalogService {

    @Value("${coolstore.message:Hello World!}")
    String message;
    public String sayHello() {
        return message;
    }

    @GET
	public Response list() {
		return Response.ok(message,MediaType.APPLICATION_JSON).build();
	}
}