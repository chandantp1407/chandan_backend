package com.excel.lms.entity;

import java.time.Year;

import com.excel.lms.enums.AccountType;

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
@Table(name="employee_bank_Details")
public class BankDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankDetailsId;
	 
	private String accountNo;
	private String bankName;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	private String ifscCode;
	private String branch;
	private String state;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EmployeePrimaryInfo employeePrimaryInfo;
}
