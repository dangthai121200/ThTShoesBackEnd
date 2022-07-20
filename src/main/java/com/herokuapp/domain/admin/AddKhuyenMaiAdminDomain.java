package com.herokuapp.domain.admin;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.entity.Nhanvien;

public class AddKhuyenMaiAdminDomain extends AbstractsDomain<Dskhuyenmai> {
	private String makm;
	private int soluong;
	private Date ngaybd = new Date();
	private Date ngaykt = new Date();
	private String mota;
	private int giatrigiam;
	private String manv;
	private String tieude;

	public AddKhuyenMaiAdminDomain() {

	}

	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Date getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getGiatrigiam() {
		return giatrigiam;
	}

	public void setGiatrigiam(int giatrigiam) {
		this.giatrigiam = giatrigiam;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	@Override
	public void converToDomain(Dskhuyenmai object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dskhuyenmai converToEntity() {
		Dskhuyenmai dskhuyenmai = new Dskhuyenmai();
		if (!StringUtils.isEmpty(this.makm)) {
			dskhuyenmai.setMakm(this.makm);
		}
		dskhuyenmai.setSoluong(this.soluong);
		dskhuyenmai.setNgaybd(this.ngaybd);
		dskhuyenmai.setNgaykt(this.ngaykt);
		dskhuyenmai.setMota(this.mota);
		dskhuyenmai.setGiatrigiam(this.giatrigiam);
		dskhuyenmai.setTieude(this.tieude);

		Nhanvien nhanvien = new Nhanvien();
		nhanvien.setManv(this.manv);
		dskhuyenmai.setNhanvien(nhanvien);
		return dskhuyenmai;
	}

}
