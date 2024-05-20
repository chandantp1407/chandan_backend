package com.excel.lms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.excel.lms.dto.AddressDetailsDto;
import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.ContactDto;
import com.excel.lms.dto.EducationDetailsDto;
import com.excel.lms.dto.ExperienceInfoDto;
import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;
import com.excel.lms.dto.TechnicalSkillsDto;
import com.excel.lms.entity.AddressDetails;
import com.excel.lms.entity.BankDetails;
import com.excel.lms.entity.Contact;
import com.excel.lms.entity.EducationDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.ExperienceInfo;
import com.excel.lms.entity.TechnicalSkills;

public class ObjectUtil {

	public static EmployeePrimaryInfo dtoToEntity(PrimaryInfoDto dto) {

		return EmployeePrimaryInfo.builder().primaryInfoId(dto.getPrimaryInfoId()).employeeId(dto.getEmployeeId()
				).employeeName(dto.getEmployeeName()).dateOfJoining(dto.getDateOfJoining()).dateOfBirth(dto.getDateOfBirth())
				.bloodGroup(dto.getBloodGroup()).email(dto.getEmail()).designation(dto.getDesignation()).gender(dto.getGender())
				.gender(dto.getGender()).nationality(dto.getNationality()).employeeStatus(dto.getEmployeeStatus()).build();
	}
	public static EmployeeSecondaryInfo dtoToEntity(SecondaryInfoDto dto) {

		return EmployeeSecondaryInfo.builder().panNo(dto.getPanNo()).aadharNo(dto.getAadharNo()).fatherName(dto.getFatherName())
				.motherName(dto.getMotherName()).spouseName(dto.getSpouseName()).maritalStatus(dto.getMaritalStatus()).passportNo(dto.getPassportNo())
				.build();
	}

	public static BankDetails dtoToEntity(BankDetailsDto dto) {

		return BankDetails.builder().accountNo(dto.getAccountNo()).bankName(dto.getBankName()).accountType(dto.getAccountType())
				.ifscCode(dto.getIfscCode()).branch(dto.getBranch()).state(dto.getState()).build();
	}

	public static List<EducationDetails> dtoToEntity(List<EducationDetailsDto> dtolist) {

		return dtolist.stream()
				.map(edu -> EducationDetails.builder().yearOfPassing(edu.getYearOfPassing())
						.educationType(edu.getEducationType()).specialization(edu.getSpecialization())
						.percentage(edu.getPercentage()).state(edu.getState())
						.universityName(edu.getUniversityName()).build())
				.collect(Collectors.toList());
	}
	public static List<AddressDetails> dtoToAdd(List<AddressDetailsDto> adresses) {

		return adresses.stream()
				.map(add ->AddressDetails.builder().addressType(add.getAddressType()).street(add.getStreet())
						.doorNo(add.getDoorNo()).locality(add.getLocality()).city(add.getCity()).state(add.getState())
						.pincode(add.getPincode()).landmark(add.getLandmark()).build())
				.collect(Collectors.toList());
	}
	public static List<ExperienceInfo> dtoToExp(List<ExperienceInfoDto> experiences) {

		return experiences.stream()
				.map(ex ->ExperienceInfo.builder().companyName(ex.getCompanyName()).dateOfJoining(ex.getDateOfJoining())
						.dateOfRelieving(ex.getDateOfRelieving()).yearOfExperience(ex.getYearOfExperience())
						.designation(ex.getDesignation()).location(ex.getLocation()).build())
				.collect(Collectors.toList());
	}
	public static List<Contact> dtoToCont(List<ContactDto> contacts) {
		return contacts.stream()
				.map(con->Contact.builder().contactType(con.getContactType()).contactNumber(con.getContactNumber()).build()).collect(Collectors.toList());
	}
	public static TechnicalSkills dtoToSkillEntity(TechnicalSkillsDto skill) {
		return TechnicalSkills.builder().skillType(skill.getSkillType()).skillRating(skill.getSkillRating()).yearOfExperience(skill.getYearOfExperience())
				.employeePrimaryInfos(new ArrayList<>())
				.build();

	}


}
