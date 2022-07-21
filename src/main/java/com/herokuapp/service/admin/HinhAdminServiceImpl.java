package com.herokuapp.service.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.domain.admin.FormUploadImageProduct;
import com.herokuapp.entity.Giay;
import com.herokuapp.entity.Hinh;
import com.herokuapp.reponsitory.GiayReponsitory;
import com.herokuapp.reponsitory.HinhReponsitory;
import com.herokuapp.reponsitory.PhuKienReponsitory;
import com.herokuapp.util.PrefixId;
import com.herokuapp.util.URL;

@Service
public class HinhAdminServiceImpl implements HinhAdminService {

	@Autowired
	public HinhReponsitory hinhReponsitory;

	@Autowired
	public GiayReponsitory giayReponsitory;

	@Autowired
	public PhuKienReponsitory kienReponsitory;

	@Transactional(noRollbackFor = Exception.class)
	public List<String> uploadImage(FormUploadImageProduct formUploadImage)
			throws JsonMappingException, JsonProcessingException {
		List<String> listUrlImage = new ArrayList<>();
		StringBuilder listError = new StringBuilder();
		if (formUploadImage.getMasp().contains(PrefixId.GIAY)) {
			String magiay = formUploadImage.getMasp();
			String urlImage = setAvatarForGiay(magiay, formUploadImage.getAvatar());
			listUrlImage.add(urlImage);
			for (int i = 0; i < formUploadImage.getListImage().size(); i++) {
				Hinh hinh = null;
				String body = "";
				try {
					body = uploadImageToImgbb(formUploadImage.getListImage().get(i), magiay).getBody();
				} catch (Exception ex) {
					ex.printStackTrace();
					listError.append(formUploadImage.getListImage().get(i).getName());
					continue;
				}
				urlImage = getDataFormJsonImage(body);
				hinhReponsitory.insertHinhOfGiay(urlImage, magiay);
				listUrlImage.add(urlImage);
			}
		}
		return listUrlImage;
	}

	public String setAvatarForGiay(String magiay, MultipartFile image)
			throws JsonMappingException, JsonProcessingException {
		String body = uploadImageToImgbb(image, magiay).getBody();
		String urlImage = getDataFormJsonImage(body);
		giayReponsitory.setAvatar(urlImage, magiay);
		return urlImage;
	}

	public String setAvatarForPhuKien(String maphukien, MultipartFile image)
			throws JsonMappingException, JsonProcessingException {
//		String body = uploadImageToImgbb(image, maphukien).getBody();
//		String urlImage = getDataFormJsonImage(body);
//
//		batdongsan.setHinhanh(urlImage);
		return null;
	}

	private String getDataFormJsonImage(String data) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(data);
		String urlImage = jsonNode.get("data").get("display_url").asText();
		return urlImage;
	}

	private ResponseEntity<String> uploadImageToImgbb(MultipartFile file, String nameImage) {
		RestOperations restOperations = new RestTemplate();
		MultiValueMap<String, Object> paramList = new LinkedMultiValueMap<String, Object>();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		File coverFile = convert(file, nameImage);
		paramList.add(URL.PARAM_IMAGE, new FileSystemResource(coverFile));
		paramList.add(URL.PARAM_KEY, URL.KEY_UPLOAD_IMAGE);
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(paramList,
				headers);
		ResponseEntity<String> result = restOperations.postForEntity(URL.API_UPLOAD_IMAGE, request, String.class);
		if (coverFile.exists()) {
			coverFile.delete();
		}
		return result;
	}

	private File convert(MultipartFile file, String nameImage) {
		File convFile = new File(nameImage);
		try {
			convFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(convFile);
			fos.write(file.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return convFile;
	}
}
