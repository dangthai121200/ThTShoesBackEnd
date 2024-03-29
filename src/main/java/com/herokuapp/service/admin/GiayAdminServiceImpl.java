package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.AddGiayAdminDomain;
import com.herokuapp.domain.admin.AddGiayMauSizeAdmin;
import com.herokuapp.domain.admin.DanhmucAdminDomain;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.GiaySizeMauAdminDomain;
import com.herokuapp.domain.admin.HangAdminDomain;
import com.herokuapp.domain.admin.HinhAdminDomain;
import com.herokuapp.domain.admin.LoaiGiayAdminDomain;
import com.herokuapp.domain.admin.LoaigiayHangDanhmucAdminDomain;
import com.herokuapp.domain.admin.MauSacAdminDomain;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.SizeMauAdmin;
import com.herokuapp.domain.admin.SoLuongGiayAdminDomain;
import com.herokuapp.domain.admin.SoLuongGiaySizeMau;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.admin.list.ListGiaySizeMauAdmin;
import com.herokuapp.domain.admin.list.ListSoLuongGiayAdmin;
import com.herokuapp.domain.thongke.admin.ByDate;
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
		giayAdminDomain.converToDomain(giay);

		// gte loaigiay, hang, danhmuc
		LoaigiayHangDanhmuc loaigiayHangDanhmuc = loaigiayHangDanhmucReponsitory
				.findByMaLgiayHang(giay.getMaLgiayHang());

		LoaiGiayAdminDomain loaiGiayAdminDomain = new LoaiGiayAdminDomain();
		loaiGiayAdminDomain.converToDomain(loaigiayHangDanhmuc.getLoaigiay());
		giayAdminDomain.setLoaigiay(loaiGiayAdminDomain);

		HangAdminDomain hangAdminDomain = new HangAdminDomain();
		hangAdminDomain.converToDomain(loaigiayHangDanhmuc.getHang());
		giayAdminDomain.setHang(hangAdminDomain);

		DanhmucAdminDomain danhmucAdminDomain = new DanhmucAdminDomain();
		danhmucAdminDomain.converToDomain(loaigiayHangDanhmuc.getDanhmuc());
		giayAdminDomain.setDanhmuc(danhmucAdminDomain);

		// get hinh
		giay.getHinhs().forEach(hinh -> {
			HinhAdminDomain hinhDomain = new HinhAdminDomain();
			hinhDomain.converToDomain(hinh);
			giayAdminDomain.getHinhs().add(hinhDomain);
		});

		// get size, mausac
		List<GiaySizeMauAdminDomain> giaySizeMauAdminDomains = new ArrayList<>();
		List<SoLuongGiayAdminDomain> soLuongGiayAdminDomains = new ArrayList<>();
		for (GiayMauSize giayMauSize : giay.getGiayMauSizes()) {

			GiaySizeMauAdminDomain sizeMauAdminDomain = new GiaySizeMauAdminDomain();
			sizeMauAdminDomain.converToDomain(giayMauSize);
			giaySizeMauAdminDomains.add(sizeMauAdminDomain);

			// get soluong add of giay
			List<SoluongGiay> soluongGiays = soLuongGiayReponsitory.findByidGiaySizeMau(giayMauSize.getId().getId());
			for (SoluongGiay soluongGiay : soluongGiays) {

				SoLuongGiayAdminDomain soLuongGiayAdminDomain = new SoLuongGiayAdminDomain();
				soLuongGiayAdminDomain.converToDomain(soluongGiay);

				SizeAdminDomain sizeAdminDomain = new SizeAdminDomain();
				sizeAdminDomain.converToDomain(giayMauSize.getSize());
				soLuongGiayAdminDomain.setSize(sizeAdminDomain);

				MauSacAdminDomain mauSacAdminDomain = new MauSacAdminDomain();
				mauSacAdminDomain.converToDomain(giayMauSize.getMausac());
				soLuongGiayAdminDomain.setMau(mauSacAdminDomain);

				soLuongGiayAdminDomains.add(soLuongGiayAdminDomain);
			}

		}
		giayAdminDomain.setGiaySizeMau(giaySizeMauAdminDomains);
		giayAdminDomain.setSoluonggiay(soLuongGiayAdminDomains);

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
	public ListGiaySizeMauAdmin getAllGiaySizeMauOfGiay(String idGiay) {
		ListGiaySizeMauAdmin listGiaySizeMauAdmin = new ListGiaySizeMauAdmin();
		List<GiaySizeMauAdminDomain> sizeMauAdminDomains = new ArrayList<>();
		List<GiayMauSize> giayMauSizes = giaySizeMauReponsitory.getGiayMauSizeByMaGiay(idGiay);

		for (GiayMauSize giayMauSize : giayMauSizes) {
			GiaySizeMauAdminDomain giaySizeMauAdminDomain = new GiaySizeMauAdminDomain();
			giaySizeMauAdminDomain.converToDomain(giayMauSize);
			sizeMauAdminDomains.add(giaySizeMauAdminDomain);
		}
		listGiaySizeMauAdmin.setGiaySizeMau(sizeMauAdminDomains);
		return listGiaySizeMauAdmin;
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

		if (giayMauSize == null) {
			throw new NoSuchElementException();
		}

		int oldSoLuong = giayMauSize.getSoluong();
		int newSoLuong = soLuongGiaySizeMau.getSoluong();

		if (oldSoLuong != newSoLuong) {
			giaySizeMauReponsitory.updateSoLuong(soLuongGiaySizeMau.getId(), soLuongGiaySizeMau.getSoluong());
			SoluongGiay soluongGiay = new SoluongGiay();
			soluongGiay.setIdGiaySizeMau(giayMauSize.getId().getId());
			soluongGiay.setSoluongthem(newSoLuong - oldSoLuong);
			if (soLuongGiaySizeMau.getNote() != null) {
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
	@Transactional(rollbackFor = Exception.class)
	public void deleteGiaySizeMauOfGiay(int idGiaySizemau) throws ThtShoesException {
		int checkDonHang = giayDonHangReponsitory.countGiaySizeMauInGiayDonHangByMaGiaySizeMau(idGiaySizemau);
		if (checkDonHang > 0) {
			throw new ThtShoesException("Size và màu đã có trong đơn hàng");
		}
		giaySizeMauReponsitory.deleteById(idGiaySizemau);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateGiay(GiayAdminDomain giayAdminDomain) {
		Giay giay = giayReponsitory.findById(giayAdminDomain.getMagiay()).get();
		giay.setTengiay(giayAdminDomain.getTengiay());
		giay.setChatlieu(giayAdminDomain.getChatlieu());
		giay.setGia(giayAdminDomain.getGia());
		giay.setKieudang(giayAdminDomain.getKieudang());
		giay.setTrongluong(giayAdminDomain.getTrongluong());
		if (giayAdminDomain.getMota() != null) {
			giay.setMota(giayAdminDomain.getMota());
		}

		giayReponsitory.save(giay);
	}

	@Override
	public ListGiayAdmin thongKeGiayByThoiGian(ByDate byDate) {

		ListGiayAdmin listGiay = new ListGiayAdmin();
		List<Giay> giayEntitys = giayReponsitory.findByngaythemBetween(byDate.getNgayBd(), byDate.getNgayKt());
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
	public ListSoLuongGiayAdmin getAllSoLuongGiayByIdGiay(String idGiay) {
		ListSoLuongGiayAdmin listSoLuongGiayAdmin = new ListSoLuongGiayAdmin();
		List<SoLuongGiayAdminDomain> soluonggiays = new ArrayList<>();

		// get all mau and size of giay
		List<GiayMauSize> giayMauSizes = giaySizeMauReponsitory.getGiayMauSizeByMaGiay(idGiay);

		// convert to list id giay mau size
		List<Integer> idGiayMauSize = convertToListIdGiayMauSizeString(giayMauSizes);

		// get all list soluonggiay of giay size mau
		List<SoluongGiay> soluongGiays = soLuongGiayReponsitory.findByidGiaySizeMauIn(idGiayMauSize);

		for (SoluongGiay soluongGiay : soluongGiays) {
			SoLuongGiayAdminDomain soLuongGiayAdminDomain = new SoLuongGiayAdminDomain();
			soLuongGiayAdminDomain.converToDomain(soluongGiay);
			soluonggiays.add(soLuongGiayAdminDomain);
		}
		listSoLuongGiayAdmin.setSoluonggiays(soluonggiays);
		return listSoLuongGiayAdmin;
	}

	private List<Integer> convertToListIdGiayMauSizeString(List<GiayMauSize> giayMauSizes) {
		List<Integer> listId = new ArrayList<>();
		for (GiayMauSize giayMauSize : giayMauSizes) {
			listId.add(giayMauSize.getId().getId());
		}
		return listId;
	}

}
