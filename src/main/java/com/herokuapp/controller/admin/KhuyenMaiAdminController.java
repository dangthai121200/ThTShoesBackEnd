package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.list.ListKhuyenMaiAdmin;
import com.herokuapp.service.admin.KhuyenMaiAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.KHUYEN_MAI)
public class KhuyenMaiAdminController {

	@Autowired
	public KhuyenMaiAdminService khuyenMaiAdminService;

	@GetMapping
	public ListKhuyenMaiAdmin getAllKhuyenMai() {
		return khuyenMaiAdminService.getAllKhuyenMai();
	}

	@GetMapping(value = URL.GET_BY_ID + "/{makm}")
	public KhuyenMaiAdminDomain getKhuyenMaiById(@PathVariable("makm") String makm) {
		return khuyenMaiAdminService.getKhuyenMaiById(makm);
	}

}
