package com.excel.lms.controller;

import static com.excel.lms.constant.EmployeeConstants.EMPLOYEE_PRIMARY_INFO_SAVED;
import static com.excel.lms.constant.EmployeeConstants.EMPLOYEE_SECONDARY_INFO_SAVED;
import static com.excel.lms.constant.EmployeeConstants.BANK_DETAILS_SAVED;
import static com.excel.lms.constant.EmployeeConstants.EDUCATION_DETAILS_SAVED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationDetailsDto;
import com.excel.lms.dto.EducationDetailsList;
import com.excel.lms.dto.ExperienceListDto;
import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;
import com.excel.lms.dto.TechicalSkillsListDto;
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
	
	@PostMapping(path = "/sinfo")
	public ResponseEntity<CommonResponse<String>> postSecondaryInfo(@RequestBody SecondaryInfoDto dto){
		String employeeId=employeeService.saveSecondary(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message(EMPLOYEE_SECONDARY_INFO_SAVED).build());

	}
	@PostMapping(path = "/bank")
	public ResponseEntity<CommonResponse<String>> postBankDetails(@RequestBody BankDetailsDto dto ){
		String employeeId=employeeService.saveBankDetails(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message(BANK_DETAILS_SAVED).build());

	}
	@PostMapping(path = "/edu")
	public ResponseEntity<CommonResponse<String>> postEducationDetails(@RequestBody EducationDetailsList dto ){
		String employeeId=employeeService.saveEducationDetails(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message(EDUCATION_DETAILS_SAVED).build());

	}
	@PostMapping(path = "/add")
	public ResponseEntity<CommonResponse<String>> postAddressDetails(@RequestBody AddressListDto dto  ){
		String employeeId=employeeService.saveAddressDetails(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message("address details added succesfully").build());

	}
	@PostMapping(path = "/exp")
	public ResponseEntity<CommonResponse<String>> postExperienceDetails(@RequestBody ExperienceListDto dto  ){
		String employeeId=employeeService.saveExperienceInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message("Experience details added succesfully").build());

	}
	@PostMapping(path = "/cont")
	public ResponseEntity<CommonResponse<String>> postContactDetails(@RequestBody ContactListDto dto  ){
		String employeeId=employeeService.saveContact(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message("Contact details added succesfully").build());

	}
	@PostMapping(path = "/tech")
	public ResponseEntity<CommonResponse<String>> postTechnicalSkills(@RequestBody TechicalSkillsListDto dto  ){
		String employeeId=employeeService.saveTechnicalSkills(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(employeeId)
						.isError(false).message("Techical skills added succesfully").build());

	}
	
}
