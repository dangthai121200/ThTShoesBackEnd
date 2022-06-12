package com.herokuapp.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.herokuapp.security.UserDetailsConfigure;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProviderImpl implements JwtTokenProvider {

	// Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
	private final String JWT_SECRET = "thtshoes";

	// Thời gian có hiệu lực của chuỗi jwt 604800000
	private final long JWT_EXPIRATION = 1604800000L;

	private final String KEY_CLAIMS_USERNAME = "username";

	@Override
	public String createTokken(UserDetails user) {
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
		UserDetailsConfigure userDetailsConfigure = (UserDetailsConfigure) user;
		Map<String, Object> claims = new HashMap<>();
		claims.put("manguoidung", userDetailsConfigure.getManguoidung());
		return BEARER + Jwts.builder().setSubject(userDetailsConfigure.getUsername()).addClaims(claims).setIssuedAt(now)
				.setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	@Override
	public String getUsernameFromJWT(String token) {
		String username = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
		return username;
	}

	@Override
	public String validationTokken(String authToken) {
		String messageError = "";
		try {
			Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
			return messageError;
		} catch (MalformedJwtException ex) {
			messageError = ex.getMessage();
		} catch (ExpiredJwtException ex) {
			messageError = ex.getMessage();
		} catch (UnsupportedJwtException ex) {
			messageError = ex.getMessage();
		} catch (IllegalArgumentException ex) {
			messageError = ex.getMessage();
		}
		return messageError;
	}
}
