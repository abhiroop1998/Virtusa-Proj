package com.clothstore.service;

import com.clothstore.domain.ShippingAddress;
import com.clothstore.domain.UserShipping;

public interface ShippingAddressService {

	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
