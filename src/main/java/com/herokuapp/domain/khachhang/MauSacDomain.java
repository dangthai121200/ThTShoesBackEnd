package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Mausac;

public class MauSacDomain extends AbstractsDomain<Mausac> {

	private String mamau;

	private String tenmau;

	private int soluong;

	public MauSacDomain() {
	}

	public String getMamau() {
		return mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public String getTenmau() {
		return tenmau;
	}

	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public void converToDomain(Mausac mausac) {
		this.mamau = mausac.getMamau();
		this.tenmau = mausac.getTenmau();

	}

	@Override
	public Mausac converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
