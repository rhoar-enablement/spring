package com.redhat.coolstore.productcatalog;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/products")
public class ProductCatalogService {
	
	@Inject
	ProductRepository catalog;

	@GET
	public Response list() {
		List<Product> products = catalog.findAll();
		if(products==null || products.isEmpty()) {
			return Response.serverError().entity("Did not found any products").build();
		}
		return Response.ok(products,MediaType.APPLICATION_JSON).build();
	}
	
}
