package com.herokuapp.domain.admin;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Giay;
import com.herokuapp.util.ThtShoesMess;

public class AddGiayAdminDomain extends AbstractsDomain<Giay> {

	private String magiay;

	@NotEmpty(message = ThtShoesMess.GIAY_CHAT_LIEU)
	@Length(max = 40, message = ThtShoesMess.MAX_LENGHT + "của chất liệu là 40")
	private String chatlieu;

	@NotNull(message = ThtShoesMess.GIAY_GIA)
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "của gia là 0")
	@Max(value = 99999999999L, message = ThtShoesMess.MAX_NUMBER + "của gia là 99999999999")
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

	@NotEmpty(message = ThtShoesMess.MA_LOAI_GIAY)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của maLoaiGiay là 10")
	private String maLoaiGiay;

	@NotEmpty(message = ThtShoesMess.MA_HANG)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của maHang là 10")
	private String maHang;

	@NotEmpty(message = ThtShoesMess.MA_DANH_MUC)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của maDanhMuc là 10")
	private String maDanhMuc;

	@Valid
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

	public Set<SizeMauAdmin> getSizeMaus() {
		return sizeMaus;
	}

	public void setSizeMaus(Set<SizeMauAdmin> sizeMaus) {
		this.sizeMaus = sizeMaus;
	}

	public String getMaLoaiGiay() {
		return maLoaiGiay;
	}

	public void setMaLoaiGiay(String maLoaiGiay) {
		this.maLoaiGiay = maLoaiGiay;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
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
		return giay;
	}

}
