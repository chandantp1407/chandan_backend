package com.excelsoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelsoft.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByUsername(String username);

}
