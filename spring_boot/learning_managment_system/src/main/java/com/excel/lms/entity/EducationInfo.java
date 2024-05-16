package com.excel.lms.entity;

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
@Table(name="employee_education_info")
public class EducationInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;

	private String educationType;
	private int yearOfPassing;
	private double percentage;
	private String universityName;
	private String specialization;
	private String state;

}
