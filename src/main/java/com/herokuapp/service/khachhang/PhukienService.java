package com.herokuapp.service.khachhang;

import java.util.List;

import com.herokuapp.domain.khachhang.PhuKienDomain;

public interface PhukienService {

	public List<PhuKienDomain> getAllPhukien();
	public List<PhuKienDomain> getListLatest(int amount);
	public PhuKienDomain getPhukienById(String idPk);
}
