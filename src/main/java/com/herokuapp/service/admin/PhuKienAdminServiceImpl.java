package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.AddPhuKienAdmin;
import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.SoLuongPhuKienAdminDoamin;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
import com.herokuapp.entity.Loaiphukien;
import com.herokuapp.entity.Phukien;
import com.herokuapp.entity.SoluongPhukien;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.reponsitory.PhuKienSeqReponsitory;
import com.herokuapp.reponsitory.PhukienDonhangReponsitory;
import com.herokuapp.reponsitory.SoLuongPhuKienReponsitory;
import com.herokuapp.util.PrefixId;

@Service
public class PhuKienAdminServiceImpl implements PhuKienAdminService {

	@Autowired
	public PhuKienReponsitory phuKienReponsitory;

	@Autowired
	public PhuKienSeqReponsitory phuKienSeqReponsitory;

	@Autowired
	public SoLuongPhuKienReponsitory soLuongPhuKienReponsitory;

	@Autowired
	public PhukienDonhangReponsitory phukienDonhangReponsitory;

	@Override
	public ListPhuKienAdmin getAllPhuKien() {
		ListPhuKienAdmin listPhuKienAdmin = new ListPhuKienAdmin();
		List<PhuKienAdminDomain> phuKienAdminDomains = new ArrayList<>();
		List<Phukien> phukiens = phuKienReponsitory.findAll();
		phukiens.forEach(phukien -> {
			PhuKienAdminDomain phukienAdminDomain = new PhuKienAdminDomain();
			phukienAdminDomain.converToDomain(phukien);
			phuKienAdminDomains.add(phukienAdminDomain);

		});
		listPhuKienAdmin.setPhuKiens(phuKienAdminDomains);
		return listPhuKienAdmin;
	}

	@Override
	public PhuKienAdminDomain getPhuKienById(String idPhuKien) {
		PhuKienAdminDomain phuKienAdminDomain = new PhuKienAdminDomain();
		Phukien phukien = phuKienReponsitory.findById(idPhuKien).get();
		phuKienAdminDomain.converToDomain(phukien);

		// get soluong add of phukien
		List<SoLuongPhuKienAdminDoamin> soLuongPhuKienAdminDoamins = new ArrayList<>();
		for (SoluongPhukien soluongPhukien : phukien.getSoluongPhukiens()) {
			SoLuongPhuKienAdminDoamin soLuongPhuKienAdminDoamin = new SoLuongPhuKienAdminDoamin();
			soLuongPhuKienAdminDoamin.converToDomain(soluongPhukien);
			soLuongPhuKienAdminDoamins.add(soLuongPhuKienAdminDoamin);
		}
		phuKienAdminDomain.setSoluongphukiens(soLuongPhuKienAdminDoamins);

		return phuKienAdminDomain;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addPhuKien(AddPhuKienAdmin addPhuKienAdmin) {
		String idNextPhukien = PrefixId.PHU_KIEN + phuKienSeqReponsitory.getIdNext();
		Phukien phukien = addPhuKienAdmin.converToEntity();
		Loaiphukien loaiphukien = new Loaiphukien();
		loaiphukien.setMaloaipk(addPhuKienAdmin.getMaLoaiPk());
		phukien.setMapk(idNextPhukien);
		phukien.setLoaiphukien(loaiphukien);
		phuKienReponsitory.save(phukien);

		SoluongPhukien soluongPhukien = new SoluongPhukien();

		soluongPhukien.setPhukien(phukien);
		soluongPhukien.setSoluong(addPhuKienAdmin.getSoluong());
		soluongPhukien.setMota("Thêm Mới Phụ Kiện");
		soLuongPhuKienReponsitory.save(soluongPhukien);

		return idNextPhukien;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updatePhuKien(AddPhuKienAdmin addPhuKienAdmin) throws ThtShoesException {
		Phukien phukien = phuKienReponsitory.findById(addPhuKienAdmin.getMapk()).get();

		int soluongOld = phukien.getSoluong();
		int soluongNew = addPhuKienAdmin.getSoluong();

		if (soluongNew < 0) {
			throw new ThtShoesException("Vui lòng nhập số lượng lớn hơn hoặc bằng 0");
		}

		boolean checkSoLuong = false;

		if (soluongOld == soluongNew) {
			checkSoLuong = true;
		}

		phukien.setGia(addPhuKienAdmin.getGia());
		phukien.setTenpk(addPhuKienAdmin.getTenpk());
		phukien.setMota(addPhuKienAdmin.getMota());
		phukien.setSoluong(soluongNew);

		Loaiphukien loaiphukien = new Loaiphukien();
		loaiphukien.setMaloaipk(addPhuKienAdmin.getMaLoaiPk());
		phukien.setLoaiphukien(loaiphukien);

		phuKienReponsitory.save(phukien);

		if (!checkSoLuong) {
			SoluongPhukien soluongPhukien = new SoluongPhukien();
			soluongPhukien.setPhukien(phukien);
			soluongPhukien.setSoluong(soluongNew - soluongOld);
			soluongPhukien.setMota(addPhuKienAdmin.getMotaSoLuong());
			soLuongPhuKienReponsitory.save(soluongPhukien);
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deletePhuKien(String mapk) throws ThtShoesException {
		int count = phukienDonhangReponsitory.countPhuKienByIdPk(mapk);
		if (count > 0) {
			throw new ThtShoesException("Không thể xóa phụ kiện đã có đơn hàng");
		}
		phuKienReponsitory.deleteById(mapk);
	}

}
