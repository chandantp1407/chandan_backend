package com.excel.lms.controller;

import static com.excel.lms.constant.EmployeeConstants.EMPLOYEE_PRIMARY_INFO_SAVED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;
import com.excel.lms.response.CommonResponse;
import com.excel.lms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/employee",method = {RequestMethod.POST,RequestMethod.PUT})
public class EmployeeRegisterController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/pinfo")
	public ResponseEntity<CommonResponse<String>> postPrimaryInfo(@RequestBody PrimaryInfoDto dto){
		String employeeId=employeeService.savePrimary(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message(EMPLOYEE_PRIMARY_INFO_SAVED).build());

	}
	
	@PostMapping(path = "/pinfo")
	public ResponseEntity<CommonResponse<String>> postSecondaryInfo(@RequestBody SecondaryInfoDto dto){
		String employeeId=employeeService.saveSecondary(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message(EMPLOYEE_PRIMARY_INFO_SAVED).build());

	}
}
