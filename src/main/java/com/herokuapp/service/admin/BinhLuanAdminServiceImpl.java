package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.BinhLuanAdminDomain;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.KhachHangAdminDomain;
import com.herokuapp.domain.admin.NhanVienAdminDomain;
import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.TraLoiBinhLuanAdminDomain;
import com.herokuapp.domain.admin.list.ListBinhLuanAdmin;
import com.herokuapp.entity.Binhluan;
import com.herokuapp.entity.Nhanvien;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.BinhLuanReponsitory;

@Service
public class BinhLuanAdminServiceImpl implements BinhLuanAdminService {

	@Autowired
	public BinhLuanReponsitory binhLuanReponsitory;

	@Override
	public ListBinhLuanAdmin getAllBinhLuan() {
		ListBinhLuanAdmin listBinhLuanAdmin = new ListBinhLuanAdmin();
		List<BinhLuanAdminDomain> binhLuanAdminDomains = new ArrayList<>();
		List<Binhluan> binhluans = binhLuanReponsitory.findBykhachhangIsNotNull();
		for (Binhluan binhluan : binhluans) {

			BinhLuanAdminDomain binhLuanAdminDomain = new BinhLuanAdminDomain();
			binhLuanAdminDomain.converToDomain(binhluan);

			if (binhluan.getKhachhang() != null) {
				KhachHangAdminDomain khachHangAdminDomain = new KhachHangAdminDomain();
				khachHangAdminDomain.converToDomain(binhluan.getKhachhang());
				binhLuanAdminDomain.setKhachhang(khachHangAdminDomain);
			}
			if (binhluan.getPhukien() != null) {
				PhuKienAdminDomain phuKienAdminDomain = new PhuKienAdminDomain();
				phuKienAdminDomain.converToDomain(binhluan.getPhukien());
				binhLuanAdminDomain.setPhukien(phuKienAdminDomain);
			}

			if (binhluan.getGiay() != null) {
				GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
				giayAdminDomain.converToDomain(binhluan.getGiay());
				binhLuanAdminDomain.setGiay(giayAdminDomain);
			}

			binhLuanAdminDomains.add(binhLuanAdminDomain);
		}
		listBinhLuanAdmin.setBinhluans(binhLuanAdminDomains);
		return listBinhLuanAdmin;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBinhLuan(String mabl) {
		binhLuanReponsitory.deleteById(mabl);
	}

	@Override
	public BinhLuanAdminDomain getBinhLuanbyId(String mabl) {

		// get a binhluan of khachhang
		Binhluan binhluanGet = binhLuanReponsitory.findById(mabl).get();
		BinhLuanAdminDomain binhLuanAdminDomain = new BinhLuanAdminDomain();

		binhLuanAdminDomain.converToDomain(binhluanGet);

		if (binhluanGet.getKhachhang() != null) {
			KhachHangAdminDomain khachHangAdminDomain = new KhachHangAdminDomain();
			khachHangAdminDomain.converToDomain(binhluanGet.getKhachhang());
			binhLuanAdminDomain.setKhachhang(khachHangAdminDomain);
		}
		if (binhluanGet.getPhukien() != null) {
			PhuKienAdminDomain phuKienAdminDomain = new PhuKienAdminDomain();
			phuKienAdminDomain.converToDomain(binhluanGet.getPhukien());
			binhLuanAdminDomain.setPhukien(phuKienAdminDomain);
		}

		if (binhluanGet.getGiay() != null) {
			GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
			giayAdminDomain.converToDomain(binhluanGet.getGiay());
			binhLuanAdminDomain.setGiay(giayAdminDomain);
		}

		// get list binhluan response of nhanvien
		List<BinhLuanAdminDomain> binhLuanAdminDomainTraLois = new ArrayList<>();

		for (Binhluan binhluan : binhluanGet.getBinhluans()) {

			BinhLuanAdminDomain binhLuanAdminDomainTraLoi = new BinhLuanAdminDomain();
			binhLuanAdminDomainTraLoi.converToDomain(binhluan);

			if (binhluan.getNhanvien() != null) {
				NhanVienAdminDomain nhanVienAdminDomain = new NhanVienAdminDomain();
				nhanVienAdminDomain.converToDomain(binhluan.getNhanvien());
				binhLuanAdminDomainTraLoi.setNhanvien(nhanVienAdminDomain);
			}
			binhLuanAdminDomainTraLois.add(binhLuanAdminDomainTraLoi);

		}
		binhLuanAdminDomain.setBinhluans(binhLuanAdminDomainTraLois);

		return binhLuanAdminDomain;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void traLoiBinhLuan(String manv, TraLoiBinhLuanAdminDomain traLoiBinhLuanAdminDomain) throws ThtShoesException {
		
		Binhluan checkBinhLuan = binhLuanReponsitory.findById(traLoiBinhLuanAdminDomain.getMablTraloi()).get();
		
		if(checkBinhLuan.getKhachhang() == null || (checkBinhLuan.getGiay() == null && checkBinhLuan.getPhukien() == null) || checkBinhLuan.getNhanvien() != null) {
			throw new ThtShoesException("Không thể trả lời bình luận này");
		}
		
		Binhluan binhluanSave = new Binhluan();

		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setManv(manv);
		binhluanSave.setNhanvien(nhanvien);

		Binhluan binhluanTraLoi = new Binhluan();
		binhluanTraLoi.setMabl(traLoiBinhLuanAdminDomain.getMablTraloi());

		binhluanSave.setBinhluan(binhluanTraLoi);
		binhluanSave.setMota(traLoiBinhLuanAdminDomain.getMota());
		
		binhLuanReponsitory.save(binhluanSave);
	}

}
