package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.herokuapp.domain.admin.AddGiayAdminDomain;
import com.herokuapp.domain.admin.AddGiayMauSizeAdmin;
import com.herokuapp.domain.admin.GiayAdminDomain;
import com.herokuapp.domain.admin.LoaigiayHangDanhmucAdminDomain;
import com.herokuapp.domain.admin.SoLuongGiaySizeMau;
import com.herokuapp.domain.admin.list.ListGiayAdmin;
import com.herokuapp.domain.admin.list.ListGiaySizeMauAdmin;
import com.herokuapp.handleexception.ThtShoesException;
import com.herokuapp.service.admin.GiayAdminService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(value = URL.NHAN_VIEN + URL.GIAY)
public class GiayAdminController {

	@Autowired
	public GiayAdminService giayService;

	@GetMapping
	public ListGiayAdmin getAllGiay() {
		return giayService.getAllGiay();
	}

	@GetMapping(value = "/{idGiay}")
	public GiayAdminDomain getGiayById(@PathVariable(name = "idGiay") String idGiay) {
		GiayAdminDomain giayAdminDomain = giayService.getGiayById(idGiay);
		return giayAdminDomain;

	}

	@GetMapping(value = URL.GIAY_SIZE_MAU + "/{idGiay}")
	public ListGiaySizeMauAdmin getAllGiaySizeMauOfGiay(@PathVariable(name = "idGiay") String idGiay) {
		ListGiaySizeMauAdmin listGiaySizeMauAdmin = giayService.getAllGiaySizeMauOfGiay(idGiay);
		return listGiaySizeMauAdmin;
	}

	@PostMapping
	public ResponseEntity<String> addGiay(@RequestBody AddGiayAdminDomain giayAdminDomain) {
		try {
			String idGiay = giayService.addGiay(giayAdminDomain);
			return ResponseEntity.ok(idGiay);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Th??m th???t b???i");
		}

	}

	@PostMapping(value = URL.GIAY_SIZE_MAU)
	public ResponseEntity<String> addGiaySizeMauOfGiay(@RequestBody AddGiayMauSizeAdmin addGiayMauSizeAdmin)
			throws ThtShoesException {
		try {
			giayService.addGiaySizeMauOfGiay(addGiayMauSizeAdmin);
			return ResponseEntity.ok("Th??m th??nh c??ng");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thay ?????i th???t b???i");
		}
	}

	@PutMapping
	public ResponseEntity<String> updateGiay(@RequestBody GiayAdminDomain giayAdminDomain) {
		try {
			if (giayAdminDomain.getMagiay() == null) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Thi???u m?? gi??y");
			}
			giayService.updateGiay(giayAdminDomain);
			return ResponseEntity.ok("C???p nh???t th??nh c??ng");
		} catch (ResponseStatusException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("C???p nh???t th???t b???i");
		}

	}

	@PutMapping(value = URL.LGIAY_HANG_DMUC + "/{magiay}")
	public ResponseEntity<String> changeLGiayHangDanhMucOfGiay(@PathVariable(name = "magiay") String magiay,
			@RequestBody LoaigiayHangDanhmucAdminDomain loaigiayHangDanhmucAdminDomain) throws ThtShoesException {
		try {
			giayService.changeLGiayHangDanhMucOfGiay(magiay, loaigiayHangDanhmucAdminDomain);
			return ResponseEntity.ok(magiay);
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Thay ?????i th???t b???i");
		}
	}

	@PutMapping(value = URL.GIAY_SIZE_MAU)
	public ResponseEntity<String> updateSoLuongGiaySizeMauOfGiay(@RequestBody SoLuongGiaySizeMau soLuongGiaySizeMau)
			throws ThtShoesException {
		try {
			giayService.updateSoLuongGiaySizeMauOfGiay(soLuongGiaySizeMau);
			return ResponseEntity.ok("C???p nh???t th??nh c??ng");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("C???p nh???t th???t b???i");
		}
	}

	@DeleteMapping(value = "/{magiay}")
	public ResponseEntity<String> deleteGiay(@PathVariable(name = "magiay") String magiay) throws ThtShoesException {
		try {
			giayService.deleteGiay(magiay);
			return ResponseEntity.ok(magiay);
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("X??a th???t b???i");
		}
	}

	@DeleteMapping(value = URL.GIAY_SIZE_MAU + "/{idGiaySizemau}")
	public ResponseEntity<String> deleteGiaySizeMauOfGiay(@PathVariable(name = "idGiaySizemau") int idGiaySizemau)
			throws ThtShoesException {
		try {
			giayService.deleteGiaySizeMauOfGiay(idGiaySizemau);
			return ResponseEntity.ok("X??a th??nh c??ng");
		} catch (ThtShoesException ex) {
			throw ex;
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("X??a th???t b???i");
		}
	}

}
