package com.herokuapp.domain.admin;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Size;

public class SizeAdminDomain extends AbstractsDomain<Size> {

	private String masize;
	private String tensize;
	private List<MauSacAdminDomain> mausacs = new ArrayList<>();

	public SizeAdminDomain() {
	}

	public String getMasize() {
		return masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public String getTensize() {
		return tensize;
	}

	public void setTensize(String tensize) {
		this.tensize = tensize;
	}

	public List<MauSacAdminDomain> getMausacs() {
		return mausacs;
	}

	public void setMausacs(List<MauSacAdminDomain> mausacs) {
		this.mausacs = mausacs;
	}

	@Override
	public boolean equals(Object obj) {
		SizeAdminDomain sizeAdminDomain = (SizeAdminDomain) obj;
		return this.masize.equals(sizeAdminDomain.getMasize()) ? true : false;
	}

	@Override
	public void converToDomain(Size size) {
		this.masize = size.getMasize();
		this.tensize = size.getTensize();
	}

	@Override
	public Size converToEntity() {
		Size size = new Size();
		size.setTensize(this.tensize);
		return size;
	}

}
