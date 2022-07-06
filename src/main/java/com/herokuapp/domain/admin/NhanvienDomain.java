package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Nhanvien;

public class NhanvienDomain extends AbstractsDomain<Nhanvien> {
	private String manv;
	private String ho;
	private String ten;
	private String sdt;
	private String diachi;

	public NhanvienDomain() {
		super();

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

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public void converToDomain(Nhanvien object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Nhanvien converToEntity() {
		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setHo(this.ho);
		nhanvien.setTen(this.ten);
		nhanvien.setDiachi(this.diachi);
		nhanvien.setSdt(Integer.valueOf(this.sdt));
		return nhanvien;
	}

}
