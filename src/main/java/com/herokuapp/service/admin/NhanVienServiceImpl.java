package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.InfoNhanvienDangKy;
import com.herokuapp.domain.admin.NhanVienAdminDomain;
import com.herokuapp.domain.admin.TaiKhoanAdminDomain;
import com.herokuapp.domain.admin.list.ListNhanVienAdmin;
import com.herokuapp.entity.Nhanvien;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.entity.Taikhoanseq;
import com.herokuapp.enums.Quyen;
import com.herokuapp.reponsitory.NhanVienReponsitory;
import com.herokuapp.reponsitory.TaiKhoanReponsitory;
import com.herokuapp.reponsitory.TaiKhoanSeqReponsitory;
import com.herokuapp.service.common.EmailService;
import com.herokuapp.util.PrefixId;

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
	@Transactional(rollbackFor = Exception.class)
	public void addNhanVien(InfoNhanvienDangKy infoNhanvienDangKy) {
		String maNguoiDung = PrefixId.NHAN_VIEN + getTaiKhoanIdSeq();

		Taikhoan taiKhoan = infoNhanvienDangKy.getTaikhoan().converToEntity();
		taiKhoan.setQuyen(Quyen.NHANVIEN);
		taiKhoan.setManguoidung(maNguoiDung);
		taiKhoan.setTinhtrang((byte) 1);
		taiKhoanReponsitory.save(taiKhoan);

		Nhanvien nhanvien = infoNhanvienDangKy.getNhanvien().converToEntity();
		nhanvien.setManv(maNguoiDung);
		nhanVienReponsitory.save(nhanvien);

//		if (infoNhanvienDangKy.getTaikhoan().getEmail() != null) {
//			String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
//			String url = baseUrl + URL.KHACH_HANG + URL.DANG_KY + "/" + maNguoiDung;
//			emailService.sendSimpleMessage(infoNhanvienDangKy.getTaikhoan().getEmail(), "Thông Báo Xác Thực Tài Khoản",
//					url);
//		}

	}

	@Transactional(rollbackFor = Exception.class)
	private int getTaiKhoanIdSeq() {
		int id = taiKhoanSeqReponsitory.save(new Taikhoanseq()).getId();
		return id;
	}

	@Override
	public NhanVienAdminDomain getInfoNhanVien(String idMaNhanvien) {
		Nhanvien nhanvien = nhanVienReponsitory.findById(idMaNhanvien).get();
		NhanVienAdminDomain nhanVienAdminDomain = new NhanVienAdminDomain();
		nhanVienAdminDomain.converToDomain(nhanvien);
		return nhanVienAdminDomain;
	}

	@Override
	public ListNhanVienAdmin getAllNhanVien() {
		ListNhanVienAdmin listNhanVienAdmin = new ListNhanVienAdmin();
		List<NhanVienAdminDomain> nhanVienAdminDomains = new ArrayList<>();
		List<Nhanvien> nhanviens = nhanVienReponsitory.findAll();

		nhanviens.forEach(nhanvien -> {
			NhanVienAdminDomain nhanVienAdminDomain = new NhanVienAdminDomain();
			nhanVienAdminDomain.converToDomain(nhanvien);
			nhanVienAdminDomains.add(nhanVienAdminDomain);
		});
		listNhanVienAdmin.setNhanviens(nhanVienAdminDomains);
		return listNhanVienAdmin;
	}

	@Override
	public NhanVienAdminDomain getNhanVienyId(String mavn) {
		Nhanvien nhanvien = nhanVienReponsitory.findById(mavn).get();
		NhanVienAdminDomain nhanVienAdminDomain = new NhanVienAdminDomain();
		TaiKhoanAdminDomain taiKhoanAdminDomain = new TaiKhoanAdminDomain();
		taiKhoanAdminDomain.converToDomain(nhanvien.getTaikhoan());
		nhanVienAdminDomain.setTaiKhoan(taiKhoanAdminDomain);
		nhanVienAdminDomain.converToDomain(nhanvien);
		return nhanVienAdminDomain;
	}

}
