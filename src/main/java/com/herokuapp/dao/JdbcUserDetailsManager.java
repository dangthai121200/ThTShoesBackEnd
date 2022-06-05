package com.herokuapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class JdbcUserDetailsManager extends org.springframework.security.provisioning.JdbcUserDetailsManager {

	public static final String USERS_BY_USERNAME_QUERY = "select username, password, tinhtrang, quyen" 
			+ " from taikhoan "
			+ " where username = ?";

	public JdbcUserDetailsManager() {
		super();
	}

	public JdbcUserDetailsManager(DataSource dataSource) {
		super(dataSource);
	}

	@Override
	public String getUsersByUsernameQuery() {
		return USERS_BY_USERNAME_QUERY;
	}

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		return getJdbcTemplate().query(getUsersByUsernameQuery(), this::mapToUser, username);
	}

	private UserDetails mapToUser(ResultSet rs, int rowNum) throws SQLException {
		String userName = rs.getString(1);
		String password = rs.getString(2);
		boolean enabled = rs.getBoolean(3);
		String role = rs.getString(4);

		return new User(userName, password, enabled, true, true, true, AuthorityUtils.createAuthorityList(role));
	}
}
