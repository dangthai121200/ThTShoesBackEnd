package com.herokuapp.service.khachhang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.herokuapp.domain.common.ItemDonhangEmail;
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
import com.herokuapp.entity.Mausac;
import com.herokuapp.entity.Phukien;
import com.herokuapp.entity.PhukienDonhang;
import com.herokuapp.entity.PhukienDonhangPK;
import com.herokuapp.entity.Phuongthucthanhtoan;
import com.herokuapp.entity.Size;
import com.herokuapp.enums.TinhTrang;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.DonHangSeqReponsitory;
import com.herokuapp.reponsitory.GiayDonHangReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.KhachHangReponsitory;
import com.herokuapp.reponsitory.KhachHangVangLaiReponsitory;
import com.herokuapp.reponsitory.KhachVangLaiSeqReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;
import com.herokuapp.reponsitory.MauSacReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.reponsitory.PhukienDonhangReponsitory;
import com.herokuapp.reponsitory.SizeReponsitory;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.service.common.EmailService;
import com.herokuapp.service.websocket.ThtShoesWSService;
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

	@Autowired
	public SizeReponsitory sizeReponsitory;

	@Autowired
	public MauSacReponsitory mauSacReponsitory;

	@Autowired
	public ThtShoesWSService thtShoesWSService;

	@Autowired
	public EmailService emailService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addDonHang(AddDonHang addDonHang) throws ThtShoesException {

		StringBuilder errorMessageGiay = checkListCoTheMuaGiay(addDonHang.getGiays());
		StringBuilder errorMessagePhuKien = checkListCoTheMuaPhuKien(addDonHang.getPhukiens());
		if (errorMessageGiay.length() > 0 || errorMessagePhuKien.length() > 0) {
			throw new ThtShoesException(errorMessageGiay.toString() + errorMessagePhuKien.toString());
		}

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

		thtShoesWSService.guiTongBaoCoDonHangMoi("ĐƠN HÀNG MỚI KHÁCH HÀNG",
				"Có đơn hàng mới!, mã khách hàng là " + idNextDonHang);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addDonHangKhachVangLai(AddDonHangVangLai addDonHangVangLai)
			throws ThtShoesException, MessagingException {

		StringBuilder errorMessageGiay = checkListCoTheMuaGiay(addDonHangVangLai.getGiays());
		StringBuilder errorMessagePhuKien = checkListCoTheMuaPhuKien(addDonHangVangLai.getPhukiens());
		if (errorMessageGiay.length() > 0 || errorMessagePhuKien.length() > 0) {
			throw new ThtShoesException(errorMessageGiay.toString() + errorMessagePhuKien.toString());
		}
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

		// list use for send mail when create donahng
		List<ItemDonhangEmail> itemDonhangEmails = new ArrayList<>();

		// Create list giay_donghang
		for (InfoGiayDonHang item : addDonHangVangLai.getGiays()) {
			// key is magiay
			GiayDonhang giayDonhang = new GiayDonhang();
			GiayDonhangPK giayDonhangPK = new GiayDonhangPK();
			Giay giay = giayReponsitory.findById(item.getMagiay()).get();
			String idGiayMauSize = giaySizeMauReponsitory.getIdByIdGiayIdSizeIdMau(item.getMagiay(), item.getMasize(),
					item.getMamau());
			boolean checkSoLuong = checkSoLuongCoTheMuaGiay(idGiayMauSize, item.getSoluong());
			giayDonhangPK.setMadon(idNextDonHang);
			giayDonhangPK.setidGiaySizeMau(idGiayMauSize);
			giayDonhang.setId(giayDonhangPK);
			giayDonhang.setSoluong(item.getSoluong());
			int tongGiaGiay = giay.getGia() * item.getSoluong();
			giayDonhang.setTonggia(tongGiaGiay);

			// add list ItemDonHangEmail
			ItemDonhangEmail itemDonhangEmail = new ItemDonhangEmail();
			itemDonhangEmail.setUrlAnh(giay.getUrlanh());
			itemDonhangEmail.setTen(giay.getTengiay());
			itemDonhangEmail.setGia(String.valueOf(giay.getGia()));
			GiayMauSize giayMauSize = giaySizeMauReponsitory.getGiayMauSizeById(idGiayMauSize);
			itemDonhangEmail.setSize(giayMauSize.getSize().getTensize());
			itemDonhangEmail.setMausac(giayMauSize.getMausac().getTenmau());
			itemDonhangEmail.setSoluong(String.valueOf(item.getSoluong()));
			itemDonhangEmails.add(itemDonhangEmail);

			// use for donhang
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

			ItemDonhangEmail itemDonhangEmail = new ItemDonhangEmail();
			itemDonhangEmail.setUrlAnh(phukien.getUrlAnh());
			itemDonhangEmail.setTen(phukien.getTenpk());
			itemDonhangEmail.setGia(String.valueOf(phukien.getGia()));
			itemDonhangEmail.setSoluong(String.valueOf(item.getValue()));
			itemDonhangEmails.add(itemDonhangEmail);

			// use for donhang
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

		// send thông báo for admin
		thtShoesWSService.guiTongBaoCoDonHangMoi("ĐƠN HÀNG MỚI KHÁCH VÃNG LAI",
				"Có đơn hàng mới!, mã khách hàng là " + idNextKhachVanglai);

		if (!StringUtils.isEmpty(addDonHangVangLai.getEmail())) {
			Map<String, Object> props = new HashMap<String, Object>();
			props.put("items", itemDonhangEmails);
			props.put("soluong", soluong);
			props.put("giabandau", tonggia);
			props.put("khuyenmai", phanTramGiam);
			props.put("giagiam", tongGiaDonHang);
			String html = emailService.convertToTemplateHtmlEmail(props, "taodonhang");
			emailService.sendMessageWithAttachment(addDonHangVangLai.getEmail(), "Thông Báo Tạo Đơn Hàng từ ThtShoes",
					html, null);
		}

		return idNextKhachVanglai;
	}

	private boolean checkSoLuongCoTheMuaGiay(String maGiaySizeMau, int soluongmua) {
		GiayMauSize giayMauSize = giaySizeMauReponsitory.getGiayMauSizeById(maGiaySizeMau);
		if (giayMauSize.getSoluong() >= soluongmua) {
			return true;
		}
		return false;
	}

	private StringBuilder checkListCoTheMuaGiay(Set<InfoGiayDonHang> giays) {
		StringBuilder errorMess = new StringBuilder();
		for (InfoGiayDonHang item : giays) {
			Giay giay = giayReponsitory.findById(item.getMagiay()).get();
			String idGiayMauSize = giaySizeMauReponsitory.getIdByIdGiayIdSizeIdMau(item.getMagiay(), item.getMasize(),
					item.getMamau());
			boolean checkSoLuong = checkSoLuongCoTheMuaGiay(idGiayMauSize, item.getSoluong());
			if (!checkSoLuong) {
				Size size = sizeReponsitory.findById(item.getMasize()).get();
				Mausac mausac = mauSacReponsitory.findById(item.getMamau()).get();
				String error = giay.getTengiay() + " - " + size.getTensize() + " - " + mausac.getTenmau() + "; ";
				errorMess.append(error);
			}
		}
		return errorMess;
	}

	private StringBuilder checkListCoTheMuaPhuKien(Map<String, Integer> phukiens) {
		StringBuilder errorMess = new StringBuilder();
		for (Map.Entry<String, Integer> item : phukiens.entrySet()) {
			Phukien phukien = phuKienReponsitory.findById(item.getKey()).get();
			boolean checkSoLuong = phukien.getSoluong() >= item.getValue() ? true : false;
			if (!checkSoLuong) {
				String mess = phukien.getTenpk() + " - " + phukien.getLoaiphukien().getTenloai() + "; ";
				errorMess.append(mess);
			}
		}
		return errorMess;
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

	@Override
	public void huyDonHangOfKhachHang(String mdh, String makh) throws ThtShoesException {

		Donhang donhang = donHangReponsitory.findByMadhAndMakh(mdh, makh);

		if (donhang == null) {
			throw new ThtShoesException("Đơn hàng không tồn tại");
		}
		if (donhang.getTinhtrang() != TinhTrang.CHODUYET) {
			throw new ThtShoesException("Đơn hàng không thể hủy");
		}

		donhang.setTinhtrang(TinhTrang.TUCHOI);
		donHangReponsitory.updateStatusForDonhang(mdh, TinhTrang.HUY.getValue());

	}

}
