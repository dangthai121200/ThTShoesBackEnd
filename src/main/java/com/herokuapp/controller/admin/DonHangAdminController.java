package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.UpdateTinhTrangDonHang;
import com.herokuapp.service.admin.DonHangAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN)
public class DonHangAdminController {

	@Autowired
	public DonHangAdminService donHangAdminService;

	@PutMapping(value = URL.DON_HANG)
	public ResponseEntity<String> updateStatusForDonhang(@RequestBody UpdateTinhTrangDonHang updateTinhTrangDonHang) {
		try {
			donHangAdminService.updateStatusForDonhang(updateTinhTrangDonHang.getMadonhang(),
					updateTinhTrangDonHang.getTinhTrang());
			return ResponseEntity.ok("Cập nhật đơn hàng thành công");
		} catch (Exception ex) {
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vui lòng thử lại");
		}
	}

}
