package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.khachhang.PhuKienDomain;
import com.herokuapp.domain.khachhang.list.ListPhukien;
import com.herokuapp.service.khachhang.PhukienService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.KHACH_HANG + URL.PHU_KIEN)
public class PhuKienKhachHangController {

	@Autowired
	public PhukienService phukienService;

	@GetMapping
	public ListPhukien getAllPhukien() {
		ListPhukien listPhukien = new ListPhukien();
		listPhukien.setPhukiens(phukienService.getAllPhukien());
		return listPhukien;
	}
	
	@GetMapping(value = "/{idPk}")
	public PhuKienDomain getPhukienById(@PathVariable("idPk") String idPk) {
		
		return phukienService.getPhukienById(idPk);
	}

}
