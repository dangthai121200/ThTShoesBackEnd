package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListDonHangAdmin;
import com.herokuapp.domain.thongke.admin.ByDate;
import com.herokuapp.service.admin.DonHangAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.THONG_KE)
public class ThongKeController {
	
	@Autowired
	public DonHangAdminService donHangAdminService;
	
	@GetMapping(value = URL.DON_HANG)
	public ListDonHangAdmin thongKeDonHangByThoiGian(@RequestBody ByDate byDate) {
		return donHangAdminService.getDonHangByDate(byDate);
	}
	
}
