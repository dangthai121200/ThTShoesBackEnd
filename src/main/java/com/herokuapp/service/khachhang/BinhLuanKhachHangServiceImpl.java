package com.herokuapp.service.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;
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

}
