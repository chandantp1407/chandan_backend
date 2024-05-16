package com.excel.demo.controller;

import java.util.List;

import static com.excel.demo.constant.EmployeeConstants.EMPLOYEE_DELETED_MESSAGE;
import static com.excel.demo.constant.EmployeeConstants.EMPLOYEE_ADDED_MESSAGE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.response.CommonResponse;
import com.excel.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class BaseController {

	@Autowired
	private  EmployeeService employeeService;


	@GetMapping("/find/{id}")
	public ResponseEntity<EmployeeDto> findEmployee(@PathVariable Integer id) {

		EmployeeDto emp=employeeService.findEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);

	}
	@GetMapping("/findAll")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() {

		List<EmployeeDto> emp=employeeService.findAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(emp);

	}


	@PostMapping("/add")
	public ResponseEntity<CommonResponse<EmployeeDto>> addEmployee(@RequestBody EmployeeDto employee){
		System.out.println(employee.getFirstName()+" "+employee.getLastName()
		+" "+employee.getMobileNo()+" "+employee.getAadharNo());
		EmployeeDto dto	=employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<EmployeeDto>builder().data(dto)
				.isError(false).message(EMPLOYEE_ADDED_MESSAGE).build());

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto ,@PathVariable Integer id) {
		EmployeeDto dto	=employeeService.updateEmployee(employeeDto, id);
		return ResponseEntity.status(HttpStatus.OK).body(dto);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<CommonResponse<EmployeeDto>> deleteEmployee(@RequestBody EmployeeDto employeeDto ) {

		employeeService.deleteEmployee(employeeDto.getId());
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<EmployeeDto>builder().data(null)
				.isError(false).message(EMPLOYEE_DELETED_MESSAGE).build());

	}
}
