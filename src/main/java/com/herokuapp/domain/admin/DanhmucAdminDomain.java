package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Danhmuc;

public class DanhmucAdminDomain extends AbstractsDomain<Danhmuc> {
	private String madm;

	private String tendanhmuc;

	public String getMadm() {
		return madm;
	}

	public void setMadm(String madm) {
		this.madm = madm;
	}

	public String getTendanhmuc() {
		return tendanhmuc;
	}

	public void setTendanhmuc(String tendanhmuc) {
		this.tendanhmuc = tendanhmuc;
	}

	@Override
	public void converToDomain(Danhmuc danhMuc) {
		this.madm = danhMuc.getMadanhmuc();
		this.tendanhmuc = danhMuc.getTendanhmuc();
	}

	@Override
	public Danhmuc converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
