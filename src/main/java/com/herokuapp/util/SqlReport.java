package com.herokuapp.util;

import com.herokuapp.enums.TinhTrang;

public class SqlReport {
	public static final String COUNT_DONHANG_BYDATE = "SELECT count(dh.madon) as tong ,DATE(dh.ngaytao) as thoigian FROM donhang dh"
			+ " where dh.ngaytao between ? and ? " + " group by DATE(dh.ngaytao) ";

	public static final String COUNT_DOANHTHU_BYDATE = " SELECT sum(dh.tonggia) as tong ,DATE(dh.ngaytao) as thoigian FROM donhang dh"
			+ " where dh.tinhtrang = ? and dh.ngaytao between ? and ? group by DATE(dh.ngaytao) ";
	
	public static final String THONG_KE_DOANHTHU_BYDATE = "SELECT sum(dh.tonggia) as doanhthu "
			+ " FROM donhang dh "
			+ " WHERE dh.tinhtrang = :tinhtrang AND dh.ngaytao BETWEEN :ngaybd AND :ngaykt ";
}
