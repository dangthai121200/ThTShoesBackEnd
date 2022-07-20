package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.InfoNhanvienDangKy;
import com.herokuapp.domain.admin.NhanVienAdminDomain;
import com.herokuapp.domain.admin.list.ListNhanVienAdmin;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.service.admin.NhanVienService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN)
public class NhanVienAdminController {

	@Autowired
	public NhanVienService nhanVienService;

	@GetMapping
	public ListNhanVienAdmin getAllNhanVien() {
		return nhanVienService.getAllNhanVien();
	}

	@GetMapping(value = URL.GET_BY_ID + "/{manv}")
	public NhanVienAdminDomain getNhanVienyId(@PathVariable(name = "manv") String mavn) {
		return nhanVienService.getNhanVienyId(mavn);
	}

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

	@GetMapping(value = URL.INFO_NHAN_VIEN)
	public NhanVienAdminDomain getInfoNhanVien() {
		String idMaNhanvien = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal()).getManguoidung();
		return nhanVienService.getInfoNhanVien(idMaNhanvien);
	}

}
