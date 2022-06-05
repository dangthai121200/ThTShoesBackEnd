package com.herokuapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.entity.Taikhoanseq;
import com.herokuapp.reponsitory.KhachHangReponsitory;
import com.herokuapp.reponsitory.TaiKhoanReponsitory;
import com.herokuapp.reponsitory.TaiKhoanSeqReponsitory;
import com.herokuapp.util.PrefixId;
import com.herokuapp.util.URL;

@Service
public class DangKyServiceImpl implements DangKyService {

	@Autowired
	public TaiKhoanReponsitory taiKhoanReponsitory;

	@Autowired
	public KhachHangReponsitory khachHangReponsitory;

	@Autowired
	public TaiKhoanSeqReponsitory taiKhoanSeqReponsitory;

	@Autowired
	public EmailService emailService;

	@Override
	public void dangKyKhachHang(InfoKhachHangDangKy infoDangKy) {

		String maNguoiDung = PrefixId.KHACHHANG + getTaiKhoanIdSeq();

		Taikhoan taiKhoan = infoDangKy.getTaiKhoanDomain().converToEntity();
		taiKhoan.setManguoidung(maNguoiDung);
		taiKhoanReponsitory.save(taiKhoan);

		Khachhang khachHang = infoDangKy.getKhachHangDomain().converToEntity();
		khachHang.setMakh(maNguoiDung);
		khachHangReponsitory.save(khachHang);

		String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		String url = baseUrl + URL.DANG_KY + URL.KHACH_HANG + "/" + maNguoiDung;
		emailService.sendSimpleMessage(infoDangKy.getTaiKhoanDomain().getEmail(), "Thông Báo Xác Thực Tài Khoản", url);
	}

	private int getTaiKhoanIdSeq() {
		int id = taiKhoanSeqReponsitory.save(new Taikhoanseq()).getId();
		return id;
	}

	@Override
	public void dangKyNhanVien(InfoKhachHangDangKy infoDangKy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void authencationTaiKhoan(String manguoidung) {
		Taikhoan taikhoan = taiKhoanReponsitory.findById(manguoidung).orElseThrow();
		if (taikhoan.getTinhtrang() == 0) {
			taikhoan.setTinhtrang((byte) 1);
			taiKhoanReponsitory.save(taikhoan);
		} else {
			return;
		}
	}

}
