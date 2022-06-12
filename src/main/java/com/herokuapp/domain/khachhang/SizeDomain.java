package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Size;

public class SizeDomain extends AbstractsDomain<Size> {

	private String masize;

	private String tensize;

	public SizeDomain() {
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
		// TODO Auto-generated method stub
		return null;
	}

}
