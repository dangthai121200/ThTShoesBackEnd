package com.herokuapp.domain.admin;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Loaigiay;
import com.herokuapp.util.ThtShoesMess;

public class LoaiGiayAdminDomain extends AbstractsDomain<Loaigiay> {

	private String maloaigiay;
	
	@Length(max = 50, message = ThtShoesMess.MAX_LENGHT + "của tenloai là 50")
	private String tenloai;

	public LoaiGiayAdminDomain() {
	}

	public String getMaloaigiay() {
		return maloaigiay;
	}

	public void setMaloaigiay(String maloaigiay) {
		this.maloaigiay = maloaigiay;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	@Override
	public void converToDomain(Loaigiay loaigiay) {
		this.maloaigiay = loaigiay.getMaloaigiay();
		this.tenloai = loaigiay.getTenloai();
	}

	@Override
	public Loaigiay converToEntity() {
		return null;
	}

}
