package com.herokuapp.domain.khachhang;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;

public class GiayDomainGeneral extends AbstractsDomain<Giay> {

	private String magiay;
	private int gia;
	private String tengiay;
	private String urlanh;

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getTengiay() {
		return tengiay;
	}

	public void setTengiay(String tengiay) {
		this.tengiay = tengiay;
	}

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}

	@Override
	public void converToDomain(Giay giay) {
		this.magiay = giay.getMagiay();
		this.gia = giay.getGia();
		this.tengiay = giay.getTengiay();
		this.urlanh = giay.getUrlanh();
	}

	@Override
	public Giay converToEntity() {
		return null;
	}

}
