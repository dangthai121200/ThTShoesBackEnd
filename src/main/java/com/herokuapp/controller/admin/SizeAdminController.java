package com.herokuapp.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.AddSizeAdmin;
import com.herokuapp.domain.admin.list.ListSizeAdmin;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.SizeAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.SIZE)
public class SizeAdminController {

	@Autowired
	public SizeAdminService sizeAdminService;

	@GetMapping
	public ListSizeAdmin getAllSize() {
		ListSizeAdmin listSizeAdmin = sizeAdminService.getAllSize();
		return listSizeAdmin;
	}

	@PostMapping
	public ResponseEntity<String> addSize(@RequestBody @Valid AddSizeAdmin addSizeAdmin) throws ThtShoesException {
		try {
			if(addSizeAdmin.getListSize().size() == 0) {
				throw new ThtShoesException("Danh sách rỗng");
			}
			StringBuilder message = sizeAdminService.addSize(addSizeAdmin);
			return ResponseEntity.ok(message.toString());
		} catch (ThtShoesException ex) {
			throw ex;
		}catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm thất bại");
		}
	}
}
