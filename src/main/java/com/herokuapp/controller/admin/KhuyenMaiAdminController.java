package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.AddKhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.list.ListKhuyenMaiAdmin;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.KhuyenMaiAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.KHUYEN_MAI)
public class KhuyenMaiAdminController {

	@Autowired
	public KhuyenMaiAdminService khuyenMaiAdminService;

	@GetMapping
	public ListKhuyenMaiAdmin getAllKhuyenMai() {
		return khuyenMaiAdminService.getAllKhuyenMai();
	}

	@GetMapping(value = URL.GET_BY_ID + "/{makm}")
	public KhuyenMaiAdminDomain getKhuyenMaiById(@PathVariable("makm") String makm) {
		return khuyenMaiAdminService.getKhuyenMaiById(makm);
	}

	@PostMapping
	public ResponseEntity<String> addKhuyenMai(@RequestBody AddKhuyenMaiAdminDomain addKhuyenMaiAdminDomain) {
		khuyenMaiAdminService.addKhuyenMai(addKhuyenMaiAdminDomain);
		return ResponseEntity.ok("Thêm khuyến mãi thành công");
	}

	@PutMapping
	public String updateKhuyenMai(@RequestBody AddKhuyenMaiAdminDomain addKhuyenMaiAdminDomain)
			throws ThtShoesException {
		return khuyenMaiAdminService.updateKhuyenMai(addKhuyenMaiAdminDomain);
	}

}
