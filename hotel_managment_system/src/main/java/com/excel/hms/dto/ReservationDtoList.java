package com.excel.hms.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Builder
public class ReservationDtoList {

	private String reservationId;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private double totalAmount;

	private GuestDto guestDto;

	private String roomNumber;
	private List<Integer> rooms;
}
