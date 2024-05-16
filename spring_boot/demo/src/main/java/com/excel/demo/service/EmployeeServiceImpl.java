package com.excel.demo.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import static com.excel.demo.constant.EmployeeConstants.EMPLOYEE_NOT_FOUND_EXCEPTION;
import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.exception.NoEmployeeFoundException;
import com.excel.demo.repository.EmployeeReposirory;
import com.excel.demo.util.EmployeeUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeReposirory employeeReposirory;


	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
		Employee employee = Employee.builder().firstName(dto.getFirstName()).lastName(dto.getLastName())
				.mobileNo(dto.getMobileNo()).aadharNo(dto.getAadharNo()).panNo(dto.getPanNo())
				.employeeNo(dto.getEmployeeNo()).build();	
		Employee save=employeeReposirory.save(employee);

		return EmployeeUtil.employeeToDto(employee);
	}


	@Override
	public void deleteEmployee(Integer id) {
		Optional<Employee> optional=employeeReposirory.findById(id);
		if(optional.isPresent()) {
			Employee emp=optional.get();
			employeeReposirory.delete(emp);

		}
		else
			throw new NoEmployeeFoundException(EMPLOYEE_NOT_FOUND_EXCEPTION);
	}


	@Override
	public EmployeeDto findEmployee(Integer id) {
		Optional<Employee> optional=employeeReposirory.findById(id);
		if(optional.isPresent()) {
			Employee emp=optional.get();
			return EmployeeUtil.employeeToDto(emp);
		}
		throw new NoEmployeeFoundException(EMPLOYEE_NOT_FOUND_EXCEPTION);

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
			log.info(dto.getFirstName());
			em.setFirstName(dto.getFirstName());
			em.setLastName(dto.getLastName());
			Employee update =employeeReposirory.save(em);
			return EmployeeUtil.employeeToDto(update);
		}
		else
			 throw new NoEmployeeFoundException(EMPLOYEE_NOT_FOUND_EXCEPTION);
	}
}



