package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MaritalStatus {

	SINGLE("SINGLE"), MARRIED("MARRIED"), WIDOW("WIDOW"), DIVORCED("DIVORCED");
	
	private final String martialStatus;
}
