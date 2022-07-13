package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.list.ListMauSacAdmin;
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

}
