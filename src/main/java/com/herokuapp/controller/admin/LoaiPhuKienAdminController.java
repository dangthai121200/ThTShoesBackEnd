package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListLoaiPhuKienAdmin;
import com.herokuapp.service.admin.LoaiPhuKienAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.LOAI_PHU_KIEN)
public class LoaiPhuKienAdminController {

	@Autowired
	public LoaiPhuKienAdminService loaiPhuKienAdminService;

	@GetMapping
	public ListLoaiPhuKienAdmin getAllLoaiPhuKien() {
		return loaiPhuKienAdminService.getAllLoaiPhuKien();
	}
}
