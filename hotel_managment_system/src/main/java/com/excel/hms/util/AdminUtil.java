package com.excel.hms.util;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.excel.hms.dto.AdminDTO;
import com.excel.hms.entity.Admin;

public class AdminUtil {

	@Autowired
	private static BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public static Admin dtoToEntity(AdminDTO dto) {
		return Admin.builder()
				.adminNo(dto.getAdminNo())
				.adminName(dto.getAdminName())
				.password(bCryptPasswordEncoder.encode(dto.getPassword()))
				.roleType(dto.getRoleType())
				.build();
	}

	public static Admin updatepassword(Admin password, AdminDTO dto) {
		password.setPassword(dto.getPassword());
		return password;
	}

	public static AdminDTO dtoToEntity(Admin save) {
		
		return AdminDTO.builder()
				.adminName(save.getAdminName())
				.password(bCryptPasswordEncoder.encode(save.getPassword()))
				.roleType(save.getRoleType())
				.build();
	}

	public static AdminDTO dtoToGetEntity(Admin admin) {
	
		return AdminDTO.builder().adminNo(admin.getAdminNo()).adminName(admin.getAdminName())
				.password(admin.getPassword()).roleType(admin.getRoleType()).build();
	}
	
}

