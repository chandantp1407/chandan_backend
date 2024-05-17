package com.excel.lms.dto;

import com.excel.lms.enums.AddressType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class AddressDetailsDto {
	private Integer addressId;
	private AddressType addressType;
	private String street;
	private Integer doorNo;
	private String locality;
	private String city;
	private String state;
	private Integer pincode;
	private String landmark;
}
