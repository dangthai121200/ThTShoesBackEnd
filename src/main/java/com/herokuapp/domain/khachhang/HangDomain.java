package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Hang;

public class HangDomain extends AbstractsDomain<Hang> {

	private String mahang;
	private String tenhang;

	public HangDomain() {
		super();

	}

	public String getMahang() {
		return mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	@Override
	public void converToDomain(Hang hang) {
		this.mahang = hang.getMahang();
		this.tenhang = hang.getTenhang();
	}

	@Override
	public Hang converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
