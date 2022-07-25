package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListDanhMucAdminDomain;
import com.herokuapp.service.admin.DanhMucAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN + URL.DANH_MUC)
public class DanhMucAdminController {
	
	@Autowired
	public DanhMucAdminService danhMucAdminService;
	
	@GetMapping
	public ListDanhMucAdminDomain getAllDanhMuc() {
		return danhMucAdminService.getAllDanhMuc();
		
	}
}
