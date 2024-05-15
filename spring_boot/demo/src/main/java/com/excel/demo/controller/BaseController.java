package com.excel.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.demo.dto.EmployeeDto;
import com.excel.demo.entity.Employee;
import com.excel.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
public class BaseController {

	@Autowired
	private  EmployeeService employeeService;

	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable Integer id) {
		
	Employee emp=employeeService.findEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);

	}
	@GetMapping("/findAll")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
		
	List<EmployeeDto> emp=employeeService.findAllEmployees();
		return ResponseEntity.status(HttpStatus.OK).body(emp);

	}


	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee){
		System.out.println(employee.getFirstName()+" "+employee.getLastName()
		+" "+employee.getMobileNo()+" "+employee.getAadharNo());
		EmployeeDto dto	=employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(dto);

	}

	@PutMapping("/home/{str}")
	public ResponseEntity<String> homePutReq(@PathVariable String str) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(str).ok("update");

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id ) {
		Employee dle=employeeService.deleteEmployee(id);
		return ResponseEntity.status(HttpStatus.OK).body(dle);

	}
}
