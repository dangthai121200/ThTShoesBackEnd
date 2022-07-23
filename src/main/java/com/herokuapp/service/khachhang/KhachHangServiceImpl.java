package com.herokuapp.service.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.herokuapp.domain.khachhang.KhachHangDomain;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.reponsitory.KhachHangReponsitory;
import com.herokuapp.security.UserDetailsConfigure;

@Service
public class KhachHangServiceImpl implements KhachHangService {

//	@Autowired
//	public KhachHangSeqReponsitory khachHangSeqReponsitory;

	@Autowired
	public KhachHangReponsitory khachHangReponsitory;

	@Override
	public KhachHangDomain getInfoKhachHangById(String idKh) {
		UserDetailsConfigure userDetailsConfigure = (UserDetailsConfigure) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (userDetailsConfigure.getManguoidung().equals(idKh)) {
			Khachhang khachhang = khachHangReponsitory.findById(idKh).get();
			KhachHangDomain khachHangDomain = new KhachHangDomain();
			khachHangDomain.converToDomain(khachhang);
			return khachHangDomain;
		}
		throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bạn không có quyền truy cập");

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public KhachHangDomain updateInfoKhachHang(KhachHangDomain khachHangDomain) {
		UserDetailsConfigure userDetailsConfigure = (UserDetailsConfigure) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (userDetailsConfigure.getManguoidung().equals(khachHangDomain.getMakh())) {
			Khachhang khachhang = khachHangReponsitory.save(khachHangDomain.converToEntity());
			KhachHangDomain khachHangDomainUpdate = new KhachHangDomain();
			khachHangDomainUpdate.converToDomain(khachhang);
			return khachHangDomainUpdate;
		}
		throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bạn không có quyền truy cập");
	}

	@Override
	public Boolean checkSdt(String sdt) {
		try {
			Khachhang khachhang = khachHangReponsitory.getKhachHangBySdt(sdt);
			if (khachhang != null) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

}
