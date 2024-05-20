package com.excel.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationDetailsList;
import com.excel.lms.dto.ExperienceListDto;
import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;
import com.excel.lms.dto.TechicalSkillsListDto;
import com.excel.lms.entity.AddressDetails;
import com.excel.lms.entity.BankDetails;
import com.excel.lms.entity.Contact;
import com.excel.lms.entity.EducationDetails;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.ExperienceInfo;
import com.excel.lms.entity.TechnicalSkills;
import com.excel.lms.repository.AddressRepository;
import com.excel.lms.repository.ContactRepository;
import com.excel.lms.repository.EducationalRepository;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.repository.EmployeeSecondaryRepository;
import com.excel.lms.repository.ExperienceRepository;
import com.excel.lms.repository.TechnicalSkillRepository;
import com.excel.lms.util.ObjectUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeSecondaryRepository employeeSecondaryRepository;

	@Autowired
	private EducationalRepository educationalRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ExperienceRepository experienceRepository;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private TechnicalSkillRepository technicalSkillRepository;

	@Override
	public String savePrimary(PrimaryInfoDto dto) {

		if(!employeeRepository.findByEmployeeId(dto.getEmployeeId() ).isPresent()){

			EmployeePrimaryInfo emp=ObjectUtil.dtoToEntity(dto);
			EmployeePrimaryInfo emp1=employeeRepository.save(emp);
			return emp1.getEmployeeId();
		}
		return null;
	}

	@Override
	public String saveSecondary(SecondaryInfoDto dto) {

		Optional<EmployeePrimaryInfo> optional= employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(optional.isPresent()) {
			EmployeePrimaryInfo emp = optional.get();

			if(emp.getEmployeeSecondaryInfo() == null) {
				EmployeeSecondaryInfo employeeSecondaryInfo = ObjectUtil.dtoToEntity(dto);				 
				emp.setEmployeeSecondaryInfo(employeeSecondaryInfo);			 
				employeeSecondaryInfo.setEmployeePrimaryInfo(emp);
				return employeeRepository.save(emp).getEmployeeId();
			}
			else {

				EmployeeSecondaryInfo secondaryInfo=  emp.getEmployeeSecondaryInfo();
				secondaryInfo.setPanNo(dto.getPanNo());
				secondaryInfo.setAadharNo(dto.getAadharNo());
				secondaryInfo.setFatherName(dto.getFatherName());
				secondaryInfo.setMotherName(dto.getMotherName());
				secondaryInfo.setMaritalStatus(dto.getMaritalStatus());
				secondaryInfo.setPassportNo(dto.getPassportNo());
				secondaryInfo.setSpouseName(dto.getSpouseName());

				return employeeRepository.save(emp).getEmployeeId();				 
			}
		}	
		return null;
	}

	@Override
	public String saveBankDetails(BankDetailsDto dto) {

		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			if (employee.getBankDetails() == null) {
				BankDetails employeeBankDetails = ObjectUtil.dtoToEntity(dto);

				employee.setBankDetails(employeeBankDetails);
				employeeBankDetails.setEmployeePrimaryInfo(employee);

				return employeeRepository.save(employee).getEmployeeId();
			} else {
				BankDetails bankDetails = employee.getBankDetails();
				bankDetails.setAccountNo(dto.getAccountNo());
				bankDetails.setBankName(dto.getBankName());
				bankDetails.setAccountType(dto.getAccountType());
				bankDetails.setIfscCode(dto.getIfscCode());
				bankDetails.setBranch(dto.getBranch());
				bankDetails.setState(dto.getState());

				return employeeRepository.save(employee).getEmployeeId();
			}
		}

		return null;
	}

	@Override
	public String saveEducationDetails(EducationDetailsList dto) {
		Optional<EmployeePrimaryInfo> optional= employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			List<EducationDetails> educations=ObjectUtil.dtoToEntity(dto.getEducations());
			if(employee.getEducationDetails()!=null) {
				employee.getEducationDetails().stream().forEach(edu ->educationalRepository.delete(edu));
			}
			educations.stream().forEach(x->x.setEmployeePrimaryInfo(employee));
			employee.setEducationDetails(educations);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
		}
		return null;

	}

	@Override
	public String saveAddressDetails(AddressListDto dto) {
		Optional<EmployeePrimaryInfo> optional= employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			List<AddressDetails> addresses=ObjectUtil.dtoToAdd(dto.getAdresses());
			if(employee.getAddressDetails()!=null) {
				employee.getAddressDetails().stream().forEach(add ->addressRepository.delete(add));
			}
			addresses.stream().forEach(x->x.setEmployeePrimaryInfo(employee));
			employee.setAddressDetails(addresses);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
		}
		return null;
	}

	@Override
	public String saveExperienceInfo(ExperienceListDto dto) {
		Optional<EmployeePrimaryInfo> optional= employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			List<ExperienceInfo> experiences=ObjectUtil.dtoToExp(dto.getExperiences());
			if(employee.getExperienceInfos()!=null) {
				employee.getExperienceInfos().stream().forEach(exp->experienceRepository.delete(exp));
			}
			experiences.stream().forEach(x->x.setEmployeePrimaryInfo(employee));
			employee.setExperienceInfos(experiences);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
		}
		return null;
	}

	@Override
	public String saveContact(ContactListDto dto) {
		Optional<EmployeePrimaryInfo> optional= employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(optional.isPresent()) {
			EmployeePrimaryInfo employee = optional.get();
			List<Contact> contacts=ObjectUtil.dtoToCont(dto.getContacts());
			if(employee.getContacts()!=null) {
				employee.getContacts().stream().forEach(con->contactRepository.delete(con));
			}
			contacts.stream().forEach(x->x.setEmployeePrimaryInfo(employee));
			employee.setContacts(contacts);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
		}

		return null;
	}

	@Override
	public String saveTechnicalSkills(TechicalSkillsListDto dto) {
		Optional<EmployeePrimaryInfo> empOptional	=employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(empOptional.isPresent()) {
			EmployeePrimaryInfo employee=empOptional.get();

			List<TechnicalSkills> skills=dto.getTechnicalSkills().stream().map(skill ->{
				Optional<TechnicalSkills> optional=technicalSkillRepository.findBySkillTypeAndSkillRatingAndYearOfExperience(skill.getSkillType(), skill.getSkillRating(),
						skill.getYearOfExperience());
				return optional.isPresent()? optional.get() : ObjectUtil.dtoToSkillEntity(skill);
			}).collect(Collectors.toList());

			if(employee.getTechnicalSkills()!=null) {
				employee.getTechnicalSkills().clear();
			}
			skills.stream().forEach(x -> {
				if(!x.getEmployeePrimaryInfos().contains(employee))
					x.getEmployeePrimaryInfos().add(employee);
			});
			employee.setTechnicalSkills(skills);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
		}
		return null;
	}
}

