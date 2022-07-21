package com.herokuapp.service.admin;

import java.util.ArrayList;
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
import com.herokuapp.entity.GiayMauSize;
import com.herokuapp.entity.Mausac;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySeqReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.MauSacReponsitory;
import com.herokuapp.util.PrefixId;

@Service
public class GiayAdminServiceImpl implements GiayAdminService {

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public GiaySeqReponsitory giaySeqReponsitory;

	@Autowired
	public MauSacReponsitory mauSacReponsitory;

	@Autowired
	public GiaySizeMauReponsitory giaySizeMauReponsitory;

	@Override
	public ListGiayAdmin getAllGiay() {
		ListGiayAdmin listGiay = new ListGiayAdmin();
		List<Giay> giayEntitys = giayReponsitory.findAll();
		giayEntitys.forEach(giay -> {

			GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
			giayAdminDomain.converToDomain(giay);

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
	public String addGiay(GiayAdminDomain giayAdminDomain) {
		String idNextGiay = PrefixId.GIAY + giaySeqReponsitory.getIdNext();
		Giay giay = giayAdminDomain.converToEntity();
		giayReponsitory.save(giay);
		return idNextGiay;
	}

	@Override
	public GiayAdminDomain getGiayById(String idGiay) {
		Giay giay = giayReponsitory.findById(idGiay).get();
		GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
		List<SizeAdminDomain> sizeAdminDomains = new ArrayList<>();
		giayAdminDomain.converToDomain(giay);

		giay.getHinhs().forEach(hinh -> {
			HinhAdminDomain hinhDomain = new HinhAdminDomain();
			hinhDomain.converToDomain(hinh);
			giayAdminDomain.getHinhs().add(hinhDomain);
		});

		for (GiayMauSize giayMauSize : giay.getGiayMauSizes()) {
			SizeAdminDomain sizeAdminDomain = new SizeAdminDomain();
			sizeAdminDomain.converToDomain(giayMauSize.getSize());
			if (sizeAdminDomains.contains(sizeAdminDomain)) {
				continue;
			}
			List<Mausac> mausacs = mauSacReponsitory.getMauSacByIdGiayAndIdSize(giayAdminDomain.getMagiay(),
					sizeAdminDomain.getMasize());
			sizeAdminDomain.setMausacs(
					convertToListMauSacDomain(mausacs, giayAdminDomain.getMagiay(), sizeAdminDomain.getMasize()));
			sizeAdminDomains.add(sizeAdminDomain);
		}
		giayAdminDomain.setSizes(sizeAdminDomains);
		return giayAdminDomain;
	}

	private List<MauSacAdminDomain> convertToListMauSacDomain(List<Mausac> mausacs, String maGiay, String maSize) {
		List<MauSacAdminDomain> mauSacDomains = new ArrayList<>();
		mausacs.forEach(mausac -> {
			MauSacAdminDomain mauSacDomain = new MauSacAdminDomain();
			mauSacDomain.converToDomain(mausac);
			int soluong = giaySizeMauReponsitory.getSoLuongByIdGiayIdSizeIdMau(maGiay, maSize, mausac.getMamau());
			mauSacDomain.setSoluong(soluong);
			mauSacDomains.add(mauSacDomain);
		});
		return mauSacDomains;

	}

}
