package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.AddGiayAdminDomain;
import com.herokuapp.domain.admin.AddGiayMauSizeAdmin;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.GiaySizeMauAdminDomain;
import com.herokuapp.domain.admin.HinhAdminDomain;
import com.herokuapp.domain.admin.LoaigiayHangDanhmucAdminDomain;
import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.SizeMauAdmin;
import com.herokuapp.domain.admin.SoLuongGiaySizeMau;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.admin.list.ListSizeAdmin;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayMauSize;
import com.herokuapp.entity.GiayMauSizePK;
import com.herokuapp.entity.LoaigiayHangDanhmuc;
import com.herokuapp.entity.LoaigiayHangDanhmucPK;
import com.herokuapp.entity.Mausac;
import com.herokuapp.entity.SoluongGiay;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.reponsitory.GiayDonHangReponsitory;
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

	@Autowired
	public GiayDonHangReponsitory giayDonHangReponsitory;

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
		List<GiaySizeMauAdminDomain> giaySizeMauAdminDomains = new ArrayList<>();
		giayAdminDomain.converToDomain(giay);

		giay.getHinhs().forEach(hinh -> {
			HinhAdminDomain hinhDomain = new HinhAdminDomain();
			hinhDomain.converToDomain(hinh);
			giayAdminDomain.getHinhs().add(hinhDomain);
		});

		for (GiayMauSize giayMauSize : giay.getGiayMauSizes()) {
			GiaySizeMauAdminDomain sizeMauAdminDomain = new GiaySizeMauAdminDomain();
			sizeMauAdminDomain.converToDomain(giayMauSize);
			giaySizeMauAdminDomains.add(sizeMauAdminDomain);
		}

		giayAdminDomain.setGiaySizeMau(giaySizeMauAdminDomains);
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
	@Transactional(rollbackFor = Exception.class)
	public void deleteGiay(String magiay) throws ThtShoesException {
		int checkGiay = giayDonHangReponsitory.countGiayInGiayDonHangByMaGiay(magiay);
		if (checkGiay > 0) {
			throw new ThtShoesException("Không thể xóa giày đã có đơn hàng");
		} else {
			giayReponsitory.deleteById(magiay);
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void changeLGiayHangDanhMucOfGiay(String magiay,
			LoaigiayHangDanhmucAdminDomain loaigiayHangDanhmucAdminDomain) throws ThtShoesException {

		int idLoaigiayHangDanhmuc;

		String maLoaiGiay = loaigiayHangDanhmucAdminDomain.getLoaigiay().getMaloaigiay();
		String maHang = loaigiayHangDanhmucAdminDomain.getHang().getMahang();
		String maDanhmuc = loaigiayHangDanhmucAdminDomain.getDanhmuc().getMadm();

		LoaigiayHangDanhmuc loaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory.findByLoaiGiayHangDanhMuc(maLoaiGiay,
				maHang, maDanhmuc);

		if (loaigiayHangDanhmuc == null) {
			idLoaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory.getIdNext();

			LoaigiayHangDanhmuc loaigiayHangDanhmucADD = new LoaigiayHangDanhmuc();

			LoaigiayHangDanhmucPK loaigiayHangDanhmucPK = new LoaigiayHangDanhmucPK();
			loaigiayHangDanhmucPK.setMaloaigiay(maLoaiGiay);
			loaigiayHangDanhmucPK.setMahang(maHang);
			loaigiayHangDanhmucPK.setMadanhmuc(maDanhmuc);

			loaigiayHangDanhmucADD.setId(loaigiayHangDanhmucPK);
			loaigiayHangDanhmucReponsitory.save(loaigiayHangDanhmucADD);

		} else {
			idLoaigiayHangDanhmuc = loaigiayHangDanhmuc.getId().getMaLgiayHang();
		}

		Giay giay = giayReponsitory.findById(magiay).get();
		giay.setMaLgiayHang(idLoaigiayHangDanhmuc);
		giayReponsitory.save(giay);

	}

	@Override
	public ListSizeAdmin getAllGiaySizeMauOfGiay(String idGiay) {
		ListSizeAdmin listSizeAdmin = new ListSizeAdmin();
		List<SizeAdminDomain> sizeAdminDomains = new ArrayList<>();
		List<GiayMauSize> giayMauSizes = giaySizeMauReponsitory.getGiayMauSizeByMaGiay(idGiay);

		for (GiayMauSize giayMauSize : giayMauSizes) {
			SizeAdminDomain sizeAdminDomain = new SizeAdminDomain();
			sizeAdminDomain.converToDomain(giayMauSize.getSize());
			if (sizeAdminDomains.contains(sizeAdminDomain)) {
				continue;
			}
			List<Mausac> mausacs = mauSacReponsitory.getMauSacByIdGiayAndIdSize(idGiay, sizeAdminDomain.getMasize());
			sizeAdminDomain.setMausacs(convertToListMauSacDomain(mausacs, idGiay, sizeAdminDomain.getMasize()));
			sizeAdminDomains.add(sizeAdminDomain);
		}
		listSizeAdmin.setSizes(sizeAdminDomains);
		return listSizeAdmin;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addGiaySizeMauOfGiay(AddGiayMauSizeAdmin addGiayMauSizeAdmin) throws ThtShoesException {

		String magiay = addGiayMauSizeAdmin.getMagiay();
		String masize = addGiayMauSizeAdmin.getMasize();
		String mamau = addGiayMauSizeAdmin.getMamau();

		String idGiaySizeMau = giaySizeMauReponsitory.getIdByIdGiayIdSizeIdMau(magiay, masize, mamau);
		if (idGiaySizeMau != null) {
			throw new ThtShoesException("Giày đã có size và màu này");
		}

		int soluong = addGiayMauSizeAdmin.getSoluong();
		int idNextGiayMauSize = giaySizeMauReponsitory.getIdNext();

		GiayMauSize giayMauSize = new GiayMauSize();
		GiayMauSizePK giayMauSizePK = new GiayMauSizePK();
		giayMauSizePK.setMagiay(magiay);
		giayMauSizePK.setMasize(masize);
		giayMauSizePK.setMamau(mamau);
		giayMauSize.setId(giayMauSizePK);
		giayMauSize.setSoluong(soluong);
		giaySizeMauReponsitory.save(giayMauSize);

		SoluongGiay soluongGiay = new SoluongGiay();
		soluongGiay.setSoluongthem(soluong);
		soluongGiay.setIdGiaySizeMau(idNextGiayMauSize);
		soluongGiay.setMota("Thêm màu size mới");
		soLuongGiayReponsitory.save(soluongGiay);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateSoLuongGiaySizeMauOfGiay(SoLuongGiaySizeMau soLuongGiaySizeMau) throws ThtShoesException {

		GiayMauSize giayMauSize = giaySizeMauReponsitory.getGiayMauSizeById(String.valueOf(soLuongGiaySizeMau.getId()));
		int oldSoLuong = giayMauSize.getSoluong();
		int newSoLuong = soLuongGiaySizeMau.getSoluong();

		if (oldSoLuong != newSoLuong) {
			giaySizeMauReponsitory.updateSoLuong(soLuongGiaySizeMau.getId(), soLuongGiaySizeMau.getSoluong());
			SoluongGiay soluongGiay = new SoluongGiay();
			soluongGiay.setIdGiaySizeMau(giayMauSize.getId().getId());
			soluongGiay.setSoluongthem(newSoLuong - oldSoLuong);
			if (soluongGiay.getMota() != null) {
				soluongGiay.setMota(soLuongGiaySizeMau.getNote());
			} else {
				soluongGiay.setMota("Nhập thêm hàng mới");
			}
			soLuongGiayReponsitory.save(soluongGiay);
		} else {
			throw new ThtShoesException("Vui lòng nhập số lượng mới");
		}
	}

	@Override
	public void deleteGiaySizeMauOfGiay(int idGiaySizemau) throws ThtShoesException {
		int checkDonHang = giayDonHangReponsitory.countGiaySizeMauInGiayDonHangByMaGiaySizeMau(idGiaySizemau);
		if (checkDonHang > 0) {
			throw new ThtShoesException("Size và màu đã có trong đơn hàng");
		}
		giaySizeMauReponsitory.deleteById(idGiaySizemau);
	}

}
