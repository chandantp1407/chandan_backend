package com.excel.demo.service;

import java.util.List;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;

public interface EmployeeService {
	public EmployeeDto addEmployee(EmployeeDto dto);
	public Employee deleteEmployee(Integer id);
	public Employee findEmployee(Integer id);
	public List<EmployeeDto> findAllEmployees();
	public EmployeeDto updateEmployee(EmployeeDto dto,Integer id);
}