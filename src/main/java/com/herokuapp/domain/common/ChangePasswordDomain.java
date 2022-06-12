package com.herokuapp.domain.common;

public class ChangePasswordDomain {

	private String manguoidung;
	private String oldPassowrd;
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
