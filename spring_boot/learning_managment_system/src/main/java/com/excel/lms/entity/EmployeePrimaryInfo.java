package com.excel.lms.entity;

import java.time.LocalDate;

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
@Table(name="employee_primary_info")
public class EmployeePrimaryInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer primaryInfoId;

	private String employeeId;
	private String employeeName;
	private LocalDate dateOfJoining;
	private LocalDate dateOfBirth;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String employeeStatus;
}
