package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.AddGiayAdminDomain;
import com.herokuapp.domain.admin.DanhmucAdminDomain;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.HangAdminDomain;
import com.herokuapp.domain.admin.HinhAdminDomain;
import com.herokuapp.domain.admin.LoaiGiayAdminDomain;
import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.SizeMauAdmin;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayMauSize;
import com.herokuapp.entity.GiayMauSizePK;
import com.herokuapp.entity.LoaigiayHangDanhmuc;
import com.herokuapp.entity.LoaigiayHangDanhmucPK;
import com.herokuapp.entity.Mausac;
import com.herokuapp.entity.SoluongGiay;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySeqReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.LoaigiayHangDanhmucReponsitory;
import com.herokuapp.reponsitory.MauSacReponsitory;
import com.herokuapp.reponsitory.SoLuongGiayReponsitory;
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

	@Autowired
	public SoLuongGiayReponsitory soLuongGiayReponsitory;

	@Autowired
	public LoaigiayHangDanhmucReponsitory loaigiayHangDanhmucReponsitory;

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
	public String addGiay(AddGiayAdminDomain giayAdminDomain) {
		String idNextGiay = PrefixId.GIAY + giaySeqReponsitory.getIdNext();
		int idLoaigiayHangDanhmuc;
		LoaigiayHangDanhmuc loaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory.findByLoaiGiayHangDanhMuc(
				giayAdminDomain.getMaLoaiGiay(), giayAdminDomain.getMaHang(), giayAdminDomain.getMaDanhMuc());
		if (loaigiayHangDanhmuc == null) {
			idLoaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory.getIdNext();

			LoaigiayHangDanhmuc loaigiayHangDanhmucADD = new LoaigiayHangDanhmuc();

			LoaigiayHangDanhmucPK loaigiayHangDanhmucPK = new LoaigiayHangDanhmucPK();
			loaigiayHangDanhmucPK.setMaloaigiay(giayAdminDomain.getMaLoaiGiay());
			loaigiayHangDanhmucPK.setMahang(giayAdminDomain.getMaHang());
			loaigiayHangDanhmucPK.setMadanhmuc(giayAdminDomain.getMaDanhMuc());

			loaigiayHangDanhmucADD.setId(loaigiayHangDanhmucPK);
			loaigiayHangDanhmucReponsitory.save(loaigiayHangDanhmucADD);

		} else {
			idLoaigiayHangDanhmuc = loaigiayHangDanhmuc.getId().getMaLgiayHang();
		}
		Giay giay = giayAdminDomain.converToEntity();
		giay.setMaLgiayHang(idLoaigiayHangDanhmuc);
		giayReponsitory.save(giay);
		for (SizeMauAdmin sizeMauAdmin : giayAdminDomain.getSizeMaus()) {

			GiayMauSizePK giayMauSizePK = new GiayMauSizePK();
			giayMauSizePK.setMagiay(idNextGiay);
			giayMauSizePK.setMasize(sizeMauAdmin.getMasize());
			giayMauSizePK.setMamau(sizeMauAdmin.getMamau());

			GiayMauSize giayMauSize = new GiayMauSize();
			giayMauSize.setId(giayMauSizePK);
			giayMauSize.setSoluong(sizeMauAdmin.getSoluong());

			int idNextGiayMauSize = giaySizeMauReponsitory.getIdNext();

			giaySizeMauReponsitory.save(giayMauSize);

			SoluongGiay soluongGiay = new SoluongGiay();
			soluongGiay.setSoluongthem(sizeMauAdmin.getSoluong());
			soluongGiay.setIdGiaySizeMau(idNextGiayMauSize);
			soluongGiay.setMota("Thêm Giày Mới");
			soLuongGiayReponsitory.save(soluongGiay);
		}
		return idNextGiay;
	}

	@Override
	public GiayAdminDomain getGiayById(String idGiay) {
		Giay giay = giayReponsitory.findById(idGiay).get();
		GiayAdminDomain giayAdminDomain = new GiayAdminDomain();
		List<SizeAdminDomain> sizeAdminDomains = new ArrayList<>();
		giayAdminDomain.converToDomain(giay);

//		LoaigiayHangDanhmuc loaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory
//				.findByMaLgiayHang(giay.getMaLgiayHang());
//
//		LoaiGiayAdminDomain loaiGiayAdminDomain = new LoaiGiayAdminDomain();
//		loaiGiayAdminDomain.converToDomain(loaigiayHangDanhmuc.getLoaigiay());
//		giayAdminDomain.setLoaigiay(loaiGiayAdminDomain);
//
//		HangAdminDomain hangAdminDomain = new HangAdminDomain();
//		hangAdminDomain.converToDomain(loaigiayHangDanhmuc.getHang());
//		giayAdminDomain.setHang(hangAdminDomain);
//
//		DanhmucAdminDomain danhmucAdminDomain = new DanhmucAdminDomain();
//		danhmucAdminDomain.converToDomain(loaigiayHangDanhmuc.getDanhmuc());
//		giayAdminDomain.setDanhmuc(danhmucAdminDomain);

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

	@Override
	public void deleteGiay(String magiay) {
		Giay giay = giayReponsitory.findById(magiay).get();

	}

}
