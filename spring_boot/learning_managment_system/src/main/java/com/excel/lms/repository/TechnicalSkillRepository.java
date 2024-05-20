package com.excel.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.TechnicalSkills;

public interface TechnicalSkillRepository extends JpaRepository<TechnicalSkills, Integer> {
	Optional<TechnicalSkills> findBySkillTypeAndSkillRatingAndYearOfExperience(String skillType,double skillRating,Integer yearOfExperience);
}
