package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.DoanhThuAdmin;
import com.herokuapp.domain.admin.list.ListDonHangAdmin;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
import com.herokuapp.domain.thongke.admin.ByDate;
import com.herokuapp.service.admin.DonHangAdminService;
import com.herokuapp.service.admin.GiayAdminService;
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
	
	@GetMapping(value = URL.GIAY)
	public ListGiayAdmin thongKeGiayByThoiGian(@RequestBody ByDate byDate) {
		return giayAdminService.thongKeGiayByThoiGian(byDate);
	}
	
	@GetMapping(value = URL.PHU_KIEN)
	public ListPhuKienAdmin thongKePhuKienByThoiGian(@RequestBody ByDate byDate) {
		return phuKienAdminService.thongKePhuKienByThoiGian(byDate);
	}
	
	@GetMapping(value = URL.DON_HANG)
	public ListDonHangAdmin thongKeDonHangByThoiGian(@RequestBody ByDate byDate) {
		return donHangAdminService.getDonHangByDate(byDate);
	}
	
	@GetMapping(value = URL.DOANH_THU)
	public DoanhThuAdmin thongKeDoanhThu(@RequestBody ByDate byDate) {
		return donHangAdminService.thongKeDoanhThu(byDate);
	}
	
	
	
}
