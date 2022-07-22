package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.list.ListDonHang;
import com.herokuapp.domain.khachhang.list.ListDonHangVangLai;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.service.khachhang.DonHangService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG + URL.DAT_HANG)
public class DonHangKhachHangController {

	@Autowired
	public DonHangService donHangService;

	@RequestMapping(value = URL.LICH_SU_DAT_HANG, method = RequestMethod.GET)
	public ResponseEntity<ListDonHang> getLichSuDonHangByKhachHangId() {
		String makh = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getManguoidung();
		try {
			ListDonHang listDonHang = donHangService.getLichSuDonHangByKhachHangId(makh);
			return ResponseEntity.ok(listDonHang);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@RequestMapping(value = URL.KHACH_VANG_LAI + URL.LICH_SU_DAT_HANG + "/{idKVL}", method = RequestMethod.GET)
	public ResponseEntity<ListDonHangVangLai> getLichSuDonHangByKhachVangLaiId(@PathVariable(name = "idKVL") String idKVL) {
		try {
			ListDonHangVangLai listDonHang = donHangService.getLichSuDonHangByKhachVangLaiId(idKVL);
			return ResponseEntity.ok(listDonHang);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().build();
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> addDonHang(@RequestBody AddDonHang addDonHang) throws ThtShoesException {
		try {
			donHangService.addDonHang(addDonHang);
			return ResponseEntity.ok("Thêm thành công");
		} catch (ThtShoesException ex) {
			throw ex;
		}catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vùi lòng thử lại");
		}

	}

	@RequestMapping(value = URL.KHACH_VANG_LAI, method = RequestMethod.POST)
	public ResponseEntity<String> addDonHangKhachVanglai(@RequestBody AddDonHangVangLai donHangVangLai) throws ThtShoesException {
		try {
			String idKHVL = donHangService.addDonHangKhachVangLai(donHangVangLai);
			return ResponseEntity.ok(idKHVL);
		} catch (ThtShoesException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vùi lòng thử lại");
		}

	}

}
