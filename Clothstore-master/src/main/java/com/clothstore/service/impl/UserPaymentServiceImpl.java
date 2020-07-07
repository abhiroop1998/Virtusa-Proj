package com.clothstore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothstore.domain.UserPayment;
import com.clothstore.repository.UserPaymentRepository;
import com.clothstore.service.UserPaymentService;

@Service
public class UserPaymentServiceImpl implements UserPaymentService{
	
	@Autowired
	private UserPaymentRepository userPaymentRepository;
	
	public UserPayment findById(Long id) {
		Optional<UserPayment> optionalPayment = userPaymentRepository.findById(id);
		UserPayment userPayment = optionalPayment.get();
		return userPayment;
	}

	@Override
	public void removeById(Long id) {
		userPaymentRepository.deleteById(id);
		
	}
}
