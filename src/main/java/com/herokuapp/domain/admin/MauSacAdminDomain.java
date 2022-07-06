package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Mausac;

public class MauSacAdminDomain extends AbstractsDomain<Mausac> {

	private String mamau;
	private String tenmau;

	public MauSacAdminDomain() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public void converToDomain(Mausac mausac) {
		this.mamau = mausac.getMamau();
		this.tenmau = mausac.getTenmau();

	}

	@Override
	public Mausac converToEntity() {
		Mausac mausac = new Mausac();
		mausac.setTenmau(this.tenmau);
		return mausac;
	}

}
