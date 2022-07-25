package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListHangAdminDomain;
import com.herokuapp.service.admin.HangAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.HANG)
public class HangAdminController {

	@Autowired
	public HangAdminService hangAdminService;

	@GetMapping
	public ListHangAdminDomain getAllLoaiGiay() {
		return hangAdminService.getAllHang();
	}
}
