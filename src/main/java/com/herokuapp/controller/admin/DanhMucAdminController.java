package com.herokuapp.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.DanhmucAdminDomain;
import com.herokuapp.domain.admin.list.ListDanhMucAdminDomain;
import com.herokuapp.handleexception.ThtShoesException;
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

	@PostMapping
	public ResponseEntity<String> addDanhMuc(@RequestBody @Valid DanhmucAdminDomain danhmucAdminDomain)
			throws ThtShoesException {
		try {
			danhMucAdminService.addDanhMuc(danhmucAdminDomain);
			return ResponseEntity.ok("Thêm danh mục thành công");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm danh mục thất bại");
		}
	}
}
