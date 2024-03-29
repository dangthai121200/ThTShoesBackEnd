package com.herokuapp.domain.admin;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Danhmuc;
import com.herokuapp.util.ThtShoesMess;

public class DanhmucAdminDomain extends AbstractsDomain<Danhmuc> {
	
	private String madm;
	
	@Length(max = 20, message = ThtShoesMess.MAX_LENGHT + "của tendanhmuc là 20")
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
