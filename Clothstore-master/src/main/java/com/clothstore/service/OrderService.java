package com.clothstore.service;

import com.clothstore.domain.BillingAddress;
import com.clothstore.domain.Order;
import com.clothstore.domain.Payment;
import com.clothstore.domain.ShippingAddress;
import com.clothstore.domain.ShoppingCart;
import com.clothstore.domain.User;

public interface OrderService {

	Order createOrder(ShoppingCart shoppingCart, 
			ShippingAddress shippingAddress, 
			BillingAddress billingAddress,
			Payment payment, 
			String shippingMethod, 
			User user);

	Order findById(Long id);
}
