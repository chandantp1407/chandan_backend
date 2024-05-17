package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EducationType {
	UNDERGRADUATE("UNDERGRADUATE"),  POSTGRADUATE("POSTGRADUATE"),  ENGINEERING("ENGINEERING"), OTHERS("OTHERS");
	

	private final String educationType;
}
