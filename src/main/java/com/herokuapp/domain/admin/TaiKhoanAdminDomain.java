package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.enums.Quyen;

public class TaiKhoanAdminDomain extends AbstractsDomain<Taikhoan> {

	private String username;
	private String email;
	private Quyen quyen;
	private Byte tinhtrang;

	public TaiKhoanAdminDomain() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Quyen getQuyen() {
		return quyen;
	}

	public void setQuyen(Quyen quyen) {
		this.quyen = quyen;
	}

	public Byte getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(Byte tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	@Override
	public void converToDomain(Taikhoan taikhoan) {
		this.username = taikhoan.getUsername();
		this.email = taikhoan.getEmail();
		this.quyen = taikhoan.getQuyen();
		this.tinhtrang = taikhoan.getTinhtrang();
	}

	@Override
	public Taikhoan converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
