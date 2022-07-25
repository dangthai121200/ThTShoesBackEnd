package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.HangAdminDomain;
import com.herokuapp.domain.admin.list.ListHangAdminDomain;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.HangAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.HANG)
public class HangAdminController {

	@Autowired
	public HangAdminService hangAdminService;

	@GetMapping
	public ListHangAdminDomain getAllLoaiGiay() {
		return hangAdminService.getAllHang();
	}

	@PostMapping
	public ResponseEntity<String> addHang(@RequestBody HangAdminDomain hangAdminDomain) throws ThtShoesException {
		try {
			hangAdminService.addHang(hangAdminDomain);
			return ResponseEntity.ok("Thêm hãng thành công");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm hãng thất bại");
		}
	}
}
