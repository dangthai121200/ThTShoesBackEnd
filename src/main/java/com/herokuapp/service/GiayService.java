package com.herokuapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.GiayDomainDetails;
import com.herokuapp.domain.khachhang.GiayDomainGeneral;

public interface GiayService {
	
	public List<GiayDomainGeneral> getListLatest(int amount);
	public List<GiayDomainGeneral> getAllGiay();
	public GiayDomainDetails getGiayById(String idGiay);
}
