package com.herokuapp.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.HinhAdminDomain;
import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.entity.Giay;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySeqReponsitory;
import com.herokuapp.util.PrefixId;

@Service
public class GiayAdminServiceImpl implements GiayAdminService {

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public GiaySeqReponsitory giaySeqReponsitory;

	@Override
	public ListGiayAdmin getAllGiay() {
		ListGiayAdmin listGiay = new ListGiayAdmin();
		List<Giay> giayEntitys = giayReponsitory.findAll();
		giayEntitys.forEach(giay -> {

			GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
			giayAdminDomain.converToDomain(giay);

			giay.getSizes().forEach(size -> {
				SizeAdminDomain sizeDomain = new SizeAdminDomain();
				sizeDomain.converToDomain(size);
				giayAdminDomain.getSizes().add(sizeDomain);
			});

			giay.getMausacs().forEach(mausac -> {
				MauSacAdminDomain mauSacDomain = new MauSacAdminDomain();
				mauSacDomain.converToDomain(mausac);
				giayAdminDomain.getMausacs().add(mauSacDomain);
			});

			giay.getHinhs().forEach(hinh -> {
				HinhAdminDomain hinhDomain = new HinhAdminDomain();
				hinhDomain.converToDomain(hinh);
				giayAdminDomain.getHinhs().add(hinhDomain);
			});
			listGiay.getGiays().add(giayAdminDomain);
		});
		return listGiay;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addGiay(GiayAdminDomain giayAdminDomain) {
		String idNextGiay = PrefixId.GIAY + giaySeqReponsitory.getIdNext();
		Giay giay = giayAdminDomain.converToEntity();
		giayReponsitory.save(giay);
	}

	@Override
	public GiayAdminDomain getGiayById(String idGiay) {
		Giay giay = giayReponsitory.findById(idGiay).get();
		GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
		giayAdminDomain.converToDomain(giay);
		giay.getSizes().forEach(size -> {
			SizeAdminDomain sizeDomain = new SizeAdminDomain();
			sizeDomain.converToDomain(size);
			giayAdminDomain.getSizes().add(sizeDomain);
		});

		giay.getMausacs().forEach(mausac -> {
			MauSacAdminDomain mauSacDomain = new MauSacAdminDomain();
			mauSacDomain.converToDomain(mausac);
			giayAdminDomain.getMausacs().add(mauSacDomain);
		});

		giay.getHinhs().forEach(hinh -> {
			HinhAdminDomain hinhDomain = new HinhAdminDomain();
			hinhDomain.converToDomain(hinh);
			giayAdminDomain.getHinhs().add(hinhDomain);
		});
		return giayAdminDomain;
	}

}
