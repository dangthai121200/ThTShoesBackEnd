package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.ListKhuyenMai;
import com.herokuapp.service.KhuyenMaiService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG)
public class KhuyenMaiController {

	@Autowired
	public KhuyenMaiService khuyenMaiService;

	@GetMapping(value = URL.KHUYEN_MAI)
	public ListKhuyenMai getAllKhuyenMai() {
		return khuyenMaiService.getAllKhuyenMai();

	}
}
