package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.AddPhuKienAdmin;
import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.PhuKienAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.PHU_KIEN)
public class PhuKienAdminController {

	@Autowired
	public PhuKienAdminService phuKienAdminService;

	@GetMapping
	public ListPhuKienAdmin getAllPhuKien() {
		ListPhuKienAdmin listPhuKienAdmin = phuKienAdminService.getAllPhuKien();
		return listPhuKienAdmin;
	}

	@GetMapping(value = "/{idPK}")
	public PhuKienAdminDomain getPhuKienById(@PathVariable(name = "idPK") String idPhuKien) {
		PhuKienAdminDomain phuKienAdminDomain = phuKienAdminService.getPhuKienById(idPhuKien);
		return phuKienAdminDomain;
	}

	@PostMapping
	public ResponseEntity<String> addPhuKien(@RequestBody AddPhuKienAdmin addPhuKienAdmin) {
		try {
			String maphukien = phuKienAdminService.addPhuKien(addPhuKienAdmin);
			return ResponseEntity.ok(maphukien);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thêm phụ kiện thất bại");
		}

	}

	@PutMapping
	public ResponseEntity<String> updatePhuKien(@RequestBody AddPhuKienAdmin addPhuKienAdmin) throws ThtShoesException {
		try {
			phuKienAdminService.updatePhuKien(addPhuKienAdmin);
			return ResponseEntity.ok("Cập nhật thành công");
		} catch (ThtShoesException ex) {
			throw ex;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Cập nhật thất bại");
		}

	}
}
