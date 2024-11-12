package com.ecommerceproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecommerceproject.entities.Order;
import com.ecommerceproject.repositories.OrderRepository;
import com.ecommerceproject.service.interfaces.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImp implements OrderService{
	
	
	private final OrderRepository orderRepository;

	@Override
	public Order placeOrder(Order order) {
		System.out.println(order.toString());
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getOrdersHistory(Long userid) {
	    List<Order> orders = orderRepository.findByuserid(userid);
		return orders;
	}

	@Override
	public Order getViewOneOrder(Long id) {
		Optional<Order> ord = orderRepository.findById(id);
		
		if(ord.isPresent()) {
			Order order= ord.get();
			return order;
		}
		else {
			throw new RuntimeException("Order Not Available");
		}
	}

	@Override
	public Order cancelOrder(Long id) {
		Optional<Order> order=orderRepository.findById(id);
		
		if(order.isPresent()) {
			Order cancelOrder=order.get();
			cancelOrder.setCurrentstatus("Cancelled");
			orderRepository.save(cancelOrder);
			return cancelOrder; 
		}
		else {
			throw new RuntimeException("No Orders Found");
		}
		
		
	}
        
}
