package com.clothstore.service;

import com.clothstore.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);

	void removeById(Long creditCardId);
}
