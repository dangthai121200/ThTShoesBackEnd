package com.herokuapp.service.nhanvien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herokuapp.domain.nhanvien.InfoNhanvienDangKy;
import com.herokuapp.entity.Nhanvien;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.entity.Taikhoanseq;
import com.herokuapp.enums.Quyen;
import com.herokuapp.reponsitory.NhanVienReponsitory;
import com.herokuapp.reponsitory.TaiKhoanReponsitory;
import com.herokuapp.reponsitory.TaiKhoanSeqReponsitory;
import com.herokuapp.service.common.EmailService;
import com.herokuapp.util.PrefixId;
import com.herokuapp.util.URL;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	public TaiKhoanReponsitory taiKhoanReponsitory;

	@Autowired
	public TaiKhoanSeqReponsitory taiKhoanSeqReponsitory;

	@Autowired
	public NhanVienReponsitory nhanVienReponsitory;

	@Autowired
	public EmailService emailService;

	@Override
	public void addNhanVien(InfoNhanvienDangKy infoNhanvienDangKy) {
		String maNguoiDung = PrefixId.NHAN_VIEN + getTaiKhoanIdSeq();

	
		Taikhoan taiKhoan = infoNhanvienDangKy.getTaikhoan().converToEntity();
		taiKhoan.setQuyen(Quyen.NHANVIEN);
		taiKhoan.setManguoidung(maNguoiDung);
		taiKhoanReponsitory.save(taiKhoan);

		Nhanvien nhanvien = infoNhanvienDangKy.getNhanvien().converToEntity();
		nhanvien.setManv(maNguoiDung);
		nhanVienReponsitory.save(nhanvien);

		if (infoNhanvienDangKy.getTaikhoan().getEmail() != null) {
			String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String url = baseUrl + URL.KHACH_HANG + URL.DANG_KY + "/" + maNguoiDung;
			emailService.sendSimpleMessage(infoNhanvienDangKy.getTaikhoan().getEmail(), "Thông Báo Xác Thực Tài Khoản",
					url);
		}

	}

	@Transactional(rollbackFor = Exception.class)
	private int getTaiKhoanIdSeq() {
		int id = taiKhoanSeqReponsitory.save(new Taikhoanseq()).getId();
		return id;
	}

}
