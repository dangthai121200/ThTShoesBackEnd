package com.herokuapp.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.LoaiPhuKienAdminDomain;
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

	@PostMapping
	public ResponseEntity<Object> addLoaiPhuKien(@RequestBody @Valid LoaiPhuKienAdminDomain loaiPhuKienAdminDomain) {
		try {
			loaiPhuKienAdminService.addLoaiPhuKien(loaiPhuKienAdminDomain);
			return ResponseEntity.ok("Thêm thành công");
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body("Thêm thất bại");
		}

	}
}
