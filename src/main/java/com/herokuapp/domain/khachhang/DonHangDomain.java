package com.herokuapp.domain.khachhang;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Donhang;
import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.enums.TinhTrang;

public class DonHangDomain extends AbstractsDomain<Donhang> {
	private String madon;
	private Date ngaytao;
	private String nguoinhan;
	private int soluong;
	private TinhTrang tinhtrang;
	private BigDecimal tonggia;
	private String makhuyenmai;
	private List<GiayDonhangDomain> giayDonhangs = new ArrayList<>();
	private List<PhukienDonhangDomain> phukienDonhangs = new ArrayList<>();

	public String getMadon() {
		return madon;
	}

	public void setMadon(String madon) {
		this.madon = madon;
	}

	public Date getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getNguoinhan() {
		return nguoinhan;
	}

	public void setNguoinhan(String nguoinhan) {
		this.nguoinhan = nguoinhan;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public TinhTrang getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(TinhTrang tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public BigDecimal getTonggia() {
		return tonggia;
	}

	public void setTonggia(BigDecimal tonggia) {
		this.tonggia = tonggia;
	}

	public String getMakhuyenmai() {
		return makhuyenmai;
	}

	public void setMakhuyenmai(String makhuyenmai) {
		this.makhuyenmai = makhuyenmai;
	}

	public List<GiayDonhangDomain> getGiayDonhangs() {
		if (this.giayDonhangs == null) {
			this.giayDonhangs = new ArrayList<>();
		}
		return giayDonhangs;
	}

	public void setGiayDonhangs(List<GiayDonhangDomain> giayDonhangs) {
		this.giayDonhangs = giayDonhangs;
	}

	public List<PhukienDonhangDomain> getPhukienDonhangs() {
		return phukienDonhangs;
	}

	public void setPhukienDonhangs(List<PhukienDonhangDomain> phukienDonhangs) {
		this.phukienDonhangs = phukienDonhangs;
	}

	@Override
	public void converToDomain(Donhang donhang) {
		this.madon = donhang.getMadon();
		this.ngaytao = donhang.getNgaytao();
		this.nguoinhan = donhang.getNguoinhan();
		this.soluong = donhang.getSoluong();
		this.tinhtrang = donhang.getTinhtrang();
		this.tonggia = donhang.getTonggia();

		if (donhang.getDskhuyenmai() != null) {
			this.makhuyenmai = donhang.getDskhuyenmai().getMakm();
		}

		if (donhang.getPhukienDonhangs() != null) {
			donhang.getPhukienDonhangs().forEach(phukienDonhang -> {
				PhukienDonhangDomain phukienDonhangDomain = new PhukienDonhangDomain();
				phukienDonhangDomain.converToDomain(phukienDonhang);
				phukienDonhangs.add(phukienDonhangDomain);
			});
		}
	}

	@Override
	public Donhang converToEntity() {
		return null;
	}

	public void addGiayDonHang(GiayDonhangDomain giayDonhangDomain) {
		this.giayDonhangs.add(giayDonhangDomain);
	}

	public void addGiayDonHang(GiayDonhang giayDonhang) {
		GiayDonhangDomain giayDonhangDomain = new GiayDonhangDomain();
		giayDonhangDomain.converToDomain(giayDonhang);
		this.giayDonhangs.add(giayDonhangDomain);
	}
}
