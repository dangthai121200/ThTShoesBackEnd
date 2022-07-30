package com.herokuapp.domain.admin;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.util.ThtShoesMess;

public class TraLoiBinhLuanAdminDomain {

	@NotEmpty(message = ThtShoesMess.BINH_LUAN_MA)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của mã bình luận trả lời là 10")
	private String mablTraloi;

	@NotEmpty(message = ThtShoesMess.BINH_LUAN)
	private String mota;

	public TraLoiBinhLuanAdminDomain() {

	}

	public String getMablTraloi() {
		return mablTraloi;
	}

	public void setMablTraloi(String mablTraloi) {
		this.mablTraloi = mablTraloi;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

}
