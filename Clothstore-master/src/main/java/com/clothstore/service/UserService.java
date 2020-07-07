package com.clothstore.service;

import java.util.Set;

import com.clothstore.domain.User;
import com.clothstore.domain.UserBilling;
import com.clothstore.domain.UserPayment;
import com.clothstore.domain.UserShipping;
import com.clothstore.domain.security.PasswordResetToken;
import com.clothstore.domain.security.UserRole;

public interface UserService {
	
	PasswordResetToken getPasswordResetToken(final String Token);
	
	void createPasswordResetTokenForUser(final User user,final String token);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	User save(User user);

	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserShipping(UserShipping userShipping, User user);

	void setUserDefaultPayment(Long userPaymentId, User user);

	void setUserDefaultShipping(Long defaultShippingId, User user);

	User findById(Long id);

	

}
