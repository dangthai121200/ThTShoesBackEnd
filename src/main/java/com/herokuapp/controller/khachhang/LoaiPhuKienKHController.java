package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.list.ListLoaiPhuKien;
import com.herokuapp.service.khachhang.LoaiPhuKienService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.KHACH_HANG + URL.LOAI_PHU_KIEN)
public class LoaiPhuKienKHController {
	
	@Autowired
	private LoaiPhuKienService loaiPhuKienService;
	
	
	@GetMapping
	public ListLoaiPhuKien getAllLoaiPhKien() {
		return loaiPhuKienService.getAllLoaiPhuKien();
	}

}
