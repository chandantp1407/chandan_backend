package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EducationDetails;

public interface EducationalRepository extends JpaRepository<EducationDetails, Integer>{

}
