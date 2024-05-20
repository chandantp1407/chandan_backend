package com.excel.lms.entity;

import java.time.LocalDate;
import java.time.Year;

import com.excel.lms.enums.Designation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
@Table(name="employee_experience_info")
public class ExperienceInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer experienceId;
	
	private String companyName;
	private LocalDate dateOfJoining;
	private Integer yearOfExperience;
	private LocalDate dateOfRelieving;
	
	@Enumerated(EnumType.STRING)
	private Designation designation;
	
	private String location;
	
	@JoinColumn(name = "employee_id")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private EmployeePrimaryInfo employeePrimaryInfo;
}
