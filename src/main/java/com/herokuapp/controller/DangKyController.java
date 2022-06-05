package com.herokuapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;
import com.herokuapp.service.DangKyService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.DANG_KY)
public class DangKyController {

	@Autowired
	private DangKyService dangKyService;

	@RequestMapping(value = URL.KHACH_HANG, method = RequestMethod.POST)
	public ResponseEntity<String> dangKyKhachHang(@RequestBody InfoKhachHangDangKy infoKhachHangDangKy) {
		try {
			dangKyService.dangKyKhachHang(infoKhachHangDangKy);
			return ResponseEntity.ok("Đăng Ký Thành Công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Đăng ký Thất bại");
		}
	}

	@RequestMapping(value = URL.KHACH_HANG + "/{manguoidung}", method = RequestMethod.GET)
	public ResponseEntity<String> authencationTaiKhoan(@PathVariable(name = "manguoidung") String manguoidung) {
		try {
			dangKyService.authencationTaiKhoan(manguoidung);
			return ResponseEntity.ok(manguoidung);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(manguoidung);
		}

	}
}
