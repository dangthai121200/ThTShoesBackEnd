package com.herokuapp.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtTokenProvider {

	public final String BEARER = "Bearer ";

	public String createTokken(UserDetails user);

	public String getUsernameFromJWT(String token);

	public String validationTokken(String authToken);
}
