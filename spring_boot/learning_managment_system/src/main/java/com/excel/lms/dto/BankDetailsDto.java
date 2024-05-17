package com.excel.lms.dto;

import com.excel.lms.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class BankDetailsDto {
	private Integer bankDetailsId;
	private String accountNo;
	private String bankName;
	private AccountType accountType;
	private String ifscCode;
	private String branch;
	private String state;
}
