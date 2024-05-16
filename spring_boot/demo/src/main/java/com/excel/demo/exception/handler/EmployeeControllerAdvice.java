package com.excel.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.excel.demo.exception.EmployeeException;
import com.excel.demo.response.CommonResponse;

import lombok.Builder;

@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<CommonResponse<String>> employeeExceptionHandler(RuntimeException ex){
		return ResponseEntity.status(HttpStatus.OK)
				.body(CommonResponse.<String>builder().data(null)
						.isError(true).message(ex.getMessage()).build());
	}
}
