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
@Table(name="employee_address_info")
public class AddressInfo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	private String addressType;
	private String street;
	private Integer doorNo;
	private String locality;
	private String city;
	private String state;
	private Integer pincode;
	private String landmark;
}
