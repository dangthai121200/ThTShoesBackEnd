package com.herokuapp.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

}
