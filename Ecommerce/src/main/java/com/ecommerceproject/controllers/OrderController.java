package com.ecommerceproject.controllers;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.entities.Order;
import com.ecommerceproject.services.OrderServiceImp;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/orders")
public class OrderController {
     
	
	private final OrderServiceImp orderService; 
	
	@PostMapping(value="/placeorder")
	public Order placeOrder(@RequestBody Order order) {
		order.setCurrentstatus("Pending");
		return orderService.placeOrder(order);
	}

	@GetMapping(value="/history/{user_id}")
	public List<Order> getOrdersHistory(@PathVariable Long user_id) {
		
		return orderService.getOrdersHistory(user_id);
	}

	@GetMapping(value="/{id}")
	public Order getViewOneOrder(@PathVariable Long id) {

		return orderService.getViewOneOrder(id);
	}

	@DeleteMapping("/{id}")
	public Order cancelOrder(@PathVariable Long id) {

		return orderService.cancelOrder(id);
	}

}
