package com.herokuapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.KhachHangDomain;
import com.herokuapp.reponsitory.KhachHangReponsitory;

@Service
public class KhachHangServiceImpl implements KhachHangService {

//	@Autowired
//	public KhachHangSeqReponsitory khachHangSeqReponsitory;

	@Autowired
	public KhachHangReponsitory khachHangReponsitory;

}
