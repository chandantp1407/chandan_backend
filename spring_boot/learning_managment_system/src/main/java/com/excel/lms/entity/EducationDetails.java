package com.excel.lms.entity;

import com.excel.lms.enums.EducationType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="employee_education_info")
public class EducationDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;

	@Enumerated(EnumType.STRING)
	private EducationType educationType;
	private int yearOfPassing;
	private double percentage;
	private String universityName;
	private String specialization;
	private String state;
  
	@ManyToOne(fetch = FetchType.LAZY)
	private EmployeePrimaryInfo employeePrimaryInfo;
}