package com.excel.lms.entity;

import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="employee_technicalskills_info")
public class TechnicalSkills {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer technicalskillId;

	private String skillType;
	private Integer yearOfExperience;
	private double skillRating;
}
