package com.herokuapp.domain.common;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.herokuapp.util.Regex;
import com.herokuapp.util.ThtShoesMess;

public class ChangePasswordDomain {

	@NotEmpty(message = "Thiếu mã người không được để trống")
	private String manguoidung;

	@Pattern(regexp = Regex.PASSWORD, message = ThtShoesMess.PASSWORD)
	private String oldPassowrd;

	@Pattern(regexp = Regex.PASSWORD, message = ThtShoesMess.PASSWORD)
	private String newPassword;

	public ChangePasswordDomain() {

	}

	public String getManguoidung() {
		return manguoidung;
	}

	public void setManguoidung(String manguoidung) {
		this.manguoidung = manguoidung;
	}

	public String getOldPassowrd() {
		return oldPassowrd;
	}

	public void setOldPassowrd(String oldPassowrd) {
		this.oldPassowrd = oldPassowrd;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
