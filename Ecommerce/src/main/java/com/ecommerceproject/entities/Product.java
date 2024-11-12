package com.ecommerceproject.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class Product {
     @Id
     @GeneratedValue (strategy=GenerationType.IDENTITY)
     private Long product_id;
     private String product_name;
     private String description;
     private double price;
     private Long available_products;
     private LocalDateTime created_time;
     private LocalDateTime updated_time;
     
     @PrePersist
     protected void onCreate() {
         created_time = LocalDateTime.now();
     }
     
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getAvailable_products() {
		return available_products;
	}
	public void setAvailable_products(Long available_products) {
		this.available_products = available_products;
	}
	public LocalDateTime getCreated_time() {
		return created_time;
	}
	public void setCreated_time(LocalDateTime created_time) {
		this.created_time = created_time;
	}
	public LocalDateTime getUpdated_time() {
		return updated_time;
	}
	public void setUpdated_time(LocalDateTime updated_time) {
		this.updated_time = updated_time;
	}
	
     
     
}