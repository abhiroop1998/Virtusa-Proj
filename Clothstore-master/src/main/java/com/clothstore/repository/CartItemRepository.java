package com.clothstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.clothstore.domain.CartItem;
import com.clothstore.domain.Order;
import com.clothstore.domain.ShoppingCart;

@Transactional
public interface CartItemRepository extends CrudRepository<CartItem,Long>{
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

	List<CartItem> findByOrder(Order order);

}
