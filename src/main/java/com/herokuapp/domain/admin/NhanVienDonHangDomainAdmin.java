package com.herokuapp.domain.admin;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.NhanvienDonhang;
import com.herokuapp.enums.HanhDong;

public class NhanVienDonHangDomainAdmin extends AbstractsDomain<NhanvienDonhang> {
	private int id;
	private String manv;
	private HanhDong hanhDong;

	public NhanVienDonHangDomainAdmin() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public HanhDong getHanhDong() {
		return hanhDong;
	}

	public void setHanhDong(HanhDong hanhDong) {
		this.hanhDong = hanhDong;
	}

	@Override
	public void converToDomain(NhanvienDonhang nhanvienDonhang) {
		this.id = nhanvienDonhang.getId().getIdNhanviendonhang();
		this.manv = nhanvienDonhang.getId().getManv();
		this.hanhDong = nhanvienDonhang.getHanhdong();
	}

	@Override
	public NhanvienDonhang converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
