package com.herokuapp.service.common;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import com.herokuapp.domain.common.ChangePasswordDomain;
import com.herokuapp.entity.Taikhoan;
import com.herokuapp.reponsitory.TaiKhoanReponsitory;
import com.herokuapp.security.UserDetailsConfigure;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService, UserDetailsService {

	@Autowired
	public TaiKhoanReponsitory taiKhoanReponsitory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("username is null");
		}
		Taikhoan taikhoan = taiKhoanReponsitory.getTaiKhoanByUsername(username);
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(taikhoan.getQuyen().getName()));
		UserDetailsConfigure userDetailsConfigure = new UserDetailsConfigure(taikhoan.getUsername(),
				taikhoan.getPassword(), taikhoan.getTinhtrang() != 0, authorities);
		userDetailsConfigure.setManguoidung(taikhoan.getManguoidung());
		return userDetailsConfigure;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void changePassword(ChangePasswordDomain changePasswordDomain) {
		UserDetailsConfigure userDetailsConfigure = (UserDetailsConfigure) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (changePasswordDomain.getOldPassowrd().equals(userDetailsConfigure.getPassword())
				&& changePasswordDomain.getManguoidung().equals(userDetailsConfigure.getManguoidung())) {
			taiKhoanReponsitory.changePassword(changePasswordDomain.getNewPassword(),
					changePasswordDomain.getManguoidung());
		} else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Bạn không có quyền truy cập");
		}
	}

	@Override
	public Boolean checkUsername(String username) {
		try {
			Taikhoan taikhoan = taiKhoanReponsitory.getTaiKhoanByUsername(username);
			if (taikhoan != null) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Boolean checkEmail(String email) {
		try {
			Taikhoan taikhoan = taiKhoanReponsitory.getTaiKhoanByEmail(email);
			if (taikhoan != null) {
				return true;
			}
			return false;
		} catch (Exception ex) {
			return false;
		}
	}
}
