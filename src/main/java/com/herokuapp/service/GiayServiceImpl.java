package com.herokuapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.GiayDomainDetails;
import com.herokuapp.domain.khachhang.GiayDomainGeneral;
import com.herokuapp.entity.Giay;
import com.herokuapp.reponsitory.GiayReponsitory;

@Service
public class GiayServiceImpl implements GiayService {

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Override
	public List<GiayDomainGeneral> getListLatest(int amount) {
		List<Giay> listGiayEntity = giayReponsitory.getListLatest(amount);
		List<GiayDomainGeneral> giayDomains = new ArrayList<>();
		if (listGiayEntity.size() > 0) {
			listGiayEntity.forEach(giay -> {
				GiayDomainGeneral giayDomain = new GiayDomainGeneral();
				giayDomain.converToDomain(giay);
				giayDomains.add(giayDomain);
			});
		}
		return giayDomains;
	}

	@Override
	public List<GiayDomainGeneral> getAllGiay() {
		List<Giay> giayEntites = (List<Giay>) giayReponsitory.findAll();
		List<GiayDomainGeneral> giayDomains = new ArrayList<>();
		giayEntites.forEach(giay -> {
			GiayDomainGeneral giayDomain = new GiayDomainGeneral();
			giayDomain.converToDomain(giay);
			giayDomains.add(giayDomain);
		});

		return giayDomains;
	}

	@Override
	public GiayDomainDetails getGiayById(String idGiay) {
		Giay giay = giayReponsitory.findById(idGiay).get();
		GiayDomainDetails giayDomainDetails = new GiayDomainDetails();
		giayDomainDetails.converToDomain(giay);
		return giayDomainDetails;
	}

}
