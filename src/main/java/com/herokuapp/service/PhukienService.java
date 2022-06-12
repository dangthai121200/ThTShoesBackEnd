package com.herokuapp.service;

import java.util.List;

import com.herokuapp.domain.khachhang.PhuKienDomain;

public interface PhukienService {

	public List<PhuKienDomain> getListLatest(int amount);
}
