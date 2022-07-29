package com.herokuapp.service.khachhang;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;
import com.herokuapp.domain.khachhang.KhachHangDomain;
import com.herokuapp.domain.khachhang.NhanVienKhachHangDomain;
import com.herokuapp.domain.khachhang.list.ListBinhLuanKhachHang;
import com.herokuapp.entity.Binhluan;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.entity.Phukien;
import com.herokuapp.reponsitory.BinhLuanReponsitory;
import com.herokuapp.util.PrefixId;

@Service
public class BinhLuanKhachHangServiceImpl implements BinhLuanKhachHangService {

	@Autowired
	public BinhLuanReponsitory binhLuanReponsitory;

	@Override
	public void binhLuanSanPham(BinhLuanKhachHangDomain binhLuanKhachHangDomain, String makh) {
		Binhluan binhluan = new Binhluan();

		binhluan.setMota(binhLuanKhachHangDomain.getMota());
		Khachhang khachhang = new Khachhang();
		khachhang.setMakh(makh);
		binhluan.setKhachhang(khachhang);

		if (binhLuanKhachHangDomain.getMasp().contains(PrefixId.PHU_KIEN)) {
			Phukien phukien = new Phukien();
			phukien.setMapk(binhLuanKhachHangDomain.getMasp());
			binhluan.setPhukien(phukien);

		} else if (binhLuanKhachHangDomain.getMasp().contains(PrefixId.GIAY)) {
			Giay giay = new Giay();
			giay.setMagiay(binhLuanKhachHangDomain.getMasp());
			binhluan.setGiay(giay);
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bạn không có quyền truy cập");
		}

		binhLuanReponsitory.save(binhluan);

	}

	@Override
	public ListBinhLuanKhachHang getAllBinhLuanByIdGiay(String magiay) {
		ListBinhLuanKhachHang listBinhLuanKhachHang = new ListBinhLuanKhachHang();
		List<Binhluan> binhluans = binhLuanReponsitory.getAllBinhLuanByIdGiay(magiay);
		List<BinhLuanKhachHangDomain> binhLuanKhachHangDomains = new ArrayList<>();

		for (Binhluan binhluan : binhluans) {
			BinhLuanKhachHangDomain binhLuanKhachHangDomain = new BinhLuanKhachHangDomain();
			binhLuanKhachHangDomain.converToDomain(binhluan);
			binhLuanKhachHangDomains.add(binhLuanKhachHangDomain);

			if (binhluan.getKhachhang() != null) {
				Khachhang khachhang = binhluan.getKhachhang();
				KhachHangDomain khachHangDomain = new KhachHangDomain();
				khachHangDomain.converToDomain(khachhang);
				binhLuanKhachHangDomain.setKhachHangDomain(khachHangDomain);
			}

			List<BinhLuanKhachHangDomain> binhLuanTraLois = new ArrayList<>();
			for (Binhluan binhLuanTraLoi : binhluan.getBinhluans()) {
				BinhLuanKhachHangDomain binhLuanTraLoiDoamin = new BinhLuanKhachHangDomain();
				binhLuanTraLoiDoamin.converToDomain(binhLuanTraLoi);
				if (binhLuanTraLoi.getNhanvien() != null) {
					NhanVienKhachHangDomain nhanVienKhachHangDomain = new NhanVienKhachHangDomain();
					nhanVienKhachHangDomain.converToDomain(binhLuanTraLoi.getNhanvien());
					binhLuanTraLoiDoamin.setNhanvien(nhanVienKhachHangDomain);
				}

				binhLuanTraLois.add(binhLuanTraLoiDoamin);
			}
			binhLuanKhachHangDomain.setBinhluans(binhLuanTraLois);

		}
		listBinhLuanKhachHang.setBinhluans(binhLuanKhachHangDomains);
		return listBinhLuanKhachHang;
	}

	@Override
	public ListBinhLuanKhachHang getAllBinhLuanByIdPhuKien(String mapk) {
		ListBinhLuanKhachHang listBinhLuanKhachHang = new ListBinhLuanKhachHang();
		List<Binhluan> binhluans = binhLuanReponsitory.getAllBinhLuanByIdPhuKien(mapk);
		List<BinhLuanKhachHangDomain> binhLuanKhachHangDomains = new ArrayList<>();

		for (Binhluan binhluan : binhluans) {
			BinhLuanKhachHangDomain binhLuanKhachHangDomain = new BinhLuanKhachHangDomain();
			binhLuanKhachHangDomain.converToDomain(binhluan);
			binhLuanKhachHangDomains.add(binhLuanKhachHangDomain);

			if (binhluan.getKhachhang() != null) {
				Khachhang khachhang = binhluan.getKhachhang();
				KhachHangDomain khachHangDomain = new KhachHangDomain();
				khachHangDomain.converToDomain(khachhang);
				binhLuanKhachHangDomain.setKhachHangDomain(khachHangDomain);
			}

			List<BinhLuanKhachHangDomain> binhLuanTraLois = new ArrayList<>();
			for (Binhluan binhLuanTraLoi : binhluan.getBinhluans()) {
				BinhLuanKhachHangDomain binhLuanTraLoiDoamin = new BinhLuanKhachHangDomain();
				binhLuanTraLoiDoamin.converToDomain(binhLuanTraLoi);
				if (binhLuanTraLoi.getNhanvien() != null) {
					NhanVienKhachHangDomain nhanVienKhachHangDomain = new NhanVienKhachHangDomain();
					nhanVienKhachHangDomain.converToDomain(binhLuanTraLoi.getNhanvien());
					binhLuanTraLoiDoamin.setNhanvien(nhanVienKhachHangDomain);
				}
				binhLuanTraLois.add(binhLuanTraLoiDoamin);
			}
			binhLuanKhachHangDomain.setBinhluans(binhLuanTraLois);

		}
		listBinhLuanKhachHang.setBinhluans(binhLuanKhachHangDomains);
		return listBinhLuanKhachHang;
	}

}
