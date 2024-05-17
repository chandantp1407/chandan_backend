package com.excel.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class TechnicalSkillsDto {
	private Integer technicalskillId;

	private String skillType;
	private Integer yearOfExperience;
	private double skillRating;
}
