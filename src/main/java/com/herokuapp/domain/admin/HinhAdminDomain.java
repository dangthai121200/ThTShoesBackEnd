package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.Hinh;
import com.herokuapp.entity.Phukien;

public class HinhAdminDomain extends AbstractsDomain<Hinh> {
	private String mahinh;
	private String duongdan;
	private String magiay;
	private String maphukien;

	public HinhAdminDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMahinh() {
		return mahinh;
	}

	public void setMahinh(String mahinh) {
		this.mahinh = mahinh;
	}

	public String getDuongdan() {
		return duongdan;
	}

	public void setDuongdan(String duongdan) {
		this.duongdan = duongdan;
	}

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getMaphukien() {
		return maphukien;
	}

	public void setMaphukien(String maphukien) {
		this.maphukien = maphukien;
	}

	@Override
	public void converToDomain(Hinh hinh) {
		this.mahinh = hinh.getMahinh();
		this.duongdan = hinh.getDuongdan();
		if (hinh.getGiay() != null) {
			this.magiay = hinh.getGiay().getMagiay();
		} else if (hinh.getPhukien() != null) {
			this.magiay = hinh.getPhukien().getMapk();
		}

	}

	@Override
	public Hinh converToEntity() {
		Hinh hinh = new Hinh();

		hinh.setDuongdan(this.duongdan);
		if (this.magiay != null) {
			Giay giay = new Giay();
			giay.setMagiay(this.magiay);
			hinh.setGiay(giay);
		} else if (this.maphukien != null) {
			Phukien phukien = new Phukien();
			phukien.setMapk(this.maphukien);
			hinh.setPhukien(phukien);
		}
		return hinh;
	}

}
