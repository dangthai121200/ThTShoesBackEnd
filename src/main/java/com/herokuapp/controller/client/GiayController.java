package com.herokuapp.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.GiayDomainDetails;
import com.herokuapp.domain.khachhang.ListGiay;
import com.herokuapp.service.GiayService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG)
public class GiayController {

	@Autowired
	public GiayService giayService;

	@GetMapping(value = URL.GIAY)
	public ListGiay getAllGiay() {
		ListGiay listGiay = new ListGiay();
		listGiay.setGiayDomains(giayService.getAllGiay());
		return listGiay;
	}
	
	@GetMapping(value = URL.GIAY + "/{idGiay}")
	public GiayDomainDetails getGiayById(@PathVariable(name = "idGiay") String idGiay) {
		return giayService.getGiayById(idGiay);
	}
}
