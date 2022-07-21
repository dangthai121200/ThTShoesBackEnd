package com.herokuapp.domain.admin;

import java.util.Objects;

public class SizeMauAdmin {

	private String masize;
	private String mamau;
	private int soluong;

	public String getMasize() {
		return masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public String getMamau() {
		return mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mamau, masize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeMauAdmin other = (SizeMauAdmin) obj;
		return Objects.equals(mamau, other.mamau) && Objects.equals(masize, other.masize);
	}

}
