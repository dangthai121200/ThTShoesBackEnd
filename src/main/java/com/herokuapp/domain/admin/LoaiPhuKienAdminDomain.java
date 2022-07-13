package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Loaiphukien;

public class LoaiPhuKienAdminDomain extends AbstractsDomain<Loaiphukien> {

	private String maLoaiPhuKien;
	private String tenLoaiPhuKien;

	public LoaiPhuKienAdminDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaLoaiPhuKien() {
		return maLoaiPhuKien;
	}

	public void setMaLoaiPhuKien(String maLoaiPhuKien) {
		this.maLoaiPhuKien = maLoaiPhuKien;
	}

	public String getTenLoaiPhuKien() {
		return tenLoaiPhuKien;
	}

	public void setTenLoaiPhuKien(String tenLoaiPhuKien) {
		this.tenLoaiPhuKien = tenLoaiPhuKien;
	}

	@Override
	public void converToDomain(Loaiphukien loaiphukien) {
		this.maLoaiPhuKien = loaiphukien.getMaloaipk();
		this.tenLoaiPhuKien = loaiphukien.getTenloai();
	}

	@Override
	public Loaiphukien converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
