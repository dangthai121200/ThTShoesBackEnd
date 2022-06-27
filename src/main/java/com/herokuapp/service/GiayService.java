package com.herokuapp.service;

import java.util.List;

import com.herokuapp.domain.khachhang.GiayDomain;

public interface GiayService {

	public List<GiayDomain> getListLatest(int amount);

	public List<GiayDomain> getAllGiay();

	public GiayDomain getGiayById(String idGiay);
}
