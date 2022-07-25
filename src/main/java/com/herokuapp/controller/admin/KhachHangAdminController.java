package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.KhachHangAdminDomain;
import com.herokuapp.domain.admin.list.ListKhachHangAdmin;
import com.herokuapp.service.admin.KhachHangAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.KHACH_HANG)
public class KhachHangAdminController {

	@Autowired
	public KhachHangAdminService khachHangAdminService;

	@GetMapping
	public ListKhachHangAdmin getAllKhachHang() {
		return khachHangAdminService.getAllKhachHang();
	}

	@GetMapping(value = "/{makh}")
	public KhachHangAdminDomain getKhachHangById(@PathVariable(name = "makh") String makh) {
		return khachHangAdminService.getKhachHangById(makh);
	}

}
