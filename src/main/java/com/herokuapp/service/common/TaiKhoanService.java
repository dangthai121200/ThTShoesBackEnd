package com.herokuapp.service.common;

import com.herokuapp.domain.common.ChangePasswordDomain;

public interface TaiKhoanService {
	void changePassword(ChangePasswordDomain changePasswordDomain);

	Boolean checkUsername(String username);

	Boolean checkEmail(String email);
}
