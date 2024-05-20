package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.AddressDetails;

public interface AddressRepository extends JpaRepository<AddressDetails, Integer>{

}
