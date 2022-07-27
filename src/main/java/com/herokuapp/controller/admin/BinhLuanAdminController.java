package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.BinhLuanAdminDomain;
import com.herokuapp.domain.admin.list.ListBinhLuanAdmin;
import com.herokuapp.service.admin.BinhLuanAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN + URL.BINH_LUAN)
public class BinhLuanAdminController {
	@Autowired
	public BinhLuanAdminService binhLuanAdminService;

	@GetMapping
	public ListBinhLuanAdmin getAllBinhLuan() {
		return binhLuanAdminService.getAllBinhLuan();

	}

	@GetMapping(value = "/{mabl}")
	public BinhLuanAdminDomain getBinhLuanbyId(@PathVariable(name = "mabl") String mabl) {
		return binhLuanAdminService.getBinhLuanbyId(mabl);

	}

	@DeleteMapping(value = "/{mabl}")
	public ResponseEntity<String> deleteBinhLuan(@PathVariable(name = "mabl") String mabl) {
		try {
			binhLuanAdminService.deleteBinhLuan(mabl);
			return ResponseEntity.ok("Xóa bình luận thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Xóa bình luận thất bại");
		}
	}
}
