package com.herokuapp.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the donhang database table.
 * 
 */
@Entity
@Table(name="donhang")
@NamedQuery(name="Donhang.findAll", query="SELECT d FROM Donhang d")
public class Donhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=10)
	private String madon;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaytao;

	@Column(nullable=false, length=50)
	private String nguoinhan;

	@Column(nullable=false)
	private int soluong;

	@Column(nullable=false, length=1)
	private String tinhtrang;

	@Column(nullable=false)
	private int tonggia;

	//bi-directional many-to-one association to Dskhuyenmai
	@ManyToOne
	@JoinColumn(name="makm")
	private Dskhuyenmai dskhuyenmai;

	//bi-directional many-to-one association to Khachhang
	@ManyToOne
	@JoinColumn(name="makh")
	private Khachhang khachhang;

	//bi-directional many-to-one association to Khachvanglai
	@ManyToOne
	@JoinColumn(name="makhvl")
	private Khachvanglai khachvanglai;

	//bi-directional many-to-one association to GiayDonhang
	@OneToMany(mappedBy="donhang")
	private List<GiayDonhang> giayDonhangs;

	//bi-directional many-to-many association to Nhanvien
	@ManyToMany(mappedBy="donhangs")
	private List<Nhanvien> nhanviens;

	//bi-directional many-to-one association to PhukienDonhang
	@OneToMany(mappedBy="donhang")
	private List<PhukienDonhang> phukienDonhangs;

	public Donhang() {
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

	public String getTinhtrang() {
		return this.tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public int getTonggia() {
		return this.tonggia;
	}

	public void setTonggia(int tonggia) {
		this.tonggia = tonggia;
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

}