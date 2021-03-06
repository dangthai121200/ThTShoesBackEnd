package com.herokuapp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.herokuapp.domain.admin.InfoNhanvienDangKy;
import com.herokuapp.domain.admin.NhanVienAdminDomain;
import com.herokuapp.domain.admin.list.ListNhanVienAdmin;
import com.herokuapp.security.UserDetailsConfigure;
import com.herokuapp.service.admin.NhanVienService;
import com.herokuapp.service.common.TaiKhoanService;
import com.herokuapp.util.URL;

@RestController
@RequestMapping(URL.NHAN_VIEN)
public class NhanVienAdminController {

	@Autowired
	public NhanVienService nhanVienService;

	@Autowired
	public TaiKhoanService taikhoanService;

	@GetMapping
	public ListNhanVienAdmin getAllNhanVien() {
		return nhanVienService.getAllNhanVien();
	}

	@GetMapping(value = URL.GET_BY_ID + "/{manv}")
	public NhanVienAdminDomain getNhanVienyId(@PathVariable(name = "manv") String mavn) {
		return nhanVienService.getNhanVienyId(mavn);
	}

	@PostMapping(value = URL.ADD_NHAN_VIEN)
	public ResponseEntity<String> addNhanvien(@RequestBody InfoNhanvienDangKy infoNhanvienDangKy) {
		try {
			StringBuilder messError = new StringBuilder();
			boolean checkUsername = taikhoanService.checkUsername(infoNhanvienDangKy.getTaikhoan().getUsername());
			boolean checkEmail = taikhoanService.checkEmail(infoNhanvienDangKy.getTaikhoan().getEmail());
			boolean checkSdt = nhanVienService.checkSdt(Long.valueOf(infoNhanvienDangKy.getNhanvien().getSdt()));
			if (checkUsername) {
				messError.append("Username ???? t???n t???i, ");
			}
			if (checkEmail) {
				messError.append("Email ???? t???n t???i, ");
			}
			if (checkSdt) {
				messError.append("S??? ??i???n tho???i ???? t???n t???i, ");
			}

			if (!checkUsername && !checkEmail && !checkSdt) {
				nhanVienService.addNhanVien(infoNhanvienDangKy);
				return ResponseEntity.ok("????ng k?? th??nh c??ng");
			} else {
				return ResponseEntity.badRequest().body(messError.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("????ng k?? th???t b???i");
		}
	}

	@GetMapping(value = URL.INFO_NHAN_VIEN)
	public NhanVienAdminDomain getInfoNhanVien() {
		String idMaNhanvien = ((UserDetailsConfigure) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal()).getManguoidung();
		return nhanVienService.getInfoNhanVien(idMaNhanvien);
	}

	@PutMapping(value = URL.LOCK + "/{manv}")
	public ResponseEntity<String> lockNhanVien(@PathVariable(name = "manv") String manv) {
		try {
			nhanVienService.lockNhanVien(manv);
			return ResponseEntity.ok("Lock nh??n vi??n th??nh c??ng");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Lock nh??n vi??n th???t b???i");
		}
	}

	@PutMapping(value = URL.UNLOCK + "/{manv}")
	public ResponseEntity<String> unLockNhanVien(@PathVariable(name = "manv") String manv) {
		try {
			nhanVienService.unLockNhanVien(manv);
			return ResponseEntity.ok("UnLock nh??n vi??n th??nh c??ng");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("UnLock nh??n vi??n th???t b???i");
		}
	}

}
