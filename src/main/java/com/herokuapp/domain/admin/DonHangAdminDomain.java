package com.herokuapp.domain.admin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Donhang;
import com.herokuapp.enums.TinhTrang;

public class DonHangAdminDomain extends AbstractsDomain<Donhang> {

	private String madon;
	private Date ngaytao;
	private String nguoinhan;
	private int soluong;
	private TinhTrang tinhtrang;
	private BigDecimal tonggia;
	private String makhuyenmai;

	private List<GiayDonhangAdminDomain> giayDonhangs = new ArrayList<>();
	private List<PhukienDonhangAdminDomain> phukienDonhangs = new ArrayList<>();
	private List<NhanVienDonHangDomainAdmin> actions = new ArrayList<>();

	private KhachVangLaiAdminDomain khachvanglai;
	private KhachHangAdminDomain khachHang;

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

	public List<GiayDonhangAdminDomain> getGiayDonhangs() {
		return giayDonhangs;
	}

	public void setGiayDonhangs(List<GiayDonhangAdminDomain> giayDonhangs) {
		this.giayDonhangs = giayDonhangs;
	}

	public List<PhukienDonhangAdminDomain> getPhukienDonhangs() {
		return phukienDonhangs;
	}

	public void setPhukienDonhangs(List<PhukienDonhangAdminDomain> phukienDonhangs) {
		this.phukienDonhangs = phukienDonhangs;
	}

	public KhachVangLaiAdminDomain getKhachvanglai() {
		return khachvanglai;
	}

	public void setKhachvanglai(KhachVangLaiAdminDomain khachvanglai) {
		this.khachvanglai = khachvanglai;
	}

	public KhachHangAdminDomain getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHangAdminDomain khachHang) {
		this.khachHang = khachHang;
	}

	public List<NhanVienDonHangDomainAdmin> getActions() {
		return actions;
	}

	public void setActions(List<NhanVienDonHangDomainAdmin> actions) {
		this.actions = actions;
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

		if (donhang.getKhachvanglai() != null) {
			this.khachvanglai = new KhachVangLaiAdminDomain();
			this.khachvanglai.converToDomain(donhang.getKhachvanglai());
		} else {
			this.khachHang = new KhachHangAdminDomain();
			this.khachHang.converToDomain(donhang.getKhachhang());
		}

	}

	@Override
	public Donhang converToEntity() {
		return null;
	}
}
