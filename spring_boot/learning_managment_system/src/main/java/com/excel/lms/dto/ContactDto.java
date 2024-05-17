package com.excel.lms.dto;

import com.excel.lms.enums.ContactType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class ContactDto {
	private Integer contactId;
	private ContactType contactType;
	private String contactNumber;
}
