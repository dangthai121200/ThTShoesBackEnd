package com.herokuapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.KhachHangDomain;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.reponsitory.KhachHangReponsitory;

@Service
public class KhachHangServiceImpl implements KhachHangService {

//	@Autowired
//	public KhachHangSeqReponsitory khachHangSeqReponsitory;

	@Autowired
	public KhachHangReponsitory khachHangReponsitory;

	@Override
	public KhachHangDomain getInfoKhachHangById(String idKh) {
		Khachhang khachhang = khachHangReponsitory.findById(idKh).get();
		KhachHangDomain khachHangDomain = new KhachHangDomain();
		khachHangDomain.converToDomain(khachhang);
		return khachHangDomain;
	}

}
