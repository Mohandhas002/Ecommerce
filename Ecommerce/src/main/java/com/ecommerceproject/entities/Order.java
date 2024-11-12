package com.ecommerceproject.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long userid;
	private double total_amount;
	private String Currentstatus;
	private LocalDateTime Created_time;
	private LocalDateTime updated_time;
	
	
	@PrePersist
    protected void onCreate() {
        Created_time = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String getCurrentstatus() {
		return Currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		Currentstatus = currentstatus;
	}

	public LocalDateTime getCreated_time() {
		return Created_time;
	}

	public void setCreated_time(LocalDateTime created_time) {
		Created_time = created_time;
	}

	public LocalDateTime getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(LocalDateTime updated_time) {
		this.updated_time = updated_time;
	}
     
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", total_amount=" + total_amount + ", Currentstatus="
				+ Currentstatus + "]";
	}

	

    
}