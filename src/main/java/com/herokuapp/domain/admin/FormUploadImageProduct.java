package com.herokuapp.domain.admin;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.herokuapp.util.ThtShoesMess;

public class FormUploadImageProduct {

	private List<MultipartFile> listImage;
	
	private MultipartFile avatar;
	
	@NotEmpty(message = ThtShoesMess.BINH_LUAN_MA)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của masp là 10")
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
