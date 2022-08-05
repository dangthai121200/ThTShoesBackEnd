package com.herokuapp.service.admin;

import java.math.BigDecimal;

import com.herokuapp.domain.admin.DoanhThuAdmin;
import com.herokuapp.domain.admin.DonHangAdminDomain;
import com.herokuapp.domain.admin.list.ListCountDonHangAdmin;
import com.herokuapp.domain.admin.list.ListDonHangAdmin;
import com.herokuapp.domain.thongke.admin.ByDate;
import com.herokuapp.enums.TinhTrang;
import com.herokuapp.handleexception.ThtShoesException;

public interface DonHangAdminService {
	void updateStatusForDonhang(String madonghang, String manhanvien, TinhTrang tinhtrang) throws ThtShoesException;

	ListDonHangAdmin getAllDonHang();

	DonHangAdminDomain getDonHangById(String idDonhang);

	ListCountDonHangAdmin getDonHangByDate(ByDate byDate);

	DoanhThuAdmin thongKeDoanhThuByDate(ByDate byDate);
	
	BigDecimal thongKeDoanhThuAll();
	
	int countDongHangByStatus(TinhTrang tinhTrang);
}
