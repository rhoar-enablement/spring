package com.redhat.coolstore.productcatalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@DataJpaTest
public class ProductCatalogApplicationDevTests {
	
    @Autowired
    private ProductRepository products;
	
	@Test
	public void testFindAll() {
		List<Product> productList = products.findAll();
		assertEquals(productList.size(), 8);
	}
	
	@Test
	public void testFindOne() {
		Product product = products.findOne(444435L);
		assertTrue("Oculus Rift".equals(product.getName()));
	}
	
	
	@Test
	public void testSaveAndDeleteProduct() {
		
		Product newProduct = new Product();
		newProduct.setName("Test Prod");
		newProduct.setDescription("This is a description");
		newProduct.setPrice(10.00d);
		
		Product product = products.save(newProduct);
		long id = product.getItemId();
		
		assertNotNull(products.findOne(id));
		
		products.delete(product);
		
		assertNull(products.findOne(id));
	}
	
	

}
