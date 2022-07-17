package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Khachvanglai;

public class KhachVangLaiAdminDomain extends AbstractsDomain<Khachvanglai> {

	private String makh;
	private String ho;
	private String ten;
	private Long sdt;
	private String diachi;
	private String email;
	private String ghichu;
	

	public KhachVangLaiAdminDomain() {

	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
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

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Long getSdt() {
		return sdt;
	}

	public void setSdt(Long sdt) {
		this.sdt = sdt;
	}

	@Override
	public void converToDomain(Khachvanglai khachvanglai) {
		this.makh = khachvanglai.getMakh();
		this.ho = khachvanglai.getHo();
		this.ten = khachvanglai.getTen();
		this.sdt = khachvanglai.getSdt();
		this.diachi = khachvanglai.getDiachi();
		this.email = khachvanglai.getEmail();
		this.ghichu = khachvanglai.getGhichu();

	}

	@Override
	public Khachvanglai converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
