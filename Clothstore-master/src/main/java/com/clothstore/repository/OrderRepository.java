package com.clothstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.clothstore.domain.Order;

public interface OrderRepository extends CrudRepository<Order,Long>{

}
