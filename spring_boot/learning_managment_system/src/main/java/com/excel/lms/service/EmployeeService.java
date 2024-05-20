package com.excel.lms.service;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.BankDetailsDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationDetailsDto;
import com.excel.lms.dto.EducationDetailsList;
import com.excel.lms.dto.ExperienceListDto;
import com.excel.lms.dto.PrimaryInfoDto;
import com.excel.lms.dto.SecondaryInfoDto;
import com.excel.lms.dto.TechicalSkillsListDto;

public interface EmployeeService {

	public String savePrimary(PrimaryInfoDto dto);

	public String saveSecondary(SecondaryInfoDto dto);

	public String saveBankDetails(BankDetailsDto dto);

	public String saveEducationDetails(EducationDetailsList dto);

	public String saveAddressDetails(AddressListDto dto);

	public String saveExperienceInfo(ExperienceListDto dto);

	public String saveContact(ContactListDto dto);

	public String saveTechnicalSkills(TechicalSkillsListDto dto);

}
