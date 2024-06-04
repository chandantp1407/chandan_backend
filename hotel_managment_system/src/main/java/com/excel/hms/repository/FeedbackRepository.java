package com.excel.hms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.hms.entity.Feedback;
import java.util.List;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
 
	Optional<Feedback>  findByEmail(String email);
}
