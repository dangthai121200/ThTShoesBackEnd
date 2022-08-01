package com.herokuapp.domain.admin;

public class ThongBaoAdminDomain {
	
	private String tieude;
	private String noidung;

	public ThongBaoAdminDomain() {

	}

	public ThongBaoAdminDomain(String tieude, String noidung) {
		super();
		this.tieude = tieude;
		this.noidung = noidung;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	public String getNoidung() {
		return noidung;
	}

	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}

}
