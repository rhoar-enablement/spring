package com.redhat.coolstore;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Path("/products")
public class ProductCatalogRESTService {
	
	@Value("${catalog.default.products}")
	String defaultProducts;
	
	@Autowired
	ProductRepository catalog;

	@GET
	public Response list() {
		List<Product> products = catalog.findAll();
		if(products==null || products.isEmpty()) {
			return Response.serverError().entity("Did not found any products").build();
		}
		return Response.ok(products,MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/defaultlist")
	public Response defaultList() {
		return Response.ok(defaultProducts.split(","),MediaType.APPLICATION_JSON).build();
	}
	
}
