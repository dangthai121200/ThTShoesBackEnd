package com.herokuapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/nhanvien")
	public String nhanvien() {
		return "nhanvien";
	}

	@GetMapping("/khachhang")
	public String kachhang() {
		return "khachhang";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
