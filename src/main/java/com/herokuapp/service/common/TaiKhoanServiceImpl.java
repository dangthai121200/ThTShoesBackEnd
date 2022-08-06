package com.herokuapp.service.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;
import javax.validation.constraints.Email;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	public EmailService emailService;

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
		if (passwordEncoder.matches(changePasswordDomain.getOldPassowrd(), userDetailsConfigure.getPassword())
				&& changePasswordDomain.getManguoidung().equals(userDetailsConfigure.getManguoidung())) {
			taiKhoanReponsitory.changePassword(passwordEncoder.encode(changePasswordDomain.getNewPassword()),
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

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void resetPassword(@Email String email) throws MessagingException {
		Taikhoan taikhoan = taiKhoanReponsitory.getTaiKhoanByEmail(email);
		String password = generatePassayPassword();
		String passwordEncode = passwordEncoder.encode(password);
		taikhoan.setPassword(passwordEncode);
		taiKhoanReponsitory.save(taikhoan);

		if (!StringUtils.isEmpty(taikhoan.getEmail())) {
			Map<String, Object> props = new HashMap<String, Object>();
			props.put("newPassword", password);
			String html = emailService.convertToTemplateHtmlEmail(props, "resetpass-mail");
			emailService.sendMessageWithAttachment(taikhoan.getEmail(), "Thông Báo Reset Mật Khẩu từ ThtShoes", html,
					null);
		}
	}

	private String generatePassayPassword() {
		List<CharacterRule> rules = Arrays.asList(
				// at least one upper-case character
				new CharacterRule(EnglishCharacterData.UpperCase, 2),

				// at least one lower-case character
				new CharacterRule(EnglishCharacterData.LowerCase, 2),

				// at least one digit character
				new CharacterRule(EnglishCharacterData.Digit, 2),

				// at least one Special character

				new CharacterRule(new CharacterData() {

					@Override
					public String getErrorCode() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public String getCharacters() {
						// TODO Auto-generated method stub
						return "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
					}
				}, 2));

		PasswordGenerator generator = new PasswordGenerator();

		// Generated password is 12 characters long, which complies with policy
		String password = generator.generatePassword(12, rules);

		return password;
	}
}
