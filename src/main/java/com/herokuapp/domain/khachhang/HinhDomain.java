package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Hinh;

public class HinhDomain extends AbstractsDomain<Hinh> {

	private String mahinh;

	private String duongdan;

	public HinhDomain() {

	}

	public String getMahinh() {
		return mahinh;
	}

	public void setMahinh(String mahinh) {
		this.mahinh = mahinh;
	}

	public String getDuongdan() {
		return duongdan;
	}

	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}

	@Override
	public void converToDomain(Hinh hinh) {
		this.mahinh = hinh.getMahinh();
		this.duongdan = hinh.getDuongdan();

	}

	@Override
	public Hinh converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
