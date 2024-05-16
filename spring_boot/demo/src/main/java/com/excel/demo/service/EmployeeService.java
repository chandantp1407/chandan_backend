package com.excel.demo.service;

import java.util.List;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;

public interface EmployeeService {
	public EmployeeDto addEmployee(EmployeeDto dto);
	public void deleteEmployee(Integer id);
	public EmployeeDto findEmployee(Integer id);
	public List<EmployeeDto> findAllEmployees();
	public EmployeeDto updateEmployee(EmployeeDto dto,Integer id);
}