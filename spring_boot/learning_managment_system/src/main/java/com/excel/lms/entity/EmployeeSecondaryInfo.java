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
@Table(name="employee_secondary_info")
public class EmployeeSecondaryInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seconadryInfoId;

	private String panNo;
	private String aadharNo;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private String passportNo;
	private String maritalStatus;

}
