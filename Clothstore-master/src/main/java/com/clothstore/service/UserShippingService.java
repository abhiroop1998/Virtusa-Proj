package com.clothstore.service;

import com.clothstore.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);

	void removeById(Long userShippingId);

}
