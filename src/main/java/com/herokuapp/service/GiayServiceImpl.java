package com.herokuapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.GiayDomain;
import com.herokuapp.entity.Giay;
import com.herokuapp.reponsitory.GiayReponsitory;

@Service
public class GiayServiceImpl implements GiayService {

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public LoaigiayHangDanhmucService loaigiayHangDanhmucService;

	@Override
	public List<GiayDomain> getListLatest(int amount) {
		List<Giay> listGiayEntity = giayReponsitory.getListLatest(amount);
		List<GiayDomain> giayDomains = new ArrayList<>();
		if (listGiayEntity.size() > 0) {
			listGiayEntity.forEach(giay -> {
				GiayDomain giayDomain = new GiayDomain();
				giayDomain.converToDomain(giay);
				giayDomains.add(giayDomain);
			});
		}
		return giayDomains;
	}

	@Override
	public List<GiayDomain> getAllGiay() {
		List<Giay> giayEntites = (List<Giay>) giayReponsitory.findAll();
		List<GiayDomain> giayDomains = new ArrayList<>();
		giayEntites.forEach(giay -> {
			GiayDomain giayDomain = new GiayDomain();
			giayDomain.converToDomain(giay);
			giayDomain.setLoaigiayHangDanhmuc(
					loaigiayHangDanhmucService.findByMaLgiayHang(giay.getMaLgiayHang()));
			giayDomains.add(giayDomain);
		});

		return giayDomains;
	}

	@Override
	public GiayDomain getGiayById(String idGiay) {
		Giay giay = giayReponsitory.findById(idGiay).get();
		GiayDomain giayDomainDetails = new GiayDomain();
		giayDomainDetails.converToDomain(giay);
		return giayDomainDetails;
	}

}
