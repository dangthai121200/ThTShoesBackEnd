package com.herokuapp.service.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.DoanhThuAdmin;
import com.herokuapp.domain.admin.DonHangAdminDomain;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.GiayDonhangAdminDomain;
import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.NhanVienDonHangDomainAdmin;
import com.herokuapp.domain.admin.PhukienDonhangAdminDomain;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.list.ListDonHangAdmin;
import com.herokuapp.domain.thongke.admin.ByDate;
import com.herokuapp.entity.Donhang;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.entity.GiayMauSize;
import com.herokuapp.entity.Mausac;
import com.herokuapp.entity.NhanvienDonhang;
import com.herokuapp.entity.NhanvienDonhangPK;
import com.herokuapp.entity.Phukien;
import com.herokuapp.entity.PhukienDonhang;
import com.herokuapp.entity.Size;
import com.herokuapp.enums.HanhDong;
import com.herokuapp.enums.TinhTrang;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.GiayDonHangReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;
import com.herokuapp.reponsitory.MauSacReponsitory;
import com.herokuapp.reponsitory.NhanVienDonHangReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.reponsitory.SizeReponsitory;

@Service
public class DonHangAdminServiceImpl implements DonHangAdminService {

	@Autowired
	public DonHangReponsitory donHangReponsitory;

	@Autowired
	public NhanVienDonHangReponsitory nhanVienDonHangReponsitory;

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public PhuKienReponsitory phuKienReponsitory;

	@Autowired
	public KhuyenMaiReponsitory khuyenMaiReponsitory;

	@Autowired
	public GiaySizeMauReponsitory giaySizeMauReponsitory;

	@Autowired
	public SizeReponsitory sizeReponsitory;

	@Autowired
	public MauSacReponsitory mauSacReponsitory;

	@Autowired
	public GiayDonHangReponsitory giayDonHangReponsitory;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateStatusForDonhang(String madonghang, String manhanvien, TinhTrang tinhtrang)
			throws ThtShoesException {
		NhanvienDonhangPK nhanvienDonhangPK = new NhanvienDonhangPK();
		nhanvienDonhangPK.setMadon(madonghang);
		nhanvienDonhangPK.setManv(manhanvien);
		NhanvienDonhang nhanvienDonhang = new NhanvienDonhang();
		nhanvienDonhang.setId(nhanvienDonhangPK);

		List<GiayDonhang> giayDonhangs = null;
		List<GiayMauSize> giayMauSizesUpdateSoLuong = new ArrayList<>();

		List<PhukienDonhang> phukienDonhangs = null;
		List<Phukien> phukienDonhangsUpdateSoLuong = new ArrayList<>();

		Dskhuyenmai dskhuyenmai = null;

		HanhDong hanhDong = null;
		TinhTrang tinhTrangKeTiep = null;

		Donhang donhang = donHangReponsitory.findById(madonghang).get();

		if (donhang.getTinhtrang() == TinhTrang.CHODUYET && tinhtrang == TinhTrang.TUCHOI) {
			hanhDong = HanhDong.HUY;
			tinhTrangKeTiep = TinhTrang.TUCHOI;
			dskhuyenmai = donhang.getDskhuyenmai();
		} else if (donhang.getTinhtrang() == TinhTrang.CHODUYET) {
			StringBuilder errorMessGiay = checkListCoTheMuaGiay(donhang.getGiayDonhangs());
			StringBuilder errorMessPhuKien = checkListCoTheMuaPhuKien(donhang.getPhukienDonhangs());
			if (errorMessGiay.length() > 0 || errorMessPhuKien.length() > 0) {
				throw new ThtShoesException(errorMessGiay.toString() + errorMessPhuKien.toString());
			}
			hanhDong = HanhDong.DUYET;
			tinhTrangKeTiep = TinhTrang.DADUYET;
			giayDonhangs = donhang.getGiayDonhangs();
			phukienDonhangs = donhang.getPhukienDonhangs();

		} else if (donhang.getTinhtrang() == TinhTrang.DADUYET) {
			hanhDong = HanhDong.GIAO;
			tinhTrangKeTiep = TinhTrang.DAGIAO;
		} else {
			throw new ThtShoesException("Vui lòng truyền đúng tình trạng đơn hàng");
		}

		donhang.setTinhtrang(tinhTrangKeTiep);
		nhanvienDonhang.setHanhdong(hanhDong);

		if (giayDonhangs != null) {
			for (GiayDonhang giayDonhang : giayDonhangs) {
				GiayMauSize giayMauSize = giaySizeMauReponsitory
						.getGiayMauSizeById(giayDonhang.getId().getidGiaySizeMau());
				int soluong = giayMauSize.getSoluong() - giayDonhang.getSoluong();
				giayMauSize.setSoluong(soluong);
				giayMauSizesUpdateSoLuong.add(giayMauSize);
			}
		}

		if (phukienDonhangs != null) {
			for (PhukienDonhang phukienDonhang : phukienDonhangs) {
				Phukien phukien = phukienDonhang.getPhukien();
				int soluong = phukien.getSoluong() - phukienDonhang.getSoluong();
				phukien.setSoluong(soluong);
				phukienDonhangsUpdateSoLuong.add(phukien);
			}
		}

		if (dskhuyenmai != null) {
			dskhuyenmai.setSoluong(dskhuyenmai.getSoluong() + 1);
			khuyenMaiReponsitory.save(dskhuyenmai);
		}

		donHangReponsitory.save(donhang);
		nhanVienDonHangReponsitory.save(nhanvienDonhang);
		giaySizeMauReponsitory.saveAll(giayMauSizesUpdateSoLuong);
		phuKienReponsitory.saveAll(phukienDonhangsUpdateSoLuong);

	}

	private StringBuilder checkListCoTheMuaGiay(List<GiayDonhang> giayDonHang) {
		StringBuilder errorMess = new StringBuilder();
		for (GiayDonhang item : giayDonHang) {
			GiayMauSize giayMauSize = giaySizeMauReponsitory.getGiayMauSizeById(item.getId().getidGiaySizeMau());
			boolean checkSoLuong = giayMauSize.getSoluong() >= item.getSoluong() ? true : false;
			if (!checkSoLuong) {
				Giay giay = giayMauSize.getGiay();
				Size size = giayMauSize.getSize();
				Mausac mausac = giayMauSize.getMausac();
				String error = giay.getTengiay() + " - " + size.getTensize() + " - " + mausac.getTenmau() + "; ";
				errorMess.append(error);
			}
		}
		return errorMess;
	}

	private StringBuilder checkListCoTheMuaPhuKien(List<PhukienDonhang> phukiens) {
		StringBuilder errorMess = new StringBuilder();
		for (PhukienDonhang item : phukiens) {
			Phukien phukien = item.getPhukien();
			boolean checkSoLuong = phukien.getSoluong() >= item.getSoluong() ? true : false;
			if (!checkSoLuong) {
				String mess = phukien.getTenpk() + " - " + phukien.getLoaiphukien().getTenloai() + "; ";
				errorMess.append(mess);
			}
		}
		return errorMess;
	}

	@Override
	public ListDonHangAdmin getAllDonHang() {
		ListDonHangAdmin listDonHangAdmin = new ListDonHangAdmin();
		List<DonHangAdminDomain> donHangAdminDomains = new ArrayList<>();
		List<Donhang> donhangs = donHangReponsitory.findAll();
		donhangs.forEach(donhang -> {
			DonHangAdminDomain donHangAdminDomain = new DonHangAdminDomain();
			donHangAdminDomain.converToDomain(donhang);
			donHangAdminDomains.add(donHangAdminDomain);
		});

		listDonHangAdmin.setDonHangs(donHangAdminDomains);
		return listDonHangAdmin;
	}

	@Override
	public DonHangAdminDomain getDonHangById(String idDonhang) {

		DonHangAdminDomain donHangAdminDomain = new DonHangAdminDomain();

		Donhang donhang = donHangReponsitory.findById(idDonhang).get();
		donHangAdminDomain.converToDomain(donhang);

		List<GiayDonhangAdminDomain> giayDonhangs = new ArrayList<>();
		for (GiayDonhang giayDonhang : donhang.getGiayDonhangs()) {
			GiayDonhangAdminDomain giayDonhangAdminDomain = new GiayDonhangAdminDomain();
			GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
			SizeAdminDomain sizeAdminDomain = new SizeAdminDomain();
			MauSacAdminDomain mauSacAdminDomain = new MauSacAdminDomain();

			giayDonhangAdminDomain.converToDomain(giayDonhang);

			GiayMauSize giayMauSize = giaySizeMauReponsitory.getGiayMauSizeById(giayDonhang.getId().getidGiaySizeMau());

			Giay giay = giayMauSize.getGiay();
			giayAdminDomain.converToDomain(giay);

			Size size = giayMauSize.getSize();
			sizeAdminDomain.converToDomain(size);

			Mausac mausac = giayMauSize.getMausac();
			mauSacAdminDomain.converToDomain(mausac);

			giayDonhangAdminDomain.setGiay(giayAdminDomain);
			giayDonhangAdminDomain.setSize(sizeAdminDomain);
			giayDonhangAdminDomain.setMausac(mauSacAdminDomain);

			giayDonhangs.add(giayDonhangAdminDomain);
		}
		donHangAdminDomain.setGiayDonhangs(giayDonhangs);

		List<PhukienDonhangAdminDomain> phukienDonhangs = new ArrayList<>();
		if (donhang.getPhukienDonhangs() != null) {
			donhang.getPhukienDonhangs().forEach(phukienDonhang -> {
				PhukienDonhangAdminDomain phukienDonhangDomain = new PhukienDonhangAdminDomain();
				phukienDonhangDomain.converToDomain(phukienDonhang);
				phukienDonhangs.add(phukienDonhangDomain);
			});
		}
		donHangAdminDomain.setPhukienDonhangs(phukienDonhangs);

		List<NhanVienDonHangDomainAdmin> actions = new ArrayList<>();
		List<NhanvienDonhang> nhanvienDonhangs = nhanVienDonHangReponsitory.getAllNhanVienDonhangByMaDon(idDonhang);
		for (NhanvienDonhang nhanvienDonhang : nhanvienDonhangs) {
			NhanVienDonHangDomainAdmin nhanVienDonHangDomainAdmin = new NhanVienDonHangDomainAdmin();
			nhanVienDonHangDomainAdmin.converToDomain(nhanvienDonhang);
			actions.add(nhanVienDonHangDomainAdmin);
		}
		donHangAdminDomain.setActions(actions);

		return donHangAdminDomain;
	}

	@Override
	public ListDonHangAdmin getDonHangByDate(ByDate byDate) {
		ListDonHangAdmin listDonHangAdmin = new ListDonHangAdmin();
		List<DonHangAdminDomain> donHangAdminDomains = new ArrayList<>();
		List<Donhang> donhangs = donHangReponsitory.findByngaytaoBetween(byDate.getNgayBd(), byDate.getNgayKt());
		donhangs.forEach(donhang -> {
			DonHangAdminDomain donHangAdminDomain = new DonHangAdminDomain();
			donHangAdminDomain.converToDomain(donhang);
			donHangAdminDomains.add(donHangAdminDomain);
		});

		listDonHangAdmin.setDonHangs(donHangAdminDomains);
		return listDonHangAdmin;
	}

	@Override
	public DoanhThuAdmin thongKeDoanhThuByDate(ByDate byDate) {
		DoanhThuAdmin doanhThuAdmin = new DoanhThuAdmin();
		BigDecimal doanhthu = donHangReponsitory.thongKeDoanhThuByDate(byDate.getNgayBd(), byDate.getNgayKt());
		doanhThuAdmin.setTongdoanhthu(doanhthu);
		return doanhThuAdmin;
	}

	@Override
	public BigDecimal thongKeDoanhThuAll() {
		return donHangReponsitory.thongKeDoanhThuAll();
	}

	@Override
	public int countDongHangByStatus(TinhTrang tinhTrang) {
		return donHangReponsitory.countDongHangByStatus(tinhTrang.getValue());
	}
}
