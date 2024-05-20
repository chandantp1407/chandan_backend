package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeSecondaryInfo;

public interface EmployeeSecondaryRepository extends JpaRepository<EmployeeSecondaryInfo, Integer> {

}
