package com.mykart.cart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mykart.cart.entity.Cart;
import com.mykart.cart.entity.Product;
import com.mykart.cart.repo.CartRepository;
import com.mykart.cart.restclient.ProductClient;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductClient productClient;
	
	public Cart getCartById(long id) {
		return cartRepository.findById(id).isPresent()?cartRepository.getById(id):null;
	}
	
	
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public Cart addProductsToCart(Long cartId, List<Long> productIds) {
		Cart cart = cartRepository.getById(cartId);
		List<Product> products = new ArrayList<>();
		for(long id: productIds) {
			Product product = productClient.getProductById(id);
			products.add(product);
		}
		cart.setProducts(products);
		return cartRepository.save(cart);
	}
	
	public Cart addProductToCart(Long cartId, Long productId) {
		Cart cart = cartRepository.getById(cartId);
		List<Product> products = cart.getProducts();
		if(products == null) {
			products = new ArrayList<>();
		}
		Product product = productClient.getProductById(productId);
		products.add(product);
		cart.setProducts(products);
		return cartRepository.save(cart);
	}
}
