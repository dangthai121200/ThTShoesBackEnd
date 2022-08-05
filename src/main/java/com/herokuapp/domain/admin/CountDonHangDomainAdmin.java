package com.herokuapp.domain.admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

public class CountDonHangDomainAdmin implements RowMapper<CountDonHangDomainAdmin> {

	private Date thoigian;
	private int tong;

	public CountDonHangDomainAdmin() {

	}

	public CountDonHangDomainAdmin(Date thoigian, int tong) {
		super();
		this.thoigian = thoigian;
		this.tong = tong;
	}

	public Date getThoigian() {
		return thoigian;
	}

	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}

	public int getTong() {
		return tong;
	}

	public void setTong(int tong) {
		this.tong = tong;
	}

	@Override
	public CountDonHangDomainAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new CountDonHangDomainAdmin(rs.getDate("thoigian"), rs.getInt("tong"));
	}

}
