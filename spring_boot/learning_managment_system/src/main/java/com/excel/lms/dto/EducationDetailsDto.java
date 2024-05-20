package com.excel.lms.dto;

import com.excel.lms.enums.EducationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class EducationDetailsDto {
	private String employeeId;
	private Integer educationId;
	private EducationType educationType;
	private int yearOfPassing;
	private double percentage;
	private String universityName;
	private String specialization;
	private String state;
}
