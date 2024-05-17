package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EmployeeStatus {
	ACTIVE("ACTIVE"),  TERMINATED("TERMINATED"),  ABSCOND("ABSCOND");

	private final String employeeStatus;
}
