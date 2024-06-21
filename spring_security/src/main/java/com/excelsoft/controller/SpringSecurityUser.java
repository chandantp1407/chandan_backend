package com.excelsoft.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelsoft.entity.UserEntity;
import com.excelsoft.service.UserEntityDetailService;


@RestController
public class SpringSecurityUser {

	@Autowired
	private UserEntityDetailService userEntityDetailService;

	@GetMapping("/home")
	public String home() {
		return ("<h1>Welcome</h1>");
	}

	@GetMapping("/admin/home")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String admin() {
		return ("<h1>This is admin page</h1>");
	}

	@GetMapping("/user/home")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String user() {
		return ("<h1>this is user page</h1>");
	}

	@PostMapping("/new")
	public String addNewUser(@RequestBody UserEntity userEntity) {
		return userEntityDetailService.addUser(userEntity);
	}
}

