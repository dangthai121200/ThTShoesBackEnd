package com.herokuapp.controller.khachhang;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.KhachHangDomain;
import com.herokuapp.service.khachhang.KhachHangService;
import com.herokuapp.util.URL;

@RequestMapping(value = URL.KHACH_HANG)
@RestController
public class KhachHangController {

	@Autowired
	public KhachHangService khachHangService;

	@GetMapping(value = "/{idKH}")
	public KhachHangDomain getInfoKhachHangById(@PathVariable(name = "idKH") String idKh) {
		return khachHangService.getInfoKhachHangById(idKh);
	}

	@PutMapping()
	public KhachHangDomain updateInfoKhachHang(@RequestBody @Valid KhachHangDomain khachHangDomain) {
		return khachHangService.updateInfoKhachHang(khachHangDomain);
	}

}
