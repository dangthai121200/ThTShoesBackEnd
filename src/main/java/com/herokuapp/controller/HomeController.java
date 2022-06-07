package com.herokuapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.GiayDomain;
import com.herokuapp.domain.khachhang.PageHomeDomain;
import com.herokuapp.service.GiayService;
import com.herokuapp.util.URL;

@RestController
public class HomeController {

	private static final int AMOUNT_SHOESE_LASTEST = 2;

	@Autowired
	public GiayService giayService;

	@GetMapping(URL.TRANG_CHU)
	public PageHomeDomain home() {
		PageHomeDomain pageHomeDomain = new PageHomeDomain();
		List<GiayDomain> giayDomains = giayService.getListLatest(AMOUNT_SHOESE_LASTEST);
		pageHomeDomain.setGiayDomains(giayDomains);
		return pageHomeDomain;
	}
}
