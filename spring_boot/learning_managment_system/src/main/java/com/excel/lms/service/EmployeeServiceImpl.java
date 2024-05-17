package com.excel.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.util.ObjectUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String savePrimary(PrimaryInfoDto dto) {

		if(!employeeRepository.findByEmployeeId(dto.getEmployeeId() ).isPresent()){

			EmployeePrimaryInfo emp=ObjectUtil.dtoToEntity(dto);
			EmployeePrimaryInfo emp1=employeeRepository.save(emp);
			return emp1.getEmployeeId();
		}
		return null;
	}

	@Override
	public String saveSecondary(SecondaryInfoDto dto) {
		
		return null;
	}

}
