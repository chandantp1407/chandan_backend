package com.excel.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excel.lms.entity.EmployeePrimaryInfo;
public interface EmployeeRepository extends JpaRepository<EmployeePrimaryInfo, Integer> {
	Optional<EmployeePrimaryInfo> findByEmployeeId(String employeeId );
}
