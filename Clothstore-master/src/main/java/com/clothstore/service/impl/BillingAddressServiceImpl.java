package com.clothstore.service.impl;

import org.springframework.stereotype.Service;

import com.clothstore.domain.BillingAddress;
import com.clothstore.domain.UserBilling;
import com.clothstore.service.BillingAddressService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService{

	@Override
	public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
		// TODO Auto-generated method stub
		billingAddress.setBillingAddressName(userBilling.getUserBillingName());
		billingAddress.setBillingAddressStreet1(userBilling.getUserBillingStreet1());
		billingAddress.setBillingAddressStreet2(userBilling.getUserBillingStreet2());
		billingAddress.setBillingAddressCity(userBilling.getUserBillingCity());
		billingAddress.setBillingAddressState(userBilling.getUserBillingState());
		billingAddress.setBillingAddressCountry(userBilling.getUserBillingCountry());
		billingAddress.setBillingAddressZipcode(userBilling.getUserBillingZipcode());
		
		return billingAddress;
	}

}
