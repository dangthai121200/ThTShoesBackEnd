package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Nhanvien;

public class NhanVienKhachHangDomain extends AbstractsDomain<Nhanvien> {

	private String manv;
	private String ho;
	private String ten;

	public NhanVienKhachHangDomain() {

	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Override
	public void converToDomain(Nhanvien nhanvien) {
		manv = nhanvien.getManv();
		ho = nhanvien.getHo();
		ten = nhanvien.getTen();
	}

	@Override
	public Nhanvien converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
