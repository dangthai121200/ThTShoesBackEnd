package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.UpdateTinhTrangDonHang;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.service.admin.DonHangAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN + URL.DON_HANG)
public class DonHangAdminController {

	@Autowired
	public DonHangAdminService donHangAdminService;

	@PutMapping(value = URL.TINH_TRANG)
	public ResponseEntity<String> updateStatusForDonhang(@RequestBody UpdateTinhTrangDonHang updateTinhTrangDonHang)
			throws ThtShoesException {
		String manhanvien = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal()).getManguoidung();
		try {
			donHangAdminService.updateStatusForDonhang(updateTinhTrangDonHang.getMadonhang(), manhanvien,
					updateTinhTrangDonHang.getTinhTrang());
			return ResponseEntity.ok("Cập nhật đơn hàng thành công");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vui lòng thử lại");
		}
	}

}
