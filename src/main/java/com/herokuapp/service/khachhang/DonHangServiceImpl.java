package com.herokuapp.service.khachhang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import com.herokuapp.domain.khachhang.GiayDonhangDomain;
import com.herokuapp.domain.khachhang.InfoGiayDonHang;
import com.herokuapp.domain.khachhang.MauSacDomain;
import com.herokuapp.domain.khachhang.SizeDomain;
import com.herokuapp.domain.khachhang.list.ListDonHang;
import com.herokuapp.domain.khachhang.list.ListDonHangVangLai;
import com.herokuapp.entity.Donhang;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.entity.GiayDonhangPK;
import com.herokuapp.entity.GiayMauSize;
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
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
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

	@Autowired
	public GiaySizeMauReponsitory giaySizeMauReponsitory;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addDonHang(AddDonHang addDonHang) {
		int tonggia = 0;
		int soluong = 0;
		int phanTramGiam = 0;
		Donhang donhang = new Donhang();
		List<GiayDonhang> giayDonhangs = new ArrayList<>();
		List<PhukienDonhang> phukienDonhangs = new ArrayList<>();
		Dskhuyenmai dskhuyenmai = null;
		String makh = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getManguoidung();

		String idNextDonHang = PrefixId.DONGHANG + String.valueOf(donHangSeqReponsitory.getIdNext());

		// create donhang

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
		// end create donhang

		// set makhuyenmai
		if (addDonHang.getMaKhuyenMai() != null && !StringUtils.isEmpty((addDonHang.getMaKhuyenMai()))) {
			dskhuyenmai = khuyenMaiReponsitory.findById(addDonHang.getMaKhuyenMai()).get();
			if (dskhuyenmai.getNgaykt().after(new Date()) && dskhuyenmai.getSoluong() > 0) {
				donhang.setDskhuyenmai(dskhuyenmai);
				phanTramGiam = dskhuyenmai.getGiatrigiam();
				dskhuyenmai.setSoluong(dskhuyenmai.getSoluong() - 1);
			}

		}

		// end set makhuyenmai

		// create giay_donghang

		for (InfoGiayDonHang item : addDonHang.getGiays()) {
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(item.getMagiay()).get();
			String idGiayMauSize = giaySizeMauReponsitory.getIdByIdGiayIdSizeIdMau(item.getMagiay(), item.getMasize(),
					item.getMamau());
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setidGiaySizeMau(idGiayMauSize);
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(item.getSoluong());
			int tongGiaGiay = giay.getGia() * item.getSoluong();
			giayDonhang.setTonggia(tongGiaGiay);
			tonggia += tongGiaGiay;
			soluong += item.getSoluong();
			giayDonhangs.add(giayDonhang);
		}

		// end create giay_donghang

		// create phukien_donghang

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

		// end create phukien_donghang

		BigDecimal tongGiaDonHang = caculateTongGiaDonHang(tonggia, phanTramGiam);
		donhang.setTonggia(tongGiaDonHang);
		donhang.setSoluong(soluong);

		if (dskhuyenmai != null) {
			khuyenMaiReponsitory.save(dskhuyenmai);
		}
		donHangReponsitory.save(donhang);
		giayDonHangReponsitory.saveAll(giayDonhangs);
		phukienDonhangReponsitory.saveAll(phukienDonhangs);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addDonHangKhachVangLai(AddDonHangVangLai addDonHangVangLai) {
		int tonggia = 0;
		int soluong = 0;
		int phanTramGiam = 0;
		Donhang donhang = new Donhang();
		Dskhuyenmai dskhuyenmai = null;
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
		khachvanglai.setSdt(addDonHangVangLai.getSdt());
		if (addDonHangVangLai.getGhichu() != null && !StringUtils.isEmpty(addDonHangVangLai.getGhichu())) {
			khachvanglai.setGhichu(addDonHangVangLai.getGhichu());
		}
		if (addDonHangVangLai.getEmail() != null && !StringUtils.isEmpty(addDonHangVangLai.getEmail())) {
			khachvanglai.setEmail(addDonHangVangLai.getEmail());
		}
		// End create new khachvanglai

		// Create new donhang

		Khachvanglai khachvanglaiSetDonHang = new Khachvanglai();
		khachvanglaiSetDonHang.setMakh(idNextKhachVanglai);
		donhang.setKhachvanglai(khachvanglaiSetDonHang);
		donhang.setNguoinhan(addDonHangVangLai.getHo() + " " + addDonHangVangLai.getTen());
		donhang.setDiachi(addDonHangVangLai.getDiachi());
		if (addDonHangVangLai.getGhichu() != null && !StringUtils.isEmpty(addDonHangVangLai.getGhichu())) {
			donhang.setGhichu(addDonHangVangLai.getGhichu());
		}

		if (addDonHangVangLai.getMakhuyenmai() != null && !StringUtils.isEmpty(addDonHangVangLai.getMakhuyenmai())) {
			dskhuyenmai = khuyenMaiReponsitory.findById(addDonHangVangLai.getMakhuyenmai()).get();
			if (dskhuyenmai.getNgaykt().after(new Date()) && dskhuyenmai.getSoluong() > 0) {
				donhang.setDskhuyenmai(dskhuyenmai);
				phanTramGiam = dskhuyenmai.getGiatrigiam();
				dskhuyenmai.setSoluong(dskhuyenmai.getSoluong() - 1);
			}
		}
		donhang.getPhuongthucthanhtoan().setMaloaithanhtoan(addDonHangVangLai.getMaloaithanhtoan());
		// End create new donhang

		// Create list giay_donghang
		for (InfoGiayDonHang item : addDonHangVangLai.getGiays()) {
			// key is magiay
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(item.getMagiay()).get();
			String idGiayMauSize = giaySizeMauReponsitory.getIdByIdGiayIdSizeIdMau(item.getMagiay(), item.getMasize(),
					item.getMamau());
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setidGiaySizeMau(idGiayMauSize);
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(item.getSoluong());
			int tongGiaGiay = giay.getGia() * item.getSoluong();
			giayDonhang.setTonggia(tongGiaGiay);
			tonggia += tongGiaGiay;
			soluong += item.getSoluong();
			giayDonhangs.add(giayDonhang);
		}
		// End create list giay_donghang

		// Create new list phukien_donhang
		for (Map.Entry<String, Integer> item : addDonHangVangLai.getPhukiens().entrySet()) {
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

		BigDecimal tongGiaDonHang = caculateTongGiaDonHang(tonggia, phanTramGiam);
		donhang.setTonggia(tongGiaDonHang);
		donhang.setSoluong(soluong);

		khachHangVangLaiReponsitory.save(khachvanglai);
		donHangReponsitory.save(donhang);
		giayDonHangReponsitory.saveAll(giayDonhangs);
		phukienDonhangReponsitory.saveAll(phukienDonhangs);

		if (dskhuyenmai != null) {
			khuyenMaiReponsitory.save(dskhuyenmai);
		}
		return idNextKhachVanglai;
	}

	private BigDecimal caculateTongGiaDonHang(int tonggiaSanPham, int phamtramgiam) {
		BigDecimal tonggia = BigDecimal.ZERO;
		BigDecimal tonggiaSanPhamDec = BigDecimal.valueOf(Double.valueOf(String.valueOf(tonggiaSanPham)));
		BigDecimal phamTramGiamDec = BigDecimal.valueOf(Double.valueOf(String.valueOf(phamtramgiam)));
		BigDecimal sotiengiam = (tonggiaSanPhamDec.divide(new BigDecimal("100"))).multiply(phamTramGiamDec);
		tonggia = tonggiaSanPhamDec.subtract(sotiengiam);
		return tonggia;
	}

	@Override
	public ListDonHang getLichSuDonHangByKhachHangId(String makh) {
		ListDonHang listDonHang = new ListDonHang();
		Khachhang khachhang = khachHangReponsitory.findById(makh).get();
		for (Donhang donhang : khachhang.getDonhangs()) {
			listDonHang.addDonHangDomain(convertToDonHangDomain(donhang));
		}
		return listDonHang;
	}

	@Override
	public ListDonHangVangLai getLichSuDonHangByKhachVangLaiId(String idKVL) {
		ListDonHangVangLai listDonHangVangLai = new ListDonHangVangLai();
		Khachvanglai khachvanglai = khachHangVangLaiReponsitory.findById(idKVL).get();
		DonHangDomain donHangDomain = convertToDonHangDomain(khachvanglai.getDonhangs().get(0));
		listDonHangVangLai.setDonHang(donHangDomain);
		return listDonHangVangLai;
	}

	private DonHangDomain convertToDonHangDomain(Donhang donhang) {
		DonHangDomain donHangDomain = new DonHangDomain();

		// only convert list phukien
		donHangDomain.converToDomain(donhang);

		for (GiayDonhang giayDonhang : donhang.getGiayDonhangs()) {
			GiayDonhangDomain giayDonhangDomain = new GiayDonhangDomain();
			giayDonhangDomain.converToDomain(giayDonhang);
			GiayMauSize giayMauSize = giaySizeMauReponsitory.getGiayMauSizeById(giayDonhang.getId().getidGiaySizeMau());

			Giay giay = giayMauSize.getGiay();
			giayDonhangDomain.setMagiay(giay.getMagiay());
			giayDonhangDomain.setTengiay(giay.getTengiay());

			SizeDomain sizeDomain = new SizeDomain();
			sizeDomain.converToDomain(giayMauSize.getSize());
			giayDonhangDomain.setSize(sizeDomain);

			MauSacDomain mauSacDomain = new MauSacDomain();
			mauSacDomain.converToDomain(giayMauSize.getMausac());
			giayDonhangDomain.setMauSac(mauSacDomain);
			donHangDomain.addGiayDonHang(giayDonhangDomain);
		}

		return donHangDomain;
	}

}
