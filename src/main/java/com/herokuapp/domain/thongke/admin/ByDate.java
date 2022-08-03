package com.herokuapp.domain.thongke.admin;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.herokuapp.util.ThtShoesMess;

public class ByDate {
	
	@NotNull(message = ThtShoesMess.THONG_KE_NGAY_BD)
	private Date ngayBd;
	
	@NotNull(message = ThtShoesMess.THONG_KE_NGAY_KT)
	private Date ngayKt;

	public Date getNgayBd() {
		return ngayBd;
	}

	public void setNgayBd(Date ngayBd) {
		this.ngayBd = ngayBd;
	}

	public Date getNgayKt() {
		return ngayKt;
	}

	public void setNgayKt(Date ngayKt) {
		this.ngayKt = ngayKt;
	}

}
