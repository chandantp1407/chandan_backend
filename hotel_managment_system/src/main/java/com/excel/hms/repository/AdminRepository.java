package com.excel.hms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.excel.hms.entity.Admin;


public interface AdminRepository extends  JpaRepository<Admin, Integer> {

	Optional<Admin> findByAdminId(String adminId);
	Optional<Admin> findByAdminName(String adminName);


}

