package com.herokuapp.domain.common;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.enums.Quyen;

public class TaiKhoanDomain extends AbstractsDomain<Taikhoan> {

	private String manguoidung;
	private String email;
	private String username;
	private String password;

	private Quyen quyen;
	private byte tinhtrang = 0;

	public TaiKhoanDomain() {
	}

	public String getManguoidung() {
		return manguoidung;
	}

	public void setManguoidung(String manguoidung) {
		this.manguoidung = manguoidung;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public byte getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(byte tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	@Override
	public void converToDomain(Taikhoan taikhoan) {
		this.manguoidung = taikhoan.getManguoidung();
		this.manguoidung = taikhoan.getEmail();
		this.manguoidung = taikhoan.getUsername();
	}

	@Override
	public Taikhoan converToEntity() {
		Taikhoan taikhoan = new Taikhoan();
		taikhoan.setManguoidung(this.manguoidung);
		taikhoan.setEmail(this.email);
		taikhoan.setPassword(password);
		taikhoan.setUsername(this.username);
		taikhoan.setQuyen(this.quyen);
		taikhoan.setTinhtrang(this.tinhtrang);
		return taikhoan;
	}

}
