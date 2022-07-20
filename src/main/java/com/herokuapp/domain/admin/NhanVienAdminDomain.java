package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Nhanvien;

public class NhanVienAdminDomain extends AbstractsDomain<Nhanvien> {

	private String manv;
	private String diachi;
	private String ho;
	private int sdt;
	private String ten;
	private TaiKhoanAdminDomain taiKhoan = new TaiKhoanAdminDomain();

	public NhanVienAdminDomain() {

	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public TaiKhoanAdminDomain getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoanAdminDomain taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public void converToDomain(Nhanvien nhanvien) {
		manv = nhanvien.getManv();
		ho = nhanvien.getHo();
		ten = nhanvien.getTen();
		diachi = nhanvien.getDiachi();
		sdt = nhanvien.getSdt();
	}

	@Override
	public Nhanvien converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
