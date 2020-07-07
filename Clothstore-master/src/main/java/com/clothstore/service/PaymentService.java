package com.clothstore.service;

import com.clothstore.domain.Payment;
import com.clothstore.domain.UserPayment;

public interface PaymentService {

	Payment setByUserPayment(UserPayment userPayment, Payment payment);

}
