package com.herokuapp.service.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.LoaigiayHangDanhmucDomain;
import com.herokuapp.entity.LoaigiayHangDanhmuc;
import com.herokuapp.entity.LoaigiayHangDanhmucPK;
import com.herokuapp.reponsitory.LoaigiayHangDanhmucReponsitory;

@Service
public class LoaigiayHangDanhmucServiceImpl implements LoaigiayHangDanhmucService {

	@Autowired
	public LoaigiayHangDanhmucReponsitory loaigiayHangDanhmucReponsitory;

	@Override
	public LoaigiayHangDanhmucDomain findByMaLgiayHang(int id) {
		LoaigiayHangDanhmuc loaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory.findByMaLgiayHang(id);
		LoaigiayHangDanhmucDomain loaigiayHangDanhmucDomain = new LoaigiayHangDanhmucDomain();
		loaigiayHangDanhmucDomain.converToDomain(loaigiayHangDanhmuc);
		return loaigiayHangDanhmucDomain;
	}

}
