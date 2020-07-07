package com.clothstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.clothstore.domain.CartItem;
import com.clothstore.domain.ClothToCartItem;

@Transactional
public interface ClothToCartItemRepository extends CrudRepository<ClothToCartItem,Long>{

	void deleteByCartItem(CartItem cartItem);

}
