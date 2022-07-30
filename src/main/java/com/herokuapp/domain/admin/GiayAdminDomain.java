package com.herokuapp.domain.admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;
import com.herokuapp.util.ThtShoesMess;

public class GiayAdminDomain extends AbstractsDomain<Giay> {

	private String magiay;
	
	@NotEmpty(message = ThtShoesMess.GIAY_CHAT_LIEU)
	@Length(max = 40, message = ThtShoesMess.MAX_LENGHT + "của chất liệu là 40")
	private String chatlieu;
	
	@NotNull(message = ThtShoesMess.GIAY_GIA)
	@Max(value = 99999999999L)
	private int gia;
	
	@NotEmpty(message = ThtShoesMess.GIAY_KIEU_DANG)
	@Length(max = 30, message = ThtShoesMess.MAX_LENGHT + "của kiểu dáng là 30")
	private String kieudang;
	
	private Date ngaythem;
	
	private String mota;
	
	@NotEmpty(message = ThtShoesMess.GIAY_TEN)
	@Length(max = 50, message = ThtShoesMess.MAX_LENGHT + "của tên giày là 50")
	private String tengiay;
	
	@NotNull(message = ThtShoesMess.GIAY_TRONG_LUONG)
	private int trongluong;
	
	private String urlanh;
	
	private LoaiGiayAdminDomain loaigiay = new LoaiGiayAdminDomain();
	
	private HangAdminDomain hang = new HangAdminDomain();
	
	private DanhmucAdminDomain danhmuc = new DanhmucAdminDomain();
	
	private int maLgiayHang;
	
	private List<GiaySizeMauAdminDomain> giaySizeMau = new ArrayList<>();
	
	private List<HinhAdminDomain> hinhs = new ArrayList<>();
	
	private List<SoLuongGiayAdminDomain> soluonggiay = new ArrayList<>();

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

	public List<GiaySizeMauAdminDomain> getGiaySizeMau() {
		return giaySizeMau;
	}

	public void setGiaySizeMau(List<GiaySizeMauAdminDomain> giaySizeMau) {
		this.giaySizeMau = giaySizeMau;
	}

	public List<HinhAdminDomain> getHinhs() {
		return hinhs;
	}

	public void setHinhs(List<HinhAdminDomain> hinhs) {
		this.hinhs = hinhs;
	}

	public LoaiGiayAdminDomain getLoaigiay() {
		return loaigiay;
	}

	public void setLoaigiay(LoaiGiayAdminDomain loaigiay) {
		this.loaigiay = loaigiay;
	}

	public HangAdminDomain getHang() {
		return hang;
	}

	public void setHang(HangAdminDomain hang) {
		this.hang = hang;
	}

	public DanhmucAdminDomain getDanhmuc() {
		return danhmuc;
	}

	public void setDanhmuc(DanhmucAdminDomain danhmuc) {
		this.danhmuc = danhmuc;
	}

	public int getMaLgiayHang() {
		return maLgiayHang;
	}

	public void setMaLgiayHang(int maLgiayHang) {
		this.maLgiayHang = maLgiayHang;
	}

	public List<SoLuongGiayAdminDomain> getSoluonggiay() {
		return soluonggiay;
	}

	public void setSoluonggiay(List<SoLuongGiayAdminDomain> soluonggiay) {
		this.soluonggiay = soluonggiay;
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
		this.ngaythem = giay.getNgaythem();
		this.maLgiayHang = giay.getMaLgiayHang();
	}

	@Override
	public Giay converToEntity() {
		Giay giay = new Giay();
		giay.setMagiay(this.magiay);
		giay.setTengiay(this.tengiay);
		giay.setChatlieu(this.chatlieu);
		giay.setGia(this.gia);
		giay.setKieudang(this.kieudang);
		giay.setTrongluong(this.trongluong);
		if (this.mota != null) {
			giay.setMota(this.mota);
		}
		return giay;
	}

}
