package com.herokuapp.service.khachhang;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.LoaiPhuKienDomain;
import com.herokuapp.domain.khachhang.list.ListLoaiPhuKien;
import com.herokuapp.entity.Loaiphukien;
import com.herokuapp.reponsitory.LoaiPhuKienReponsitory;

@Service
public class LoaiPhuKienServiceImpl implements LoaiPhuKienService {

	@Autowired
	public LoaiPhuKienReponsitory loaiPhuKienReponsitory;

	@Override
	public ListLoaiPhuKien getAllLoaiPhuKien() {
		ListLoaiPhuKien listLoaiPhuKien = new ListLoaiPhuKien();
		List<LoaiPhuKienDomain> loaiPhuKienDomains = new ArrayList<>();
		List<Loaiphukien> loaiphukiens = loaiPhuKienReponsitory.findAll();
		loaiphukiens.forEach(loaiphukien ->{
			LoaiPhuKienDomain loaiPhuKienDomain = new LoaiPhuKienDomain();
			loaiPhuKienDomain.converToDomain(loaiphukien);
			loaiPhuKienDomains.add(loaiPhuKienDomain);
		});
		listLoaiPhuKien.setLoaiPhuKiens(loaiPhuKienDomains);
		return listLoaiPhuKien;
	}

}
