package com.herokuapp.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListKhachHangAdmin;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.KHACH_HANG)
public class KhachHangAdminController {
	
	@GetMapping
	public ListKhachHangAdmin getAllKhachHang() {
		return null;
	}
	
	
}
