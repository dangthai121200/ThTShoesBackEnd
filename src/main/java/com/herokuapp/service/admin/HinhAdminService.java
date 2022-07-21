package com.herokuapp.service.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.herokuapp.domain.admin.FormUploadImageProduct;

public interface HinhAdminService {
	List<String> uploadImage(FormUploadImageProduct formUploadImage)
			throws JsonMappingException, JsonProcessingException;

	String setAvatarForGiay(String magiay, MultipartFile image) throws JsonMappingException, JsonProcessingException;

	String setAvatarForPhuKien(String maphukien, MultipartFile image)
			throws JsonMappingException, JsonProcessingException;

	String setAvatarForKhuyenMai(String makm, MultipartFile image) throws JsonMappingException, JsonProcessingException;
}
