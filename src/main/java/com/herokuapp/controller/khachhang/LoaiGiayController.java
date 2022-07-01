package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.ListLoaiGiay;
import com.herokuapp.service.LoaiGiayService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG)
public class LoaiGiayController {

	@Autowired
	public LoaiGiayService loaiGiayService;

	@GetMapping(value = URL.LOAI_GIAY)
	public ListLoaiGiay getAllLoaiGiay() {
		return loaiGiayService.getAllLoaiGiay();
	}
}
