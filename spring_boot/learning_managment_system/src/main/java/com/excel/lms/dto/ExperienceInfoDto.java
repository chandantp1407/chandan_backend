package com.excel.lms.dto;

import java.time.LocalDate;

import com.excel.lms.enums.Designation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class ExperienceInfoDto {
	private Integer experienceId;
	private String companyName;
	private LocalDate dateOfJoining;
	private Integer yearOfExperience;
	private LocalDate dateOfRelieving;
	private Designation designation;
	private String location;
}
