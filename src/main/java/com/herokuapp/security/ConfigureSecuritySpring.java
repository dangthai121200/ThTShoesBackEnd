package com.herokuapp.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.herokuapp.dao.JdbcUserDetailsManager;
import com.herokuapp.filter.ConfigureAuthenticationFilter;
import com.herokuapp.filter.ConfigureAuthorizationFilter;
import com.herokuapp.jwt.JwtTokenProvider;
import com.herokuapp.jwt.JwtTokenProviderImpl;
import com.herokuapp.util.URL;

@EnableWebSecurity
public class ConfigureSecuritySpring extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		ConfigureAuthorizationFilter authorizationFilter = new ConfigureAuthorizationFilter();
		authorizationFilter.setJwtTokenProvider(jwtTokenProvider());
		authorizationFilter.setUserDetailsService(TaiKhoanServiceImpl());
		authorizationFilter.addListUrlNotFilter(URL.LOGIN);
		authorizationFilter.addListUrlNotFilter(URL.KHACH_HANG + URL.DANG_KY);
		authorizationFilter.addListUrlNotFilter(URL.KHACH_HANG + URL.TRANG_CHU);
		authorizationFilter.addListUrlNotFilter(URL.KHACH_HANG + URL.GIAY);

		ConfigureAuthenticationFilter authenticationFilter = new ConfigureAuthenticationFilter(
				authenticationManagerBean());
		authenticationFilter.setJwtTokenProvider(jwtTokenProvider());

		http.csrf().disable();
		http.cors().disable();
		//
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests().antMatchers("/").permitAll();

		http.authorizeRequests().antMatchers(URL.LOGIN + "/**").permitAll();
		http.authorizeRequests().antMatchers(URL.KHACH_HANG + URL.DANG_KY + "/**").permitAll();
		http.authorizeRequests().antMatchers(URL.KHACH_HANG + URL.TRANG_CHU + "/**").permitAll();
		http.authorizeRequests().antMatchers(URL.KHACH_HANG + URL.GIAY + "/**").permitAll();

		http.authorizeRequests().anyRequest().authenticated();
		// http.formLogin().and().httpBasic();

		http.addFilter(authenticationFilter);
		http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(TaiKhoanServiceImpl()).passwordEncoder(noOpPasswordEncoder());
	}

	@Bean
	public UserDetailsService jdbcuserDetailsServiceManager() {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public UserDetailsService TaiKhoanServiceImpl() {
		return new com.herokuapp.service.TaiKhoanServiceImpl();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public JwtTokenProvider jwtTokenProvider() {
		return new JwtTokenProviderImpl();
	}
}
