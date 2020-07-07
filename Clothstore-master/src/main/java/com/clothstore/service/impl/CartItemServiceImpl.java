package com.clothstore.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothstore.domain.CartItem;
import com.clothstore.domain.Cloth;
import com.clothstore.domain.ClothToCartItem;
import com.clothstore.domain.Order;
import com.clothstore.domain.ShoppingCart;
import com.clothstore.domain.User;
import com.clothstore.domain.UserPayment;
import com.clothstore.repository.CartItemRepository;
import com.clothstore.repository.ClothToCartItemRepository;
import com.clothstore.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ClothToCartItemRepository clothToCartItemRepository;

	@Override
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getCloth().getCost())
				.multiply(new BigDecimal(cartItem.getQty()));

		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);

		cartItemRepository.save(cartItem);

		return cartItem;
	}

	@Override
	public CartItem addClothToCartItem(Cloth cloth, User user, int qty) {
		// TODO Auto-generated method stub
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

		for (CartItem cartItem : cartItemList) {
			if (cloth.getId() == cartItem.getCloth().getId()) {
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setSubtotal(new BigDecimal(cloth.getCost()).multiply(new BigDecimal(qty)));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setCloth(cloth);

		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(cloth.getCost()).multiply(new BigDecimal(qty)));
		cartItem = cartItemRepository.save(cartItem);

		ClothToCartItem clothToCartItem = new ClothToCartItem();
		clothToCartItem.setCloth(cloth);
		clothToCartItem.setCartItem(cartItem);
		clothToCartItemRepository.save(clothToCartItem);

		return cartItem;
	}

	@Override
	public CartItem findById(Long cartItemId) {
		Optional<CartItem> optionalItem = cartItemRepository.findById(cartItemId);
		CartItem cartItem = optionalItem.get();
		return cartItem;
	}

	@Override
	public void removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		clothToCartItemRepository.deleteByCartItem(cartItem);
		cartItemRepository.delete(cartItem);
		
	}

	@Override
	public CartItem save(CartItem cartItem) {
		// TODO Auto-generated method stub
		return cartItemRepository.save(cartItem);  
	}

	@Override
	public List<CartItem> findByOrder(Order order) {
		// TODO Auto-generated method stub
		return cartItemRepository.findByOrder(order);
	}

}
