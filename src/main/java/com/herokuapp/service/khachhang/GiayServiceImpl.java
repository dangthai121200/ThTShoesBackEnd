package com.herokuapp.service.khachhang;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.khachhang.BinhLuanKhachHangDomain;
import com.herokuapp.domain.khachhang.GiayDomain;
import com.herokuapp.domain.khachhang.KhachHangDomain;
import com.herokuapp.domain.khachhang.MauSacDomain;
import com.herokuapp.domain.khachhang.NhanVienKhachHangDomain;
import com.herokuapp.domain.khachhang.SizeDomain;
import com.herokuapp.entity.Binhluan;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.GiayMauSize;
import com.herokuapp.entity.Mausac;
import com.herokuapp.reponsitory.BinhLuanReponsitory;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.GiaySizeMauReponsitory;
import com.herokuapp.reponsitory.MauSacReponsitory;

@Service
public class GiayServiceImpl implements GiayService {

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public LoaigiayHangDanhmucService loaigiayHangDanhmucService;

	@Autowired
	public MauSacReponsitory mauSacReponsitory;

	@Autowired
	public GiaySizeMauReponsitory giaySizeMauReponsitory;

	@Autowired
	public BinhLuanReponsitory binhLuanReponsitory;

	@Override
	public List<GiayDomain> getListLatest(int amount) {
		List<Giay> listGiayEntity = giayReponsitory.getListLatest(amount);
		return convertToListGiayDomain(listGiayEntity);
	}

	@Override
	public List<GiayDomain> getListBestSell(int amount) {
		List<Giay> listGiayEntity = giayReponsitory.getListBestSell(amount);
		return convertToListGiayDomain(listGiayEntity);
	}

	private List<GiayDomain> convertToListGiayDomain(List<Giay> giays) {
		List<GiayDomain> giayDomains = new ArrayList<>();
		for (Giay giay : giays) {
			GiayDomain giayDomain = new GiayDomain();
			giayDomain.converToDomain(giay);
			giayDomains.add(giayDomain);
		}
		return giayDomains;
	}

	@Override
	public List<GiayDomain> getAllGiay() {
		List<Giay> giayEntites = (List<Giay>) giayReponsitory.findAll();
		List<GiayDomain> giayDomains = new ArrayList<>();
		giayEntites.forEach(giay -> {
			GiayDomain giayDomain = new GiayDomain();
			giayDomain.converToDomain(giay);
			giayDomain.setLoaigiayHangDanhmuc(loaigiayHangDanhmucService.findByMaLgiayHang(giay.getMaLgiayHang()));
			giayDomains.add(giayDomain);
		});

		return giayDomains;
	}

	@Override
	public GiayDomain getGiayById(String idGiay) {

		// get info of giay
		Giay giay = giayReponsitory.findById(idGiay).get();
		GiayDomain giayDomain = new GiayDomain();
		List<SizeDomain> sizeDomains = new ArrayList<>();
		giayDomain.setLoaigiayHangDanhmuc(loaigiayHangDanhmucService.findByMaLgiayHang(giay.getMaLgiayHang()));
		giayDomain.converToDomain(giay);

		// get size and mausac of giay

		for (GiayMauSize giayMauSize : giay.getGiayMauSizes()) {
			SizeDomain sizeDomain = new SizeDomain();
			sizeDomain.converToDomain(giayMauSize.getSize());
			if (sizeDomains.contains(sizeDomain)) {
				continue;
			}
			List<Mausac> mausacs = mauSacReponsitory.getMauSacByIdGiayAndIdSize(giayDomain.getMagiay(),
					sizeDomain.getMasize());
			sizeDomain.setMausacs(convertToListMauSacDomain(mausacs, giayDomain.getMagiay(), sizeDomain.getMasize()));
			sizeDomains.add(sizeDomain);
		}
		giayDomain.setSizes(sizeDomains);

		// get binhluan of giay
		List<Binhluan> binhluans = binhLuanReponsitory.getAllBinhLuanByIdGiay(idGiay);
		List<BinhLuanKhachHangDomain> binhLuanKhachHangDomains = new ArrayList<>();

		for (Binhluan binhluan : binhluans) {
			BinhLuanKhachHangDomain binhLuanKhachHangDomain = new BinhLuanKhachHangDomain();
			binhLuanKhachHangDomain.converToDomain(binhluan);

			if (binhluan.getKhachhang() != null) {
				KhachHangDomain khachHangDomain = new KhachHangDomain();
				khachHangDomain.converToDomain(binhluan.getKhachhang());
				binhLuanKhachHangDomain.setKhachHangDomain(khachHangDomain);
			}

			// get response binhluan
			List<BinhLuanKhachHangDomain> binhLuanTraLois = new ArrayList<>();
			for (Binhluan binhLuanTraLoi : binhluan.getBinhluans()) {
				BinhLuanKhachHangDomain binhLuanTraLoiDoamin = new BinhLuanKhachHangDomain();
				binhLuanTraLoiDoamin.converToDomain(binhLuanTraLoi);
				NhanVienKhachHangDomain nhanVienKhachHangDomain = new NhanVienKhachHangDomain();
				nhanVienKhachHangDomain.converToDomain(binhLuanTraLoi.getNhanvien());
				binhLuanTraLoiDoamin.setNhanvien(nhanVienKhachHangDomain);
				binhLuanTraLois.add(binhLuanTraLoiDoamin);
			}
			binhLuanKhachHangDomain.setBinhluans(binhLuanTraLois);

			binhLuanKhachHangDomains.add(binhLuanKhachHangDomain);
		}

		giayDomain.setBinhluans(binhLuanKhachHangDomains);

		return giayDomain;
	}

	private List<MauSacDomain> convertToListMauSacDomain(List<Mausac> mausacs, String maGiay, String maSize) {
		List<MauSacDomain> mauSacDomains = new ArrayList<>();
		mausacs.forEach(mausac -> {
			MauSacDomain mauSacDomain = new MauSacDomain();
			int soluong = giaySizeMauReponsitory.getSoLuongByIdGiayIdSizeIdMau(maGiay, maSize, mausac.getMamau());
			if (soluong > 0) {
				mauSacDomain.converToDomain(mausac);
				mauSacDomain.setSoluong(soluong);
				mauSacDomains.add(mauSacDomain);
			}
		});
		return mauSacDomains;

	}

}
