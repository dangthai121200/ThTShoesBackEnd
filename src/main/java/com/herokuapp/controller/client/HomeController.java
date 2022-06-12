package com.herokuapp.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.GiayDomainGeneral;
import com.herokuapp.domain.khachhang.PageHomeDomain;
import com.herokuapp.domain.khachhang.PhuKienDomain;
import com.herokuapp.service.GiayService;
import com.herokuapp.service.PhukienService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG)
public class HomeController {

	private static final int AMOUNT_GIAY_LASTEST = 18;
	private static final int AMOUNT_PHUKIEN_LASTEST = 18;

	@Autowired
	public GiayService giayService;

	@Autowired
	public PhukienService phukienService;

	@GetMapping(URL.TRANG_CHU)
	public PageHomeDomain home() {
		PageHomeDomain pageHomeDomain = new PageHomeDomain();
		List<GiayDomainGeneral> giayLatest = giayService.getListLatest(AMOUNT_GIAY_LASTEST);
		List<PhuKienDomain> phuKienLatest = phukienService.getListLatest(AMOUNT_PHUKIEN_LASTEST);
		pageHomeDomain.setGiayLatest(giayLatest);
		pageHomeDomain.setPhuKienLatest(phuKienLatest);
		return pageHomeDomain;
	}
}
