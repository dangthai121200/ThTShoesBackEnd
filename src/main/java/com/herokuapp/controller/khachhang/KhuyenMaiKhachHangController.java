package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.KhuyenMaiDomain;
import com.herokuapp.domain.khachhang.list.ListKhuyenMai;
import com.herokuapp.service.khachhang.KhuyenMaiService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG + URL.KHUYEN_MAI)
public class KhuyenMaiKhachHangController {

	@Autowired
	public KhuyenMaiService khuyenMaiService;

	@GetMapping
	public ListKhuyenMai getAllKhuyenMai() {
		return khuyenMaiService.getAllKhuyenMai();

	}

	@GetMapping(value = "/{idKm}")
	public KhuyenMaiDomain getKhuyenMaiById(@PathVariable("idKm") String idKm) {
		return khuyenMaiService.getKhuyenMaiById(idKm);
	}
}
