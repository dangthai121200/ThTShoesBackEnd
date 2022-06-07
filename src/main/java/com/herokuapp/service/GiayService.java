package com.herokuapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.GiayDomain;

public interface GiayService {
	
	public List<GiayDomain> getListLatest(int amount);
}
