package com.excel.lms.dto;

import com.excel.lms.enums.MaritalStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class SecondaryInfoDto {
	private Integer seconadryInfoId;

	private String employeeId;
	private String panNo;
	private String aadharNo;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private String passportNo;
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
}
