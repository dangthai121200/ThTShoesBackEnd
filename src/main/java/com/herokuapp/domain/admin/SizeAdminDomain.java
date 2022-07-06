package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Size;

public class SizeAdminDomain extends AbstractsDomain<Size> {

	private String masize;
	private String tensize;

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
