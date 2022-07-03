package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.common.ChangePasswordDomain;
import com.herokuapp.service.common.TaiKhoanService;
import com.herokuapp.util.URL;

@RestController
public class TaiKhoanController {
	
	@Autowired
	public TaiKhoanService taiKhoanService;

	@PutMapping(value = URL.CHANGE_PASSWORD)
	public void changePassword(@RequestBody ChangePasswordDomain changePasswordDomain) {
		taiKhoanService.changePassword(changePasswordDomain);
	}
}
