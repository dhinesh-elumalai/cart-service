package com.mykart.cart.restclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mykart.cart.entity.Product;

@FeignClient(url = "http://localhost:8081/catalog-service")
public interface ProductClient {

	@GetMapping("/products")
	public List<Product> getProducts();
	
	@PostMapping("/products")
	public Product saveProducts(@RequestBody Product product);
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Long productId);
}
