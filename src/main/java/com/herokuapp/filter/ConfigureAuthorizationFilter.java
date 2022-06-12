package com.herokuapp.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.herokuapp.jwt.JwtTokenProvider;
import com.herokuapp.security.UserDetailsConfigure;

public class ConfigureAuthorizationFilter extends OncePerRequestFilter {

	private JwtTokenProvider jwtTokenProvider;

	private UserDetailsService userDetailsService;

	private List<String> listUrlNotFilter = new ArrayList<>();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (listUrlNotFilter.contains(request.getServletPath())) {
			filterChain.doFilter(request, response);
		} else {
			String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
			if (authorizationHeader != null && authorizationHeader.startsWith(JwtTokenProvider.BEARER)) {
				try {
					String tokken = authorizationHeader.substring(JwtTokenProvider.BEARER.length());
					String messError = jwtTokenProvider.validationTokken(tokken);
					if (messError.equals("")) {
						String username = jwtTokenProvider.getUsernameFromJWT(tokken);
						UserDetailsConfigure userDetailsConfigure = (UserDetailsConfigure) this.userDetailsService
								.loadUserByUsername(username);
						UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
								userDetailsConfigure, null, userDetailsConfigure.getAuthorities());
						authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(authentication);
						filterChain.doFilter(request, response);
					} else {
						throw new Exception(messError);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					response.setStatus(HttpStatus.FORBIDDEN.value());
					// response.sendError(HttpStatus.FORBIDDEN.value());
					Map<String, String> error = new HashMap<>();
					error.put("error", HttpStatus.FORBIDDEN.name());
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);
					new ObjectMapper().writeValue(response.getOutputStream(), error);
				}
			} else {
				filterChain.doFilter(request, response);
			}
		}
	}

	public void setJwtTokenProvider(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void addListUrlNotFilter(String url) {
		this.listUrlNotFilter.add(url);
	}
}
