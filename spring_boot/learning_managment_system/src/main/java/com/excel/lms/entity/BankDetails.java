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
@Table(name="employee_bank_Details")
public class BankDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankDetailsId;
	 
	private String accountNo;
	private String bankName;
	private String accountType;
	private String ifscCode;
	private String branch;
	private String state;
}
