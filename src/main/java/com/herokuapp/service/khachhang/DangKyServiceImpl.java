package com.herokuapp.service.khachhang;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.herokuapp.domain.khachhang.InfoKhachHangDangKy;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.entity.Taikhoanseq;
import com.herokuapp.enums.Quyen;
import com.herokuapp.reponsitory.KhachHangReponsitory;
import com.herokuapp.reponsitory.TaiKhoanReponsitory;
import com.herokuapp.reponsitory.TaiKhoanSeqReponsitory;
import com.herokuapp.service.common.EmailService;
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
	public PasswordEncoder passwordEncoder;

	@Autowired
	public EmailService emailService;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void dangKyKhachHang(InfoKhachHangDangKy infoDangKy) throws MessagingException {

		String maNguoiDung = PrefixId.KHACHHANG + getTaiKhoanIdSeq();

		Taikhoan taiKhoan = infoDangKy.getTaiKhoan().converToEntity();
		taiKhoan.setQuyen(Quyen.KHACHHANG);
		taiKhoan.setManguoidung(maNguoiDung);
		taiKhoan.setPassword(passwordEncoder.encode(taiKhoan.getPassword()));
		taiKhoanReponsitory.save(taiKhoan);

		Khachhang khachHang = infoDangKy.getKhachHang().converToEntity();
		khachHang.setMakh(maNguoiDung);
		khachHangReponsitory.save(khachHang);

		if (infoDangKy.getTaiKhoan().getEmail() != null) {
			String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
			String url = baseUrl + URL.KHACH_HANG + URL.DANG_KY + "/" + maNguoiDung;
			Map<String, Object> props = new HashMap<String, Object>();
			props.put("url", url);
			String html = emailService.convertToTemplateHtmlEmail(props, "xacthuc-mail");
			emailService.sendMessageWithAttachment(infoDangKy.getTaiKhoan().getEmail(), "Thông Báo Xác Thực Tài Khoản",
					html, null);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	private int getTaiKhoanIdSeq() {
		int id = taiKhoanSeqReponsitory.save(new Taikhoanseq()).getId();
		return id;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void authencationTaiKhoan(String manguoidung) {
		Taikhoan taikhoan = taiKhoanReponsitory.findById(manguoidung).get();
		if (taikhoan != null && taikhoan.getTinhtrang() == 0) {
			taikhoan.setTinhtrang((byte) 1);
			taiKhoanReponsitory.save(taikhoan);
		} else {
			return;
		}
	}

}
