package com.herokuapp.service.khachhang;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;
import com.herokuapp.domain.khachhang.PhuKienDomain;
import com.herokuapp.entity.Binhluan;
import com.herokuapp.entity.Phukien;
import com.herokuapp.reponsitory.BinhLuanReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;

@Service
public class PhukienServiceImpl implements PhukienService {

	@Autowired
	public PhuKienReponsitory phuKienReponsitory;

	@Autowired
	public BinhLuanReponsitory binhLuanReponsitory;

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

	@Override
	public List<PhuKienDomain> getAllPhukien() {
		List<Phukien> phukiens = (List<Phukien>) phuKienReponsitory.findAll();
		List<PhuKienDomain> phuKienDomains = new ArrayList<>();
		phukiens.forEach(phukien -> {
			PhuKienDomain phuKienDomain = new PhuKienDomain();
			phuKienDomain.converToDomain(phukien);
			phuKienDomains.add(phuKienDomain);
		});
		return phuKienDomains;
	}

	@Override
	public PhuKienDomain getPhukienById(String idPk) {
		Phukien phukien = phuKienReponsitory.findById(idPk).get();
		PhuKienDomain phuKienDomain = new PhuKienDomain();
		phuKienDomain.converToDomain(phukien);

		List<Binhluan> binhluans = binhLuanReponsitory.getAllBinhLuanByIdPhuKien(idPk);
		List<BinhLuanKhachHangDomain> binhLuanKhachHangDomains = new ArrayList<>();

		for (Binhluan binhluan : binhluans) {
			BinhLuanKhachHangDomain binhLuanKhachHangDomain = new BinhLuanKhachHangDomain();
			binhLuanKhachHangDomain.converToDomain(binhluan);
			binhLuanKhachHangDomains.add(binhLuanKhachHangDomain);
		}
		phuKienDomain.setBinhluans(binhLuanKhachHangDomains);

		return phuKienDomain;
	}

}
