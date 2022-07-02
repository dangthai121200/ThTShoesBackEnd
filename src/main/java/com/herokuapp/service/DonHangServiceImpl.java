package com.herokuapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.DonHangDomain;
import com.herokuapp.domain.khachhang.list.ListDonHang;
import com.herokuapp.entity.Donhang;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.entity.GiayDonhangPK;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.entity.Khachvanglai;
import com.herokuapp.entity.Phukien;
import com.herokuapp.entity.PhukienDonhang;
import com.herokuapp.entity.PhukienDonhangPK;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.DonHangSeqReponsitory;
import com.herokuapp.reponsitory.GiayDonHangReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.KhachHangReponsitory;
import com.herokuapp.reponsitory.KhachHangVangLaiReponsitory;
import com.herokuapp.reponsitory.KhachVangLaiSeqReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.reponsitory.PhukienDonhangReponsitory;
import com.herokuapp.util.PrefixId;

@Service
public class DonHangServiceImpl implements DonHangService {

	@Autowired
	public DonHangReponsitory donHangReponsitory;

	@Autowired
	public DonHangSeqReponsitory donHangSeqReponsitory;

	@Autowired
	public GiayDonHangReponsitory giayDonHangReponsitory;

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public PhuKienReponsitory phuKienReponsitory;

	@Autowired
	public PhukienDonhangReponsitory phukienDonhangReponsitory;

	@Autowired
	public KhachHangReponsitory khachHangReponsitory;

	@Autowired
	public KhachHangVangLaiReponsitory khachHangVangLaiReponsitory;

	@Autowired
	public KhachVangLaiSeqReponsitory khachVangLaiSeqReponsitory;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addDonHang(AddDonHang addDonHang) {
		Donhang donhang = new Donhang();
		List<GiayDonhang> giayDonhangs = new ArrayList<>();
		List<PhukienDonhang> phukienDonhangs = new ArrayList<>();

		String idNextDonHang = PrefixId.DONGHANG + String.valueOf(donHangSeqReponsitory.getIdNext());

		donhang.getKhachhang().setMakh(addDonHang.getMaKhachHang());
		donhang.setNguoinhan(addDonHang.getNguoinhan());
		if (addDonHang.getMaKhuyenMai() != null) {
			donhang.getDskhuyenmai().setMakm(addDonHang.getMaKhuyenMai());
		}

		donHangReponsitory.save(donhang);

		addDonHang.getGiays().forEach((key, value) -> {
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(key).get();
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setMagiay(key);
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(value);
			giayDonhang.setTonggia(giay.getGia() * value);
			giayDonhangs.add(giayDonhang);
		});
		giayDonHangReponsitory.saveAll(giayDonhangs);

		addDonHang.getPhukiens().forEach((key, value) -> {
			PhukienDonhang phukienDonhang = new PhukienDonhang();
			PhukienDonhangPK phukienDonhangPK = new PhukienDonhangPK();
			Phukien phukien = phuKienReponsitory.findById(key).get();
			phukienDonhangPK.setMadon(idNextDonHang);
			phukienDonhangPK.setMapk(key);
			phukienDonhang.setId(phukienDonhangPK);
			phukienDonhang.setSoluong(value);
			phukienDonhang.setTonggia(value * phukien.getGia());
			phukienDonhangs.add(phukienDonhang);
		});
		phukienDonhangReponsitory.saveAll(phukienDonhangs);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ListDonHang getLichSuDonHangByKhachHangId(String makh) {
		ListDonHang listDonHang = new ListDonHang();
		List<DonHangDomain> donHangDomains = new ArrayList<>();
		Khachhang khachhang = khachHangReponsitory.findById(makh).get();
		List<Donhang> donhangs = khachhang.getDonhangs();
		donhangs.forEach(donhang -> {
			DonHangDomain donHangDomain = new DonHangDomain();
			donHangDomain.converToDomain(donhang);
			donHangDomains.add(donHangDomain);
		});
		listDonHang.setDonHangs(donHangDomains);
		return listDonHang;
	}

	@Override
	public void addDonHangKhachVangLai(AddDonHangVangLai addDonHangVangLai) {
		Donhang donhang = new Donhang();
		List<GiayDonhang> giayDonhangs = new ArrayList<>();
		List<PhukienDonhang> phukienDonhangs = new ArrayList<>();

		String idNextDonHang = PrefixId.DONGHANG + String.valueOf(donHangSeqReponsitory.getIdNext());
		String idNextKhachVanglai = PrefixId.KHACH_VANG_LAI + String.valueOf(khachVangLaiSeqReponsitory.getIdNext());

		Khachvanglai khachvanglai = new Khachvanglai();
		khachvanglai.setHo(addDonHangVangLai.getHo());
		khachvanglai.setTen(addDonHangVangLai.getTen());
		khachvanglai.setDiachi(addDonHangVangLai.getDiachi());
		khachvanglai.setSdt(Integer.valueOf(addDonHangVangLai.getSdt()));
		if (addDonHangVangLai.getEmail() != null) {
			khachvanglai.setEmail(addDonHangVangLai.getEmail());
		}
		if (addDonHangVangLai.getGhichu() != null) {
			khachvanglai.setGhichu(addDonHangVangLai.getGhichu());
		}
		khachHangVangLaiReponsitory.save(khachvanglai);

		donhang.getKhachvanglai().setMakh(idNextKhachVanglai);
		donhang.setNguoinhan(addDonHangVangLai.getHo() + " " + addDonHangVangLai.getTen());
		if (addDonHangVangLai.getMakhuyenmai() != null) {
			donhang.getDskhuyenmai().setMakm(addDonHangVangLai.getMakhuyenmai());
		}
		donHangReponsitory.save(donhang);

		addDonHangVangLai.getGiays().forEach((key, value) -> {
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(key).get();
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setMagiay(key);
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(value);
			giayDonhang.setTonggia(giay.getGia() * value);
			giayDonhangs.add(giayDonhang);
		});
		giayDonHangReponsitory.saveAll(giayDonhangs);

		addDonHangVangLai.getPhukiens().forEach((key, value) -> {
			PhukienDonhang phukienDonhang = new PhukienDonhang();
			PhukienDonhangPK phukienDonhangPK = new PhukienDonhangPK();
			Phukien phukien = phuKienReponsitory.findById(key).get();
			phukienDonhangPK.setMadon(idNextDonHang);
			phukienDonhangPK.setMapk(key);
			phukienDonhang.setId(phukienDonhangPK);
			phukienDonhang.setSoluong(value);
			phukienDonhang.setTonggia(value * phukien.getGia());
			phukienDonhangs.add(phukienDonhang);
		});
		phukienDonhangReponsitory.saveAll(phukienDonhangs);

	}

}
