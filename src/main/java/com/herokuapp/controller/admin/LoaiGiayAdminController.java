package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.LoaiGiayAdminDomain;
import com.herokuapp.domain.admin.list.ListLoaiGiayAdmin;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.LoaiGiayAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.LOAI_GIAY)
public class LoaiGiayAdminController {
	@Autowired
	public LoaiGiayAdminService loaiGiayAdminService;

	@GetMapping
	public ListLoaiGiayAdmin getAllLoaiGiay() {
		return loaiGiayAdminService.getAllLoaiGiay();
	}

	@PostMapping
	public ResponseEntity<String> addLoaiGiay(@RequestBody LoaiGiayAdminDomain loaiGiayAdminDomain)
			throws ThtShoesException {
		try {
			loaiGiayAdminService.addLoaiGiay(loaiGiayAdminDomain);
			return ResponseEntity.ok("Thêm loại giày thành công");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm loại giày thất bại");
		}
	}

}
