package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Size;

public class SizeDomain extends AbstractsDomain<Size> {

	private String masize;

	private String tensize;

	private List<MauSacDomain> mausacs = new ArrayList<>();

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

	public List<MauSacDomain> getMausacs() {
		return mausacs;
	}

	public void setMausacs(List<MauSacDomain> mausacs) {
		this.mausacs = mausacs;
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

	@Override
	public boolean equals(Object obj) {
		SizeDomain sizeDomain = (SizeDomain) obj;
		return this.masize.equals(sizeDomain.getMasize()) ? true : false;
	}




	
	

}
