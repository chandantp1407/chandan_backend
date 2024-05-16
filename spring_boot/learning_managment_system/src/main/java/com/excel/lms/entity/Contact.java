package com.excel.lms.entity;

import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	private String contactType;
	private String contactNumber;
	
}
