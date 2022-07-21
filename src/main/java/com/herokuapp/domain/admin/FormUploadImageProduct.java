package com.herokuapp.domain.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FormUploadImageProduct {

	private List<MultipartFile> listImage;
	private MultipartFile avatar;
	private String masp;

	public FormUploadImageProduct() {

	}

	public List<MultipartFile> getListImage() {
		return listImage;
	}

	public void setListImage(List<MultipartFile> listImage) {
		this.listImage = listImage;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public MultipartFile getAvatar() {
		return avatar;
	}

	public void setAvatar(MultipartFile avatar) {
		this.avatar = avatar;
	}

}
