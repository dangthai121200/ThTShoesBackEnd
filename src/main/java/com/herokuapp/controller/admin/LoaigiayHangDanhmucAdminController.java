package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListLGiayHangDMucAdmin;
import com.herokuapp.service.admin.LGiayHangDMucAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.LGIAY_HANG_DMUC)
public class LoaigiayHangDanhmucAdminController {

	@Autowired
	public LGiayHangDMucAdminService lGiayHangDMucAdminService;

	@GetMapping
	public ListLGiayHangDMucAdmin getAllLGiayHangDMuc() {
		return lGiayHangDMucAdminService.getAllLGiayHangDMuc();
	}

}
