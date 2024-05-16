package com.excel.lms.entity;

import java.time.LocalDate;
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
@Table(name="employee_experience_info")
public class ExperienceInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer experienceId;
	
	private String companyName;
	private LocalDate dateOfJoining;
	private Integer yearOfExperience;
	private LocalDate dateOfRelieving;
	private String designation;
	private String location;
}
