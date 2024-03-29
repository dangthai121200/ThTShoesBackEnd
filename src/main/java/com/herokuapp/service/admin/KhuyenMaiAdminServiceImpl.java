package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.herokuapp.domain.admin.AddKhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.KhuyenMaiAdminDomain;
import com.herokuapp.domain.admin.NhanVienAdminDomain;
import com.herokuapp.domain.admin.list.ListKhuyenMaiAdmin;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.entity.Nhanvien;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.DonHangReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiReponsitory;
import com.herokuapp.reponsitory.KhuyenMaiSeqReponsitory;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.util.PrefixId;

@Service
public class KhuyenMaiAdminServiceImpl implements KhuyenMaiAdminService {

	@Autowired
	public KhuyenMaiReponsitory khuyenMaiReponsitory;

	@Autowired
	public KhuyenMaiSeqReponsitory khuyenMaiSeqReponsitory;

	@Autowired
	public DonHangReponsitory donHangReponsitory;

	@Override
	public ListKhuyenMaiAdmin getAllKhuyenMai() {
		ListKhuyenMaiAdmin listKhuyenMaiAdmin = new ListKhuyenMaiAdmin();
		List<KhuyenMaiAdminDomain> khuyenMais = new ArrayList<>();
		List<Dskhuyenmai> dskhuyenmais = khuyenMaiReponsitory.findAll();
		dskhuyenmais.forEach(khuyenmai -> {
			KhuyenMaiAdminDomain khuyenMaiAdminDomain = new KhuyenMaiAdminDomain();
			khuyenMaiAdminDomain.converToDomain(khuyenmai);
			khuyenMais.add(khuyenMaiAdminDomain);
		});
		listKhuyenMaiAdmin.setKhuyenMais(khuyenMais);
		return listKhuyenMaiAdmin;
	}

	@Override
	public KhuyenMaiAdminDomain getKhuyenMaiById(String makm) {
		KhuyenMaiAdminDomain khuyenMaiAdminDomain = new KhuyenMaiAdminDomain();
		NhanVienAdminDomain nhanVienAdminDomain = new NhanVienAdminDomain();
		Dskhuyenmai dskhuyenmai = khuyenMaiReponsitory.findById(makm).get();
		khuyenMaiAdminDomain.converToDomain(dskhuyenmai);
		nhanVienAdminDomain.converToDomain(dskhuyenmai.getNhanvien());
		khuyenMaiAdminDomain.setNhanVienAdminDomain(nhanVienAdminDomain);
		return khuyenMaiAdminDomain;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addKhuyenMai(AddKhuyenMaiAdminDomain addKhuyenMaiAdminDomain) {
		String idKhuyenMaiNext = PrefixId.KHUYEN_MAI + khuyenMaiSeqReponsitory.getIdNext();
		String manv = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getManguoidung();
		Dskhuyenmai dskhuyenmai = addKhuyenMaiAdminDomain.converToEntity();
		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setManv(manv);
		dskhuyenmai.setNhanvien(nhanvien);
		khuyenMaiReponsitory.save(dskhuyenmai);
		return idKhuyenMaiNext;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String updateKhuyenMai(AddKhuyenMaiAdminDomain addKhuyenMaiAdminDomain) throws ThtShoesException {
		if (StringUtils.isEmpty(addKhuyenMaiAdminDomain.getMakm())) {
			throw new ThtShoesException("Không tìm thấy dữ liệu: " + addKhuyenMaiAdminDomain.getMakm());
		}
		Dskhuyenmai dskhuyenmai = khuyenMaiReponsitory.findById(addKhuyenMaiAdminDomain.getMakm()).get();
		dskhuyenmai.setSoluong(addKhuyenMaiAdminDomain.getSoluong());
		dskhuyenmai.setNgaybd(addKhuyenMaiAdminDomain.getNgaybd());
		dskhuyenmai.setNgaykt(addKhuyenMaiAdminDomain.getNgaykt());
		dskhuyenmai.setMota(addKhuyenMaiAdminDomain.getMota());
		dskhuyenmai.setGiatrigiam(addKhuyenMaiAdminDomain.getGiatrigiam());
		dskhuyenmai.setTieude(addKhuyenMaiAdminDomain.getTieude());

		khuyenMaiReponsitory.save(dskhuyenmai);
		return addKhuyenMaiAdminDomain.getMakm();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteKhuyenMai(String makm) throws ThtShoesException {
		int checkKhuyenMaiInDonHang = donHangReponsitory.countKhuyenMaiInDonHang(makm);
		if (checkKhuyenMaiInDonHang > 0) {
			throw new ThtShoesException("Khuyến mãi đã có trong đơn hàng");
		}

		khuyenMaiReponsitory.deleteById(makm);
	}

}
