package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.service.admin.GiayAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN)
public class GiayAdminController {

	@Autowired
	public GiayAdminService giayService;

	@GetMapping(value = URL.GIAY)
	public ListGiayAdmin getAllGiay() {
		return giayService.getAllGiay();
	}

	@PostMapping(value = URL.GIAY)
	public ResponseEntity<String> addGiay(@RequestBody GiayAdminDomain giayAdminDomain) {
		try {
			giayService.addGiay(giayAdminDomain);
			return ResponseEntity.ok("Thêm Thành Công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm thất bại");
		}

	}
}
