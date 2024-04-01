package com.mykart.cart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="T_PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="PRODUCT_ID")
	private Long id;
	
	@Column(name ="NAME", nullable = false)
	private String name;
	
	@Column(name ="DESCRIPTION", nullable = false)
	private String description;
	
	@Column(name ="PRICE", nullable = false)
	private long price;
	
	@Column(name ="TYPE", nullable = true)
	private String type;
	
	
}
