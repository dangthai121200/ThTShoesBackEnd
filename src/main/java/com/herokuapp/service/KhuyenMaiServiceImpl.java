package com.herokuapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.KhuyenMaiDomain;
import com.herokuapp.domain.khachhang.ListKhuyenMai;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

	@Autowired
	public KhuyenMaiReponsitory khuyenMaiReponsitory;

	@Override
	public ListKhuyenMai getAllKhuyenMai() {
		List<Dskhuyenmai> dskhuyenmais = (List<Dskhuyenmai>) khuyenMaiReponsitory.findAll();
		List<KhuyenMaiDomain> khuyenMaiDomains = new ArrayList<>();
		ListKhuyenMai listKhuyenMai = new ListKhuyenMai();
		dskhuyenmais.forEach(khuyenmai -> {
			KhuyenMaiDomain khuyenMaiDomain = new KhuyenMaiDomain();
			khuyenMaiDomain.converToDomain(khuyenmai);
			khuyenMaiDomains.add(khuyenMaiDomain);
		});
		listKhuyenMai.setKhuyenMaiList(khuyenMaiDomains);
		return listKhuyenMai;
	}

	@Override
	public KhuyenMaiDomain getKhuyenMaiById(String idKm) {
		Dskhuyenmai dskhuyenmai = khuyenMaiReponsitory.findById(idKm).get();
		KhuyenMaiDomain khuyenMaiDomain = new KhuyenMaiDomain();
		khuyenMaiDomain.converToDomain(dskhuyenmai);
		return khuyenMaiDomain;
	}

}
