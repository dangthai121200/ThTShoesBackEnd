package com.herokuapp.controller.admin;

import javax.validation.Valid;

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
	public ResponseEntity<String> addNhanvien(@RequestBody @Valid InfoNhanvienDangKy infoNhanvienDangKy) {
		try {
			StringBuilder messError = new StringBuilder();
			boolean checkUsername = taikhoanService.checkUsername(infoNhanvienDangKy.getTaikhoan().getUsername());
			boolean checkEmail = taikhoanService.checkEmail(infoNhanvienDangKy.getTaikhoan().getEmail());
			boolean checkSdt = nhanVienService.checkSdt(Long.valueOf(infoNhanvienDangKy.getNhanvien().getSdt()));
			if (checkUsername) {
				messError.append("Username đã tồn tại, ");
			}
			if (checkEmail) {
				messError.append("Email đã tồn tại, ");
			}
			if (checkSdt) {
				messError.append("Số điện thoại đã tồn tại, ");
			}

			if (!checkUsername && !checkEmail && !checkSdt) {
				nhanVienService.addNhanVien(infoNhanvienDangKy);
				return ResponseEntity.ok("Đăng ký thành công");
			} else {
				return ResponseEntity.badRequest().body(messError.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Đăng ký thất bại");
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
			return ResponseEntity.ok("Lock nhân viên thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("Lock nhân viên thất bại");
		}
	}

	@PutMapping(value = URL.UNLOCK + "/{manv}")
	public ResponseEntity<String> unLockNhanVien(@PathVariable(name = "manv") String manv) {
		try {
			nhanVienService.unLockNhanVien(manv);
			return ResponseEntity.ok("UnLock nhân viên thành công");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body("UnLock nhân viên thất bại");
		}
	}

}
