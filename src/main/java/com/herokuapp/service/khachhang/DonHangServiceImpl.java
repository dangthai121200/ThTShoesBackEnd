package com.herokuapp.service.khachhang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.herokuapp.domain.khachhang.AddDonHang;
import com.herokuapp.domain.khachhang.AddDonHangVangLai;
import com.herokuapp.domain.khachhang.DonHangDomain;
import com.herokuapp.domain.khachhang.list.ListDonHang;
import com.herokuapp.entity.Donhang;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.entity.GiayDonhangPK;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.entity.Khachvanglai;
import com.herokuapp.entity.Phukien;
import com.herokuapp.entity.PhukienDonhang;
import com.herokuapp.entity.PhukienDonhangPK;
import com.herokuapp.entity.Phuongthucthanhtoan;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.DonHangSeqReponsitory;
import com.herokuapp.reponsitory.GiayDonHangReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.KhachHangReponsitory;
import com.herokuapp.reponsitory.KhachHangVangLaiReponsitory;
import com.herokuapp.reponsitory.KhachVangLaiSeqReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.reponsitory.PhukienDonhangReponsitory;
import com.herokuapp.security.UserDetailsConfigure;
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

	@Autowired
	public KhuyenMaiReponsitory khuyenMaiReponsitory;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addDonHang(AddDonHang addDonHang) {
		int tonggia = 0;
		int soluong = 0;
		int phanTramGiam = 0;
		Donhang donhang = new Donhang();
		List<GiayDonhang> giayDonhangs = new ArrayList<>();
		List<PhukienDonhang> phukienDonhangs = new ArrayList<>();
		String makh = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getManguoidung();

		String idNextDonHang = PrefixId.DONGHANG + String.valueOf(donHangSeqReponsitory.getIdNext());

		donhang.setNguoinhan(addDonHang.getNguoinhan());
		donhang.setDiachi(addDonHang.getDiachi());

		if (addDonHang.getGhichu() != null && !StringUtils.isEmpty((addDonHang.getGhichu()))) {
			donhang.setGhichu(addDonHang.getGhichu());
		}

		Phuongthucthanhtoan phuongthucthanhtoan = new Phuongthucthanhtoan();
		phuongthucthanhtoan.setMaloaithanhtoan(addDonHang.getMaloaithanhtoan());
		donhang.setPhuongthucthanhtoan(phuongthucthanhtoan);

		Khachhang khachhang = new Khachhang();
		khachhang.setMakh(makh);
		donhang.setKhachhang(khachhang);

		if (addDonHang.getMaKhuyenMai() != null && !StringUtils.isEmpty((addDonHang.getMaKhuyenMai()))) {
			Dskhuyenmai dskhuyenmai = new Dskhuyenmai();
			dskhuyenmai.setMakm(addDonHang.getMaKhuyenMai());
			donhang.setDskhuyenmai(dskhuyenmai);
			phanTramGiam = khuyenMaiReponsitory.findById(addDonHang.getMaKhuyenMai()).get().getGiatrigiam();
		}

		for (Map.Entry<String, Integer> item : addDonHang.getGiays().entrySet()) {
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(item.getKey()).get();
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setMagiay(item.getKey());
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(item.getValue());
			int tongGiaGiay = giay.getGia() * item.getValue();
			giayDonhang.setTonggia(tongGiaGiay);
			tonggia += tongGiaGiay;
			soluong += item.getValue();
			giayDonhangs.add(giayDonhang);
		}

		for (Map.Entry<String, Integer> item : addDonHang.getPhukiens().entrySet()) {
			PhukienDonhang phukienDonhang = new PhukienDonhang();
			PhukienDonhangPK phukienDonhangPK = new PhukienDonhangPK();
			Phukien phukien = phuKienReponsitory.findById(item.getKey()).get();
			phukienDonhangPK.setMadon(idNextDonHang);
			phukienDonhangPK.setMapk(item.getKey());
			phukienDonhang.setId(phukienDonhangPK);
			phukienDonhang.setSoluong(item.getValue());
			int tongGiaPhuKien = item.getValue() * phukien.getGia();
			phukienDonhang.setTonggia(tongGiaPhuKien);
			tonggia += tongGiaPhuKien;
			soluong += item.getValue();
			phukienDonhangs.add(phukienDonhang);
		}

		int soTienGiam = (tonggia / 100) * phanTramGiam;
		donhang.setTonggia(tonggia - soTienGiam);
		donhang.setSoluong(soluong);

		donHangReponsitory.save(donhang);
		giayDonHangReponsitory.saveAll(giayDonhangs);
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
		int tonggia = 0;
		int soluong = 0;
		int phanTramGiam = 0;
		Donhang donhang = new Donhang();
		List<GiayDonhang> giayDonhangs = new ArrayList<>();
		List<PhukienDonhang> phukienDonhangs = new ArrayList<>();

		// Get id next
		String idNextDonHang = PrefixId.DONGHANG + String.valueOf(donHangSeqReponsitory.getIdNext());
		String idNextKhachVanglai = PrefixId.KHACH_VANG_LAI + String.valueOf(khachVangLaiSeqReponsitory.getIdNext());

		// Create new khachvanglai
		Khachvanglai khachvanglai = new Khachvanglai();
		khachvanglai.setHo(addDonHangVangLai.getHo());
		khachvanglai.setTen(addDonHangVangLai.getTen());
		khachvanglai.setDiachi(addDonHangVangLai.getDiachi());
		khachvanglai.setSdt(Integer.valueOf(addDonHangVangLai.getSdt()));
		if (addDonHangVangLai.getGhichu() != null && !StringUtils.isEmpty(addDonHangVangLai.getGhichu())) {
			khachvanglai.setGhichu(addDonHangVangLai.getGhichu());
		}
		if (addDonHangVangLai.getEmail() != null && !StringUtils.isEmpty(addDonHangVangLai.getEmail())) {
			khachvanglai.setEmail(addDonHangVangLai.getEmail());
		}
		// End create new khachvanglai

		// Create new donhang
		donhang.getKhachvanglai().setMakh(idNextKhachVanglai);
		donhang.setNguoinhan(addDonHangVangLai.getHo() + " " + addDonHangVangLai.getTen());
		donhang.setDiachi(addDonHangVangLai.getDiachi());
		if (addDonHangVangLai.getGhichu() != null && !StringUtils.isEmpty(addDonHangVangLai.getGhichu())) {
			donhang.setGhichu(addDonHangVangLai.getGhichu());
		}	
		if (addDonHangVangLai.getMakhuyenmai() != null && !StringUtils.isEmpty(addDonHangVangLai.getMakhuyenmai())) {
			donhang.getDskhuyenmai().setMakm(addDonHangVangLai.getMakhuyenmai());
			phanTramGiam = khuyenMaiReponsitory.findById(addDonHangVangLai.getMakhuyenmai()).get().getGiatrigiam();
		}
		donhang.getPhuongthucthanhtoan().setMaloaithanhtoan(addDonHangVangLai.getMaloaithanhtoan());
		//End create new donhang

		// Create list giay_donghang
		for(Map.Entry<String, Integer> item : addDonHangVangLai.getGiays().entrySet()) {
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(item.getKey()).get();
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setMagiay(item.getKey());
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(item.getValue());
			int tongGiaGiay = giay.getGia() * item.getValue();
			giayDonhang.setTonggia(tongGiaGiay);
			tonggia += tongGiaGiay;
			soluong += item.getValue();
			giayDonhangs.add(giayDonhang);
		}
		// End create list giay_donghang

		// Create new list phukien_donhang
		for(Map.Entry<String, Integer> item : addDonHangVangLai.getPhukiens().entrySet()) {
			PhukienDonhang phukienDonhang = new PhukienDonhang();
			PhukienDonhangPK phukienDonhangPK = new PhukienDonhangPK();
			Phukien phukien = phuKienReponsitory.findById(item.getKey()).get();
			phukienDonhangPK.setMadon(idNextDonHang);
			phukienDonhangPK.setMapk(item.getKey());
			phukienDonhang.setId(phukienDonhangPK);
			phukienDonhang.setSoluong(item.getValue());
			int tongGiaPhuKien = item.getValue() * phukien.getGia();
			phukienDonhang.setTonggia(tongGiaPhuKien);
			tonggia += tongGiaPhuKien;
			soluong += item.getValue();
			phukienDonhangs.add(phukienDonhang);
		}
		// End create new list phukien_donhang
		
		int soTienGiam = (tonggia / 100) * phanTramGiam;
		donhang.setTonggia(tonggia - soTienGiam);
		donhang.setSoluong(soluong);
		
		khachHangVangLaiReponsitory.save(khachvanglai);
		donHangReponsitory.save(donhang);
		giayDonHangReponsitory.saveAll(giayDonhangs);
		phukienDonhangReponsitory.saveAll(phukienDonhangs);

	}

}
