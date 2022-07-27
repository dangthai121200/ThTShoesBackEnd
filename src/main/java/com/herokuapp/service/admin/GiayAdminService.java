package com.herokuapp.service.admin;

import com.herokuapp.domain.admin.AddGiayAdminDomain;
import com.herokuapp.domain.admin.AddGiayMauSizeAdmin;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.LoaigiayHangDanhmucAdminDomain;
import com.herokuapp.domain.admin.SoLuongGiaySizeMau;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.admin.list.ListSizeAdmin;
import com.herokuapp.handleexception.ThtShoesException;

public interface GiayAdminService {
	ListGiayAdmin getAllGiay();

	String addGiay(AddGiayAdminDomain giayAdminDomain);

	GiayAdminDomain getGiayById(String idGiay);

	void deleteGiay(String magiay) throws ThtShoesException;

	void changeLGiayHangDanhMucOfGiay(String magiay, LoaigiayHangDanhmucAdminDomain loaigiayHangDanhmucAdminDomain)
			throws ThtShoesException;

	ListSizeAdmin getAllGiaySizeMauOfGiay(String idGiay);

	void addGiaySizeMauOfGiay(AddGiayMauSizeAdmin addGiayMauSizeAdmin) throws ThtShoesException;

	void updateSoLuongGiaySizeMauOfGiay(SoLuongGiaySizeMau soLuongGiaySizeMau) throws ThtShoesException;

	void deleteGiaySizeMauOfGiay(int idGiaySizemau) throws ThtShoesException;;
}
