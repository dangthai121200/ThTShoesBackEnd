package com.herokuapp.domain.khachhang;

import java.util.ArrayList;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;

public class GiayDomain extends AbstractsDomain<Giay> {

	private String magiay;
	private String chatlieu;
	private int gia;
	private String kieudang;
	private String mota;
	private String tengiay;
	private int trongluong;
	private String urlanh;
	private LoaiGiayDomain loaigiay = new LoaiGiayDomain();
	private List<BinhLuanDomain> binhluans = new ArrayList<>();
	private List<SizeDomain> sizes = new ArrayList<>();
	private List<HinhDomain> hinhs = new ArrayList<>();;
	private List<MauSacDomain> mausacs = new ArrayList<>();

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

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
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

	public LoaiGiayDomain getLoaigiay() {
		return loaigiay;
	}

	public void setLoaigiay(LoaiGiayDomain loaigiay) {
		this.loaigiay = loaigiay;
	}

	public List<BinhLuanDomain> getBinhluans() {
		return binhluans;
	}

	public void setBinhluans(List<BinhLuanDomain> binhluans) {
		this.binhluans = binhluans;
	}

	public List<SizeDomain> getSizes() {
		return sizes;
	}

	public void setSizes(List<SizeDomain> sizes) {
		this.sizes = sizes;
	}

	public List<HinhDomain> getHinhs() {
		return hinhs;
	}

	public void setHinhs(List<HinhDomain> hinhs) {
		this.hinhs = hinhs;
	}

	public List<MauSacDomain> getMausacs() {
		return mausacs;
	}

	public void setMausacs(List<MauSacDomain> mausacs) {
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
		this.urlanh = giay.getUrlanh();
		this.loaigiay.converToDomain(giay.getLoaigiay());

		giay.getBinhluans().forEach(binhluan -> {
			BinhLuanDomain binhLuanDomain = new BinhLuanDomain();
			binhLuanDomain.converToDomain(binhluan);
			this.binhluans.add(binhLuanDomain);
		});

		giay.getSizes().forEach(size -> {
			SizeDomain sizeDomain = new SizeDomain();
			sizeDomain.converToDomain(size);
			this.sizes.add(sizeDomain);
		});

		giay.getMausacs().forEach(mausac -> {
			MauSacDomain mauSacDomain = new MauSacDomain();
			mauSacDomain.converToDomain(mausac);
			this.mausacs.add(mauSacDomain);
		});

		giay.getHinhs().forEach(hinh -> {
			HinhDomain hinhDomain = new HinhDomain();
			hinhDomain.converToDomain(hinh);
			this.hinhs.add(hinhDomain);
		});
	}

	@Override
	public Giay converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
