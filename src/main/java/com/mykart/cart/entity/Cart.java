package com.mykart.cart.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;

@Entity
@Table(name ="T_CART")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private Long id;
	
	@Column(name = "total_price")
	private long totalPrice;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinTable(joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> products;

	
	
	
	@Override
	public String toString() {
		return "Cart [id=" + id + ", totalPrice=" + totalPrice + ", products=" + products + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
