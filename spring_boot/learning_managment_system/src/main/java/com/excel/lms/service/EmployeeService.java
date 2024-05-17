package com.excel.lms.service;

import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;

public interface EmployeeService {

	public String savePrimary(PrimaryInfoDto dto);

	public String saveSecondary(SecondaryInfoDto dto);

}
