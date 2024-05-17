package com.excel.lms.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.excel.lms.enums.Designation;
import com.excel.lms.enums.EmployeeStatus;
import com.excel.lms.enums.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
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

	@Enumerated(EnumType.STRING)
	private Designation designation;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String nationality;

	@Enumerated(EnumType.STRING)
	private EmployeeStatus employeeStatus;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL ,mappedBy = "employeePrimaryInfo")
	private EmployeeSecondaryInfo employeeSecondaryInfo;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "employeePrimaryInfo")
	private List<EducationDetails> educationDetails;

	@OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "employeePrimaryInfo")
	private List<AddressDetails> addressDetails;

	@OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "employeePrimaryInfo")
	private List<BankDetails> bankDetails;


	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "employeePrimaryInfos")
	private List<TechnicalSkills> technicalSkills;

	@OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "employeePrimaryInfo")
	private List<ExperienceInfo> experienceInfos;

	@OneToMany(fetch =FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "employeePrimaryInfo")
	private List<Contact> contacts;
}
