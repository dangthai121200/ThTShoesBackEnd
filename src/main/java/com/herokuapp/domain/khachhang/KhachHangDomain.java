package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.Convert;
import com.herokuapp.entity.Khachhang;

public class KhachHangDomain extends Convert<Khachhang> {
	private String makh;
	private String diachi;
	private String ho;
	private int sdt;
	private String ten;

	public KhachHangDomain() {
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
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

	@Override
	public void converToDomain(Khachhang khachhang) {
		this.makh = khachhang.getMakh();
		this.ho = khachhang.getHo();
		this.ten = khachhang.getTen();
		this.diachi = (String) khachhang.getDiachi();
		this.sdt = khachhang.getSdt();
	}

	@Override
	public Khachhang converToEntity() {
		Khachhang khachang = new Khachhang();
		khachang.setMakh(this.makh);
		khachang.setHo(this.ho);
		khachang.setTen(this.ten);
		khachang.setDiachi(this.diachi);
		khachang.setSdt(this.sdt);
		return khachang;
	}

}
