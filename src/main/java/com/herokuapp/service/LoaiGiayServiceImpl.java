package com.herokuapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.LoaiGiayDomain;
import com.herokuapp.domain.khachhang.list.ListLoaiGiay;
import com.herokuapp.entity.Loaigiay;
import com.herokuapp.reponsitory.LoaiGiayReponsitory;

@Service
public class LoaiGiayServiceImpl implements LoaiGiayService {
	@Autowired
	public LoaiGiayReponsitory loaiGiayReponsitory;

	@Override
	public ListLoaiGiay getAllLoaiGiay() {
		ListLoaiGiay listLoaiGiay = new ListLoaiGiay();
		List<LoaiGiayDomain> giayDomains = new ArrayList<>();
		List<Loaigiay> loaigiays = loaiGiayReponsitory.findAll();
		loaigiays.forEach(loaigiay -> {
			LoaiGiayDomain loaiGiayDomain = new LoaiGiayDomain();
			loaiGiayDomain.converToDomain(loaigiay);
			giayDomains.add(loaiGiayDomain);
		});
		listLoaiGiay.setLoaiGiays(giayDomains);
		return listLoaiGiay;
	}
}
