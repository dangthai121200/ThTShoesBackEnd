package com.herokuapp.domain.admin;

import java.math.BigDecimal;
import java.util.Date;

public class DoanhThuAdmin {

	private Date thoigian;
	private BigDecimal tongdoanhthu;

	public DoanhThuAdmin() {

	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public BigDecimal getTongdoanhthu() {
		return tongdoanhthu;
	}

	public void setTongdoanhthu(BigDecimal tongdoanhthu) {
		this.tongdoanhthu = tongdoanhthu;
	}

}
