package com.clothstore.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothstore.domain.BillingAddress;
import com.clothstore.domain.CartItem;
import com.clothstore.domain.Cloth;
import com.clothstore.domain.Order;
import com.clothstore.domain.Payment;
import com.clothstore.domain.ShippingAddress;
import com.clothstore.domain.ShoppingCart;
import com.clothstore.domain.User;
import com.clothstore.repository.OrderRepository;
import com.clothstore.service.CartItemService;
import com.clothstore.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;

	@Override
	public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for(CartItem cartItem : cartItemList) {
			Cloth cloth = cartItem.getCloth();
			cartItem.setOrder(order);
			cloth.setStockNumber(cloth.getStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
		
	}

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Order> optionalOrder = orderRepository.findById(id);
		Order order = optionalOrder.get();
		return order;
	}

}
