package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;
import com.herokuapp.service.common.TaiKhoanService;
import com.herokuapp.service.khachhang.DangKyService;
import com.herokuapp.service.khachhang.KhachHangService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN)
public class DangKyController {

	@Autowired
	private DangKyService dangKyService;

	@Autowired
	private TaiKhoanService taiKhoanService;

	@Autowired
	private KhachHangService khachHangService;

	@RequestMapping(value = URL.DANG_KY, method = RequestMethod.POST)
	public ResponseEntity<String> dangKyKhachHang(@RequestBody InfoKhachHangDangKy infoKhachHangDangKy) {
		StringBuilder messError = new StringBuilder();
		Boolean checkUsername = taiKhoanService.checkUsername(infoKhachHangDangKy.getTaiKhoan().getUsername());
		Boolean checkEmail = taiKhoanService.checkEmail(infoKhachHangDangKy.getTaiKhoan().getEmail());
		Boolean checkSdt = khachHangService.checkSdt(infoKhachHangDangKy.getKhachHang().getSdt());
		if (checkUsername) {
			messError.append("Username đã tồn tại, ");
		}
		if (checkEmail) {
			messError.append("Email đã tồn tại, ");
		}
		if (checkSdt) {
			messError.append("Số điện thoại đã tồn tại, ");
		}
		try {
			if (!checkUsername && !checkEmail && !checkSdt) {
				dangKyService.dangKyKhachHang(infoKhachHangDangKy);
				return ResponseEntity.ok("Đăng Ký Thành Công");
			} else {
				return ResponseEntity.badRequest().body(messError.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Đăng ký Thất bại");
		}
	}

}
