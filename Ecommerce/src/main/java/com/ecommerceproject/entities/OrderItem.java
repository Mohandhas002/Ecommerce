package com.ecommerceproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderItem {
        @Id
        @GeneratedValue (strategy=GenerationType.IDENTITY)
        private long id;
        private long order_id;
        private long product_id;
        private int quantity;
        private double price;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getOrder_id() {
			return order_id;
		}
		public void setOrder_id(long order_id) {
			this.order_id = order_id;
		}
		public long getProduct_id() {
			return product_id;
		}
		public void setProduct_id(long product_id) {
			this.product_id = product_id;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
        
        
        
}
