package com.herokuapp.domain.admin;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Phukien;
import com.herokuapp.util.ThtShoesMess;

public class AddPhuKienAdmin extends AbstractsDomain<Phukien> {

	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của tên mapk là 10")
	private String mapk;

	@NotEmpty(message = ThtShoesMess.PHU_KIEN_TEN)
	@Length(max = 30, message = ThtShoesMess.MAX_LENGHT + "của tên tenpk là 30")
	private String tenpk;

	@NotNull(message = ThtShoesMess.PHU_KIEN_GIA)
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "của gia là 0")
	@Max(value = 99999999999L, message = ThtShoesMess.MAX_NUMBER + "của gia là 99999999999")
	private int gia;

	@NotNull(message = ThtShoesMess.PHU_KIEN_SO_LUONG)
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "của soluong là 0")
	@Max(value = 99999999999L, message = ThtShoesMess.MAX_NUMBER + "của soluong là 99999999999")
	private int soluong;

	@NotEmpty(message = ThtShoesMess.MA_LOAI_PHU_KIEN)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của tên maLoaiPk là 10")
	private String maLoaiPk;

	private String mota;

	private String motaSoLuong;

	public AddPhuKienAdmin() {

	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getTenpk() {
		return tenpk;
	}

	public void setTenpk(String tenpk) {
		this.tenpk = tenpk;
	}

	public String getMaLoaiPk() {
		return maLoaiPk;
	}

	public void setMaLoaiPk(String maLoaiPk) {
		this.maLoaiPk = maLoaiPk;
	}

	public String getMapk() {
		return mapk;
	}

	public void setMapk(String mapk) {
		this.mapk = mapk;
	}

	@Override
	public void converToDomain(Phukien object) {
		// TODO Auto-generated method stub

	}

	public String getMotaSoLuong() {
		return motaSoLuong;
	}

	public void setMotaSoLuong(String motaSoLuong) {
		this.motaSoLuong = motaSoLuong;
	}

	@Override
	public Phukien converToEntity() {
		Phukien phukien = new Phukien();
		phukien.setTenpk(this.tenpk);
		phukien.setGia(this.gia);
		phukien.setSoluong(this.soluong);
		phukien.setMota(this.mota);
		return phukien;
	}

}
