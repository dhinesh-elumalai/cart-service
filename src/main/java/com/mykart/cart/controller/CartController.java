package com.mykart.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mykart.cart.entity.Cart;
import com.mykart.cart.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/carts")
	public ResponseEntity<Cart> getProducts(@RequestBody Cart cart) {
		return new ResponseEntity<>(cartService.createCart(cart), HttpStatus.OK);
	}

	@PostMapping("/carts/{cartId}/products/{productId}")
	public ResponseEntity<Cart> getProductById(@PathVariable("cartId") Long cartId,
			@PathVariable("productId") Long productId) {
		return new ResponseEntity<>(cartService.addProductToCart(cartId, productId), HttpStatus.OK);
	}
}
