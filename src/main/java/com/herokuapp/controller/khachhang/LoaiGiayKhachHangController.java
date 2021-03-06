package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.list.ListLoaiGiay;
import com.herokuapp.service.khachhang.LoaiGiayService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG + URL.LOAI_GIAY)
public class LoaiGiayKhachHangController {

	@Autowired
	public LoaiGiayService loaiGiayService;

	@GetMapping
	public ListLoaiGiay getAllLoaiGiay() {
		return loaiGiayService.getAllLoaiGiay();
	}
}
