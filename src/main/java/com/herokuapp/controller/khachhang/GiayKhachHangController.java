package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.GiayDomain;
import com.herokuapp.domain.khachhang.list.ListGiay;
import com.herokuapp.service.khachhang.GiayService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG + URL.GIAY)
public class GiayKhachHangController {

	@Autowired
	public GiayService giayService;

	@GetMapping
	public ListGiay getAllGiay() {
		ListGiay listGiay = new ListGiay();
		listGiay.setGiays(giayService.getAllGiay());
		return listGiay;
	}
	
	@GetMapping(value = "/{idGiay}")
	public GiayDomain getGiayById(@PathVariable(name = "idGiay") String idGiay) {
		return giayService.getGiayById(idGiay);
	}
}
