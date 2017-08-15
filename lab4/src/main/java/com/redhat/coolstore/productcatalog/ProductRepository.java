package com.redhat.coolstore.productcatalog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findByName(String name);


}
