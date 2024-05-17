package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AccountType {

	SAVING("SAVING"), CURENT("CURRENT");

	private final String accountType;

}
