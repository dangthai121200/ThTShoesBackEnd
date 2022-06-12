package com.herokuapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.PhuKienDomain;
import com.herokuapp.entity.Phukien;
import com.herokuapp.reponsitory.PhuKienReponsitory;

@Service
public class PhukienServiceImpl implements PhukienService {

	@Autowired
	public PhuKienReponsitory phuKienReponsitory;

	@Override
	public List<PhuKienDomain> getListLatest(int amount) {

		List<Phukien> phukiens = phuKienReponsitory.getListLatest(amount);
		List<PhuKienDomain> phuKienDomains = new ArrayList<>();
		phukiens.forEach(phukien -> {
			PhuKienDomain phuKienDomain = new PhuKienDomain();
			phuKienDomain.converToDomain(phukien);
			phuKienDomains.add(phuKienDomain);
		});

		return phuKienDomains;
	}

}
