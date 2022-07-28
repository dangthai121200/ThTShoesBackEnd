package com.herokuapp.service.khachhang;

import java.util.List;

import com.herokuapp.domain.khachhang.GiayDomain;

public interface GiayService {

	public List<GiayDomain> getAllGiay();

	public List<GiayDomain> getListLatest(int amount);

	public List<GiayDomain> getListBestSell(int amount);

	public GiayDomain getGiayById(String idGiay);
}
