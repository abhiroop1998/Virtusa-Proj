package com.clothstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.clothstore.domain.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{
	

}
