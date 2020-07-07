package com.clothstore.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothstore.domain.UserShipping;
import com.clothstore.repository.UserShippingRepository;
import com.clothstore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	
	@Autowired
	private UserShippingRepository userShippingRepository;

	@Override
	public UserShipping findById(Long id) {
		// TODO Auto-generated method stub
		Optional<UserShipping> optionalShipping = userShippingRepository.findById(id);
		UserShipping userShipping = optionalShipping.get();
		return userShipping;
	}

	@Override
	public void removeById(Long userShippingId) {
		// TODO Auto-generated method stub
		userShippingRepository.deleteById(userShippingId);
		
	}

	

}
