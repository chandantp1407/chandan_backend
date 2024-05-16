package com.excel.demo.util;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;

public class EmployeeUtil {
	private EmployeeUtil() {

	}

	public static EmployeeDto employeeToDto(Employee employee) {
		return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName()).lastName(employee.getLastName())
				.mobileNo(employee.getMobileNo()).aadharNo(employee.getAadharNo()).panNo(employee.getPanNo())
				.employeeNo(employee.getEmployeeNo()).build();

	}
}
