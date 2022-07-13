package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListLoaiGiayAdmin;
import com.herokuapp.service.admin.LoaiGiayAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.LOAI_GIAY)
public class LoaiGiayAdminController {
	@Autowired
	public LoaiGiayAdminService loaiGiayAdminService;

	@GetMapping
	public ListLoaiGiayAdmin getAllLoaiGiay() {
		return loaiGiayAdminService.getAllLoaiGiay();
	}

}
