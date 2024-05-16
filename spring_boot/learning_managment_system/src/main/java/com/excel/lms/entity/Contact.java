package com.excel.lms.entity;


import com.excel.lms.enums.ContactType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="employee_contact_info")
public class Contact {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contactId;

	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	private String contactNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	private EmployeePrimaryInfo employeePrimaryInfo;

}