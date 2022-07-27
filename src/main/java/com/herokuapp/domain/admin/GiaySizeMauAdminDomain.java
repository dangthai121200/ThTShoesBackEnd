package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.GiayMauSize;

public class GiaySizeMauAdminDomain extends AbstractsDomain<GiayMauSize> {
	private int id;
	private SizeAdminDomain size = new SizeAdminDomain();
	private MauSacAdminDomain mausac = new MauSacAdminDomain();
	private int soluong;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SizeAdminDomain getSize() {
		return size;
	}

	public void setSize(SizeAdminDomain size) {
		this.size = size;
	}

	public MauSacAdminDomain getMausac() {
		return mausac;
	}

	public void setMausac(MauSacAdminDomain mausac) {
		this.mausac = mausac;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public void converToDomain(GiayMauSize giayMauSize) {
		this.id = giayMauSize.getId().getId();
		this.size.converToDomain(giayMauSize.getSize());
		this.mausac.converToDomain(giayMauSize.getMausac());
		this.soluong = giayMauSize.getSoluong();
	}

	@Override
	public GiayMauSize converToEntity() {
		return null;
	}
}
