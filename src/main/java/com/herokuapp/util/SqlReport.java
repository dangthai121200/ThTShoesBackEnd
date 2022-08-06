package com.herokuapp.util;

public class SqlReport {
	public static String COUNT_DONHANG_BYDATE = "SELECT count(dh.madon) as tong ,DATE(dh.ngaytao) as thoigian FROM donhang dh"
			+ " where dh.ngaytao between ? and ? " + " group by DATE(dh.ngaytao) ";

	public static String COUNT_DOANHTHU_BYDATE = " SELECT sum(dh.tonggia) as tong ,DATE(dh.ngaytao) as thoigian FROM donhang dh"
			+ " where dh.ngaytao between ? and ? group by DATE(dh.ngaytao) ";
}
