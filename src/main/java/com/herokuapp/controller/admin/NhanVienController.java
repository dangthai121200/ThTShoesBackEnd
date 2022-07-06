package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.InfoNhanvienDangKy;
import com.herokuapp.service.admin.NhanVienService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN)
public class NhanVienController {

	@Autowired
	public NhanVienService nhanVienService;

	@PostMapping(value = URL.ADD_NHAN_VIEN)
	public ResponseEntity<String> addNhanvien(@RequestBody InfoNhanvienDangKy infoNhanvienDangKy) {
		try {
			nhanVienService.addNhanVien(infoNhanvienDangKy);
			return ResponseEntity.ok("Đăng ký thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Đăng ký thất bại");
		}
	}

}