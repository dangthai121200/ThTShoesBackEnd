package com.herokuapp.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.herokuapp.domain.admin.FormUploadImageProduct;
import com.herokuapp.service.admin.HinhAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.HINH)
public class HinhAdminController {

	@Autowired
	public HinhAdminService hinhAdminService;

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<String> uploadImage(@Valid FormUploadImageProduct formUploadImage)
			throws JsonMappingException, JsonProcessingException {
		return hinhAdminService.uploadImage(formUploadImage);
	}

	@PostMapping(value = URL.KHUYEN_MAI
			+ "/{makm}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> uploadImage(MultipartFile imageKm, @PathVariable(name = "makm") String makm)
			throws JsonMappingException, JsonProcessingException {
		try {
			String message = hinhAdminService.setAvatarForKhuyenMai(makm, imageKm);
			return ResponseEntity.ok(message);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm ảnh thất bại");
		}
	}
}
