package com.herokuapp.domain.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;

public class AddGiayAdminDomain extends AbstractsDomain<Giay> {
	private String magiay;
	private String chatlieu;
	private int gia;
	private String kieudang;
	private Date ngaythem;
	private String mota;
	private String tengiay;
	private int trongluong;
	private String urlanh;
	private int maLgiayHang;
	private Set<SizeMauAdmin> sizeMaus = new HashSet<>();

	public String getMagiay() {
		return magiay;
	}

	public void setMagiay(String magiay) {
		this.magiay = magiay;
	}

	public String getChatlieu() {
		return chatlieu;
	}

	public void setChatlieu(String chatlieu) {
		this.chatlieu = chatlieu;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getKieudang() {
		return kieudang;
	}

	public void setKieudang(String kieudang) {
		this.kieudang = kieudang;
	}

	public Date getNgaythem() {
		return ngaythem;
	}

	public void setNgaythem(Date ngaythem) {
		this.ngaythem = ngaythem;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTengiay() {
		return tengiay;
	}

	public void setTengiay(String tengiay) {
		this.tengiay = tengiay;
	}

	public int getTrongluong() {
		return trongluong;
	}

	public void setTrongluong(int trongluong) {
		this.trongluong = trongluong;
	}

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}


	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

	public Set<SizeMauAdmin> getSizeMaus() {
		return sizeMaus;
	}

	public void setSizeMaus(Set<SizeMauAdmin> sizeMaus) {
		this.sizeMaus = sizeMaus;
	}

	@Override
	public void converToDomain(Giay object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Giay converToEntity() {
		Giay giay = new Giay();
		giay.setTengiay(this.tengiay);
		giay.setChatlieu(this.chatlieu);
		giay.setGia(this.gia);
		giay.setKieudang(this.kieudang);
		giay.setTrongluong(this.trongluong);
		giay.setUrlanh(this.urlanh);
		if (this.mota != null) {
			giay.setMota(this.mota);
		}
		giay.setMaLgiayHang(this.maLgiayHang);
		return giay;
	}

}