package com.excel.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.repository.EmployeeReposirory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeReposirory employeeReposirory;


	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		Employee employee = Employee.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
				.mobileNo(dto.getMobileNo()).aadharNo(dto.getAadharNo()).panNo(dto.getPanNo())
				.employeeNo(dto.getEmployeeNo()).build();	
		Employee save=employeeReposirory.save(employee);

		return EmployeeDto.builder().id(save.getId()).firstName(save.getFirstName()).lastName(save.getLastName())
				.mobileNo(save.getMobileNo()).aadharNo(save.getAadharNo()).panNo(save.getPanNo())
				.employeeNo(save.getEmployeeNo()).build();
	}


	@Override
	public Employee deleteEmployee(Integer id) {
		Optional<Employee> optional=employeeReposirory.findById(id);
		if(optional.isPresent()) {
			Employee emp=optional.get();
			employeeReposirory.delete(emp);
			return emp;
		}
		return null;

	}


	@Override
	public Employee findEmployee(Integer id) {
		Optional<Employee> optional=employeeReposirory.findById(id);
		if(optional.isPresent()) {
			Employee emp=optional.get();
			return emp;
		}
		return null;

	}


	@Override
	public List<EmployeeDto> findAllEmployees() {


		return employeeReposirory.findAll().stream()
				.map(e ->EmployeeDto.builder().id(e.getId()).aadharNo(e.getAadharNo())
						.mobileNo(e.getMobileNo()).employeeNo(e.getEmployeeNo()).firstName(e.getFirstName())
						.lastName(e.getLastName()).panNo(e.getPanNo()).build())
				.toList();
	}


	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto, Integer id) {
		Optional<Employee> optional=employeeReposirory.findById(id);
		if(optional.isPresent()) {
			Employee em	=optional.get();

		}
		return null;
	}
}



