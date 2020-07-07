package com.clothstore.service;

import java.util.List;

import com.clothstore.domain.CartItem;
import com.clothstore.domain.Cloth;
import com.clothstore.domain.Order;
import com.clothstore.domain.ShoppingCart;
import com.clothstore.domain.User;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	CartItem updateCartItem(CartItem cartItem);

	CartItem addClothToCartItem(Cloth cloth, User user, int qty);

	CartItem findById(Long cartItemId);

	void removeCartItem(CartItem cartItem);

	CartItem save(CartItem cartItem);

	List<CartItem> findByOrder(Order order);
}
