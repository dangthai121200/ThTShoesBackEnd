package com.herokuapp.domain.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;

public class GiayAdminDomain extends AbstractsDomain<Giay> {

	private String magiay;
	private String chatlieu;
	private int gia;
	private String kieudang;
	private Date ngaythem;
	private String mota;
	private String tengiay;
	private int trongluong;
	private String urlanh;
	private int soluong;
	private int maLgiayHang;
	private List<SizeAdminDomain> sizes = new ArrayList<>();
	private List<HinhAdminDomain> hinhs = new ArrayList<>();
	private List<MauSacAdminDomain> mausacs = new ArrayList<>();

	public GiayAdminDomain() {
		super();
	}

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

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

	public List<SizeAdminDomain> getSizes() {
		return sizes;
	}

	public void setSizes(List<SizeAdminDomain> sizes) {
		this.sizes = sizes;
	}

	public List<HinhAdminDomain> getHinhs() {
		return hinhs;
	}

	public void setHinhs(List<HinhAdminDomain> hinhs) {
		this.hinhs = hinhs;
	}

	public List<MauSacAdminDomain> getMausacs() {
		return mausacs;
	}

	public void setMausacs(List<MauSacAdminDomain> mausacs) {
		this.mausacs = mausacs;
	}

	@Override
	public void converToDomain(Giay giay) {

		this.magiay = giay.getMagiay();
		this.chatlieu = giay.getChatlieu();
		this.gia = giay.getGia();
		this.kieudang = giay.getKieudang();
		this.mota = giay.getMota();
		this.tengiay = giay.getTengiay();
		this.trongluong = giay.getTrongluong();
		this.soluong = giay.getSoluong();
		this.urlanh = giay.getUrlanh();
		this.ngaythem = giay.getNgaythem();
	}

	@Override
	public Giay converToEntity() {
		Giay giay = new Giay();
		giay.setTengiay(this.tengiay);
		giay.setChatlieu(this.chatlieu);
		giay.setGia(this.gia);
		giay.setKieudang(this.kieudang);
		giay.setTrongluong(this.trongluong);
		giay.setSoluong(this.soluong);
		giay.setUrlanh(this.urlanh);
		if (this.mota != null) {
			giay.setMota(this.mota);
		}
		giay.setMaLgiayHang(this.maLgiayHang);
		return giay;
	}

}
