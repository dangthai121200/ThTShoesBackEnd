package com.herokuapp.domain.admin;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Dskhuyenmai;

public class KhuyenMaiAdminDomain extends AbstractsDomain<Dskhuyenmai> {

	private String makm;

	private int giatrigiam;

	private String mota;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaybd;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ngaykt;

	private int soluong;
	
	private String urlanh;
	
	private String tieude;

	public KhuyenMaiAdminDomain() {

	}

	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public int getGiatrigiam() {
		return giatrigiam;
	}

	public void setGiatrigiam(int giatrigiam) {
		this.giatrigiam = giatrigiam;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
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

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
	

	public String getUrlanh() {
		return urlanh;
	}

	public void setUrlanh(String urlanh) {
		this.urlanh = urlanh;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	@Override
	public void converToDomain(Dskhuyenmai khuyenmai) {
		this.makm = khuyenmai.getMakm();
		this.giatrigiam = khuyenmai.getGiatrigiam();
		this.mota = khuyenmai.getMota();
		this.ngaybd = khuyenmai.getNgaybd();
		this.ngaykt = khuyenmai.getNgaykt();
		this.soluong = khuyenmai.getSoluong();
		this.urlanh = khuyenmai.getUrlanh();
		this.tieude = khuyenmai.getTieude();

	}

	@Override
	public Dskhuyenmai converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}
}
