package com.excel.hms.util;

import java.util.ArrayList;
import java.util.List;

import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.entity.Guest;
import com.excel.hms.entity.Reservation;
import com.excel.hms.entity.Room;

public class ObjectUtil {

	public static Guest dtoToEntity(GuestDto dto) {
		return Guest.builder().firstName(dto.getFirstName()).lastName(dto.getLastName()).email(dto.getEmail())
				.phoneNumber(dto.getPhoneNumber()).address(dto.getAddress()).city(dto.getCity()).state(dto.getState())
				.zipCode(dto.getZipCode()).build();


	}

	public static Room dtoToRoomEntity(RoomDto dto) {
		return Room.builder().roomNumber(dto.getRoomNumber()).type(dto.getType())
				.rate(dto.getRate()).description(dto.getDescription()).build();
	}

	public static RoomDto RoomEntityToDto(Room room) {
		return RoomDto.builder().roomNumber(room.getRoomNumber()).type(room.getType())
				.rate(room.getRate()).description(room.getDescription()).isAvailable(room.isAvailable()).build();
	}

	public static Room updateValues(Room room, RoomDto dto) {
		room.setRoomNumber(dto.getRoomNumber());
		room.setType(dto.getType());
		room.setRate(dto.getRate());
		room.setDescription(dto.getDescription());
		room.setAvailable(dto.isAvailable());
		return room;

	}

	public static Reservation dtoToReservationEntity(ReservationDtoList dto) {

		return Reservation.builder().checkInDate(dto.getCheckInDate()).checkOutDate(dto.getCheckOutDate())
				.reservationId(dto.getReservationId()).totalAmount(dto.getTotalAmount()).rooms(new ArrayList<>()).build();
	}

	public static ReservationDto ReservationEntityToDto(Reservation dto) {

		return ReservationDto.builder().reservationId(dto.getReservationId()).checkInDate(dto.getCheckInDate()).checkOutDate(dto.getCheckOutDate()).totalAmount(dto.getTotalAmount())
				.isCancelled(dto.isCancelled()).isClosed(dto.isClosed()).build();
	}

}
