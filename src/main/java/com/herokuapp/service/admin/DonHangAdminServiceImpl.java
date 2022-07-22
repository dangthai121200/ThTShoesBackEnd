package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.DonHangAdminDomain;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.GiayDonhangAdminDomain;
import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.PhukienDonhangAdminDomain;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.list.ListDonHangAdmin;
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
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;
import com.herokuapp.reponsitory.NhanVienDonHangReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;

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
		List<GiayDonhangAdminDomain> giayDonhangs = new ArrayList<>();
		List<PhukienDonhangAdminDomain> phukienDonhangs = new ArrayList<>();
		Donhang donhang = donHangReponsitory.findById(idDonhang).get();
		donHangAdminDomain.converToDomain(donhang);
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
		if (donhang.getPhukienDonhangs() != null) {
			donhang.getPhukienDonhangs().forEach(phukienDonhang -> {
				PhukienDonhangAdminDomain phukienDonhangDomain = new PhukienDonhangAdminDomain();
				phukienDonhangDomain.converToDomain(phukienDonhang);
				phukienDonhangs.add(phukienDonhangDomain);
			});
		}
		donHangAdminDomain.setPhukienDonhangs(phukienDonhangs);
		return donHangAdminDomain;
	}

}
