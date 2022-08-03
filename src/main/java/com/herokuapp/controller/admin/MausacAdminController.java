package com.herokuapp.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.AddMauSac;
import com.herokuapp.domain.admin.list.ListMauSacAdmin;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.MauSacAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.MAU_SAC)
public class MausacAdminController {

	@Autowired
	public MauSacAdminService mauSacAdminService;

	@GetMapping
	public ListMauSacAdmin getAllMauSac() {
		return mauSacAdminService.getAllMauSac();
	}

	@PostMapping
	public ResponseEntity<String> addMauSac(@RequestBody @Valid AddMauSac addMauSac) throws ThtShoesException {
		try {
			if(addMauSac.getMausacs().size() == 0) {
				throw new ThtShoesException("Danh sách rỗng");
			}
			String message = mauSacAdminService.addMauSac(addMauSac);
			return ResponseEntity.ok(message);
		} catch (ThtShoesException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm thất bại");
		}

	}

}
