package com.excel.lms.util;

import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;

public class ObjectUtil {

	public static EmployeePrimaryInfo dtoToEntity(PrimaryInfoDto dto) {
	
		return EmployeePrimaryInfo.builder().primaryInfoId(dto.getPrimaryInfoId()).employeeId(dto.getEmployeeId()
				).employeeName(dto.getEmployeeName()).dateOfJoining(dto.getDateOfJoining()).dateOfBirth(dto.getDateOfBirth())
				.bloodGroup(dto.getBloodGroup()).email(dto.getEmail()).designation(dto.getDesignation()).gender(dto.getGender())
				.gender(dto.getGender()).nationality(dto.getNationality()).employeeStatus(dto.getEmployeeStatus()).build();
	}

}
