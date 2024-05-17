package com.excel.lms.entity;

import java.time.Year;

import com.excel.lms.enums.AddressType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="employee_address_info")
public class AddressDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	private String street;
	private Integer doorNo;
	private String locality;
	private String city;
	private String state;
	private Integer pincode;
	private String landmark;
	
	@JoinColumn(name = "employee_id")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private EmployeePrimaryInfo employeePrimaryInfo;
}
