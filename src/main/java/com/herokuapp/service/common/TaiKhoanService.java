package com.herokuapp.service.common;

import javax.mail.MessagingException;
import javax.validation.constraints.Email;

import com.herokuapp.domain.common.ChangePasswordDomain;

public interface TaiKhoanService {
	void changePassword(ChangePasswordDomain changePasswordDomain);

	Boolean checkUsername(String username);

	Boolean checkEmail(String email);

	void resetPassword(@Email String email) throws MessagingException;
}
