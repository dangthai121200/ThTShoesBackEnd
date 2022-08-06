package com.herokuapp.domain.admin;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class DoanhThuAdmin implements RowMapper<DoanhThuAdmin> {

	private Date thoigian;
	private BigDecimal tongdoanhthu;

	public DoanhThuAdmin() {

	}

	public DoanhThuAdmin(Date thoigian, BigDecimal tongdoanhthu) {
		this.thoigian = thoigian;
		this.tongdoanhthu = tongdoanhthu;
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

	@Override
	public DoanhThuAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new DoanhThuAdmin(rs.getDate("thoigian"), rs.getBigDecimal("tong"));
	}

}
