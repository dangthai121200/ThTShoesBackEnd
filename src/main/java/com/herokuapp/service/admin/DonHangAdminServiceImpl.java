package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.herokuapp.lockdata.Lock;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;
import com.herokuapp.reponsitory.NhanVienDonHangReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.util.Table;

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
	public LockService lockService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateStatusForDonhang(String madonghang, String manhanvien, TinhTrang tinhtrang)
			throws ThtShoesException {
		String username = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUsername();
		Lock checkLock = lockService.checkLock(Table.DON_HANG, madonghang, username);
		if (checkLock != null) {
			throw new ThtShoesException("Data lock by " + checkLock.getUsername() + " at " + checkLock.getTimeOut());
		}

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
	public DonHangAdminDomain getDonHangById(String idDonhang) throws Exception {

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
		String username = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUsername();

		Lock checkLock = lockService.checkLock(Table.DON_HANG, idDonhang, username);
		if (checkLock != null) {
			donHangAdminDomain.setLock(true);
			donHangAdminDomain.setMessLock("Data lock by " + checkLock.getUsername() + " at " + checkLock.getTimeOut());
		} else {
			lockService.lock(Table.DON_HANG, new Lock(idDonhang, username, new Date()));
		}
		return donHangAdminDomain;
	}

}
