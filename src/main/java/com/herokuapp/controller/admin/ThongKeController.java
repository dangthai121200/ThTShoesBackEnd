package com.herokuapp.controller.admin;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.ThongKeTongAdminDomain;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
import com.herokuapp.domain.thongke.admin.ByDate;
import com.herokuapp.enums.TinhTrang;
import com.herokuapp.service.admin.DonHangAdminService;
import com.herokuapp.service.admin.GiayAdminService;
import com.herokuapp.service.admin.KhachHangAdminService;
import com.herokuapp.service.admin.PhuKienAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.THONG_KE)
public class ThongKeController {

	@Autowired
	public DonHangAdminService donHangAdminService;

	@Autowired
	public GiayAdminService giayAdminService;

	@Autowired
	public PhuKienAdminService phuKienAdminService;

	@Autowired
	public KhachHangAdminService khachHangAdminService;

	@GetMapping(value = URL.ALL)
	public ThongKeTongAdminDomain thongKeTongAll() {

		BigDecimal tongDoanhThu = donHangAdminService.thongKeDoanhThuAll();
		int tongDonHangChuaDuyet = donHangAdminService.countDongHangByStatus(TinhTrang.CHODUYET);
		int tongDonHangDaGiao = donHangAdminService.countDongHangByStatus(TinhTrang.DAGIAO);
		int tongDonTuChoi = donHangAdminService.countDongHangByStatus(TinhTrang.TUCHOI);
		int tongSoKhachHang = khachHangAdminService.countAllKhachHang();
		ThongKeTongAdminDomain thongKeTongAdminDomain = new ThongKeTongAdminDomain(String.valueOf(tongDoanhThu),
				String.valueOf(tongDonHangChuaDuyet), String.valueOf(tongDonHangDaGiao), String.valueOf(tongDonTuChoi),
				String.valueOf(tongSoKhachHang));
		return thongKeTongAdminDomain;
	}

	@PostMapping(value = URL.GIAY)
	public ListGiayAdmin thongKeGiayByThoiGian(@RequestBody @Valid ByDate byDate) {
		return giayAdminService.thongKeGiayByThoiGian(byDate);
	}

	@PostMapping(value = URL.PHU_KIEN)
	public ListPhuKienAdmin thongKePhuKienByThoiGian(@RequestBody @Valid ByDate byDate) {
		return phuKienAdminService.thongKePhuKienByThoiGian(byDate);
	}

	@PostMapping(value = URL.DON_HANG)
	public ResponseEntity<Object> thongKeDonHangByThoiGian(@RequestBody @Valid ByDate byDate) {
		try {
			return ResponseEntity.ok(donHangAdminService.getDonHangByDate(byDate));
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vui lòng thử lại");
		}

	}

	@PostMapping(value = URL.DOANH_THU)
	public ResponseEntity<Object> thongKeDoanhThuByDate(@RequestBody @Valid ByDate byDate) {
		try {
			return ResponseEntity.ok(donHangAdminService.thongKeAllDoanhThuByDay(byDate));
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Có lỗi xảy ra vui lòng thử lại");
		}
	}

}
