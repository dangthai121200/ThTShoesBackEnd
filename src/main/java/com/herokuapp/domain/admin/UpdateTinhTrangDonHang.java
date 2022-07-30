package com.herokuapp.domain.admin;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.enums.TinhTrang;
import com.herokuapp.util.ThtShoesMess;

public class UpdateTinhTrangDonHang {

	@NotEmpty(message = ThtShoesMess.DON_HANG_MA)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "mã đơn hàng là 10")
	private String madonhang;

	private TinhTrang tinhTrang;

	public String getMadonhang() {
		return madonhang;
	}

	public void setMadonhang(String madonhang) {
		this.madonhang = madonhang;
	}

	public TinhTrang getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(TinhTrang tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

}
