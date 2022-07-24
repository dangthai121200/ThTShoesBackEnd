package com.herokuapp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.herokuapp.enums.TinhTrang;

/**
 * The persistent class for the donhang database table.
 * 
 */
@Entity
@Table(name = "donhang")
@NamedQuery(name = "Donhang.findAll", query = "SELECT d FROM Donhang d")
public class Donhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 10)
	private String madon;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;

	@Column(nullable = false, length = 50)
	private String nguoinhan;

	@Column(nullable = false)
	private int soluong;

	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private TinhTrang tinhtrang;

	@Column(nullable = false, precision = 10, scale = 2)
	private BigDecimal tonggia;

	@Lob
	@Column(nullable = false)
	private String diachi;

	@Lob
	private String ghichu;

	// bi-directional many-to-one association to Dskhuyenmai
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "makm")
	private Dskhuyenmai dskhuyenmai;

	// bi-directional many-to-one association to Khachhang
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "makh")
	private Khachhang khachhang;

	// bi-directional many-to-one association to Khachvanglai
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "makhvl")
	private Khachvanglai khachvanglai;

	// bi-directional many-to-one association to GiayDonhang
	@OneToMany(mappedBy = "donhang", fetch = FetchType.LAZY)
	private List<GiayDonhang> giayDonhangs;

	// bi-directional many-to-many association to Nhanvien
	@ManyToMany(mappedBy = "donhangs", fetch = FetchType.LAZY)
	private List<Nhanvien> nhanviens;

	// bi-directional many-to-one association to PhukienDonhang
	@OneToMany(mappedBy = "donhang", fetch = FetchType.LAZY)
	private List<PhukienDonhang> phukienDonhangs = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maloaithanhtoan")
	private Phuongthucthanhtoan phuongthucthanhtoan;

	public Donhang() {
		this.madon = "";
		this.ngaytao = new Date();
		this.tinhtrang = TinhTrang.CHODUYET;
	}

	public String getMadon() {
		return this.madon;
	}

	public void setMadon(String madon) {
		this.madon = madon;
	}

	public Date getNgaytao() {
		return this.ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getNguoinhan() {
		return this.nguoinhan;
	}

	public void setNguoinhan(String nguoinhan) {
		this.nguoinhan = nguoinhan;
	}

	public int getSoluong() {
		return this.soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public TinhTrang getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(TinhTrang tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public BigDecimal getTonggia() {
		return this.tonggia;
	}

	public void setTonggia(BigDecimal tonggia) {
		this.tonggia = tonggia;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Dskhuyenmai getDskhuyenmai() {
		return this.dskhuyenmai;
	}

	public void setDskhuyenmai(Dskhuyenmai dskhuyenmai) {
		this.dskhuyenmai = dskhuyenmai;
	}

	public Khachhang getKhachhang() {
		return this.khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public Khachvanglai getKhachvanglai() {
		return this.khachvanglai;
	}

	public void setKhachvanglai(Khachvanglai khachvanglai) {
		this.khachvanglai = khachvanglai;
	}

	public List<GiayDonhang> getGiayDonhangs() {
		return this.giayDonhangs;
	}

	public void setGiayDonhangs(List<GiayDonhang> giayDonhangs) {
		this.giayDonhangs = giayDonhangs;
	}

	public GiayDonhang addGiayDonhang(GiayDonhang giayDonhang) {
		getGiayDonhangs().add(giayDonhang);
		giayDonhang.setDonhang(this);

		return giayDonhang;
	}

	public GiayDonhang removeGiayDonhang(GiayDonhang giayDonhang) {
		getGiayDonhangs().remove(giayDonhang);
		giayDonhang.setDonhang(null);

		return giayDonhang;
	}

	public List<Nhanvien> getNhanviens() {
		if (this.nhanviens == null) {
			this.nhanviens = new ArrayList<>();
		}
		return this.nhanviens;
	}

	public void setNhanviens(List<Nhanvien> nhanviens) {
		this.nhanviens = nhanviens;
	}

	public List<PhukienDonhang> getPhukienDonhangs() {
		return this.phukienDonhangs;
	}

	public void setPhukienDonhangs(List<PhukienDonhang> phukienDonhangs) {
		this.phukienDonhangs = phukienDonhangs;
	}

	public PhukienDonhang addPhukienDonhang(PhukienDonhang phukienDonhang) {
		getPhukienDonhangs().add(phukienDonhang);
		phukienDonhang.setDonhang(this);

		return phukienDonhang;
	}

	public PhukienDonhang removePhukienDonhang(PhukienDonhang phukienDonhang) {
		getPhukienDonhangs().remove(phukienDonhang);
		phukienDonhang.setDonhang(null);

		return phukienDonhang;
	}

	public Phuongthucthanhtoan getPhuongthucthanhtoan() {
		if (this.phuongthucthanhtoan == null) {
			this.phuongthucthanhtoan = new Phuongthucthanhtoan();
		}
		return phuongthucthanhtoan;
	}

	public void setPhuongthucthanhtoan(Phuongthucthanhtoan phuongthucthanhtoan) {
		this.phuongthucthanhtoan = phuongthucthanhtoan;
	}

}