package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.service.DonHangService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG)
public class DonHangController {

	@Autowired
	public DonHangService donHangService;

	@RequestMapping(value = URL.DAT_HANG, method = RequestMethod.POST)
	public ResponseEntity<String> addDonHang(@RequestBody AddDonHang addDonHang) {
		try {
			donHangService.addDonHang(addDonHang);
			return ResponseEntity.ok("Thêm thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vùi lòng thử lại");
		}
		
	}
}
