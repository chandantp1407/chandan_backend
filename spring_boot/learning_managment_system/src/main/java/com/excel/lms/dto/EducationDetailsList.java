package com.excel.lms.dto;


import java.util.List;

import com.excel.lms.entity.EducationDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class EducationDetailsList {
	private String employeeId;
	private List<EducationDetailsDto> educations;
}
