package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.PhuKienAdminDomain;
import com.herokuapp.domain.admin.list.ListPhuKienAdmin;
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
}
