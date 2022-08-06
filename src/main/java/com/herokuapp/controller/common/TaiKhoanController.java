package com.herokuapp.controller.common;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public void changePassword(@RequestBody @Valid ChangePasswordDomain changePasswordDomain) {
		taiKhoanService.changePassword(changePasswordDomain);
	}

	@GetMapping(value = URL.FORGET_PASS + "/{email}")
	public ResponseEntity<Object> resertPassword(@PathVariable(name = "email") @Email String email) {
		try {
			taiKhoanService.resetPassword(email);
			return ResponseEntity.ok("Reset mật khẩu thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vui lỏng thử lại");
		}
	}
}
