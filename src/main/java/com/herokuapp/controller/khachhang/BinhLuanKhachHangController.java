package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;
import com.herokuapp.domain.khachhang.list.ListBinhLuanKhachHang;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.service.khachhang.BinhLuanKhachHangService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.KHACH_HANG + URL.BINH_LUAN)
public class BinhLuanKhachHangController {

	@Autowired
	public BinhLuanKhachHangService binhLuanKhachHangService;

	@PostMapping
	public ResponseEntity<String> binhLuanSanPham(@RequestBody BinhLuanKhachHangDomain binhLuanKhachHangDomain) {

		String makh = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getManguoidung();
		binhLuanKhachHangService.binhLuanSanPham(binhLuanKhachHangDomain, makh);
		return ResponseEntity.ok("Bình luận thành công");

	}
	
	@GetMapping(value = URL.GIAY + "/{magiay}")
	public ListBinhLuanKhachHang getAllBinhLuanByIdGiay(@PathVariable(name = "magiay") String magiay) {
		return binhLuanKhachHangService.getAllBinhLuanByIdGiay(magiay);

	}
	
	@GetMapping(value = URL.PHU_KIEN + "/{mapk}")
	public ListBinhLuanKhachHang getAllBinhLuanByIdPhuKien(@PathVariable(name = "mapk") String mapk) {
		return binhLuanKhachHangService.getAllBinhLuanByIdPhuKien(mapk);

	}

}
