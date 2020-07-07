package com.clothstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.clothstore.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Long>{

}
