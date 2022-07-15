package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.DonHangAdminDomain;
import com.herokuapp.domain.admin.list.ListDonHangAdmin;
import com.herokuapp.entity.Donhang;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.entity.NhanvienDonhang;
import com.herokuapp.entity.NhanvienDonhangPK;
import com.herokuapp.entity.Phukien;
import com.herokuapp.entity.PhukienDonhang;
import com.herokuapp.enums.HanhDong;
import com.herokuapp.enums.TinhTrang;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
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
		List<Giay> giayDonhangsUpdateSoLuong = new ArrayList<>();

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

//		if (giayDonhangs != null) {
//			for (GiayDonhang giayDonhang : giayDonhangs) {
//				Giay giay = giayDonhang.getGiay();
//				int soluong = giay.getSoluong() - giayDonhang.getSoluong();
//				giay.setSoluong(soluong);
//				giayDonhangsUpdateSoLuong.add(giay);
//			}
//		}

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
		giayReponsitory.saveAll(giayDonhangsUpdateSoLuong);
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
		Donhang donhang = donHangReponsitory.findById(idDonhang).get();
		donHangAdminDomain.converToDomain(donhang);
		return donHangAdminDomain;
	}

}
