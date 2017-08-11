package com.redhat.coolstore.productcatalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class ProductCatalogJPATests {

	@Inject
	ProductRepository catalog;

	
	@Test
	public void testFindAll() {
		List<Product> productList = catalog.findAll();
		assertEquals(productList.size(), 8);
	}
	
	@Test
	public void testFindByName() {
		Product product = catalog.findByName("Oculus Rift");
		assertTrue(444435L==product.getItemId());
	}
	
	
	@Test
	public void testSaveAndDeleteProduct() {
		
		Product newProduct = new Product();
		newProduct.setName("Test Prod");
		newProduct.setDescription("This is a description");
		newProduct.setPrice(10.00d);
		
		Product product = catalog.save(newProduct);
		long id = product.getItemId();
		
		assertNotNull(catalog.findOne(id));
		
		catalog.delete(product);
		
		assertNull(catalog.findOne(id));
	}

}
