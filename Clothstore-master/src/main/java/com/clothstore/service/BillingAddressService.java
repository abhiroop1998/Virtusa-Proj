package com.clothstore.service;

import com.clothstore.domain.BillingAddress;
import com.clothstore.domain.UserBilling;

public interface BillingAddressService {

	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}
