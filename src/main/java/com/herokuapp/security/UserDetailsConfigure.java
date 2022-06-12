package com.herokuapp.security;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsConfigure implements UserDetails {

	private String username;
	private String password;
	private boolean tinhtrang;
	private Set<GrantedAuthority> authorties;
	private String manguoidung;

	public UserDetailsConfigure(String username, String password, boolean tinhtrang, Set<GrantedAuthority> authorties) {
		this.username = username;
		this.password = password;
		this.tinhtrang = tinhtrang;
		this.authorties = authorties;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorties;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return tinhtrang;
	}

	public String getManguoidung() {
		return manguoidung;
	}

	public void setManguoidung(String manguoidung) {
		this.manguoidung = manguoidung;
	}

}
