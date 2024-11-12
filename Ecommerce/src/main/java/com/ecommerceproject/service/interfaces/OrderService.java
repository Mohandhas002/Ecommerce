package com.ecommerceproject.service.interfaces;

import java.util.List;

import com.ecommerceproject.entities.Order;

public interface OrderService {
	Order placeOrder(Order order);
	List<Order> getOrdersHistory(Long user_id);
	Order getViewOneOrder(Long id);
	Order cancelOrder(Long id);
}
