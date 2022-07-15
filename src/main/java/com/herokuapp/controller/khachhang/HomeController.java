package com.herokuapp.controller.khachhang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.GiayDomain;
import com.herokuapp.domain.khachhang.InfoGiayDonHang;
import com.herokuapp.domain.khachhang.PageHomeDomain;
import com.herokuapp.domain.khachhang.PhuKienDomain;
import com.herokuapp.service.khachhang.GiayService;
import com.herokuapp.service.khachhang.PhukienService;
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
		List<GiayDomain> giayLatest = giayService.getListLatest(AMOUNT_GIAY_LASTEST);
		List<PhuKienDomain> phuKienLatest = phukienService.getListLatest(AMOUNT_PHUKIEN_LASTEST);
		pageHomeDomain.setGiayLatest(giayLatest);
		pageHomeDomain.setPhuKienLatest(phuKienLatest);
		return pageHomeDomain;
	}
	
//	@GetMapping(URL.TRANG_CHU)
//	public AddDonHangVangLai home() {
//		AddDonHangVangLai addDonHangVangLai = new AddDonHangVangLai();
//		Map<String, InfoGiayDonHang> map = new HashMap<String, InfoGiayDonHang>();
//		InfoGiayDonHang infoGiayDonHang = new InfoGiayDonHang();
//		infoGiayDonHang.setMamau("m1");
//		infoGiayDonHang.setMasize("s1");
//		infoGiayDonHang.setSoluong(10);
//		map.put("cc", infoGiayDonHang);
//		addDonHangVangLai.setGiays(map);
//		return addDonHangVangLai;
//	}
	
}
