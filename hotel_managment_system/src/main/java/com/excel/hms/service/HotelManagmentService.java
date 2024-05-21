package com.excel.hms.service;

import java.util.List;

import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;

public interface HotelManagmentService {

	public  String saveGuest(GuestDto dto);

	public String saveRooms(RoomDto dto);

	public RoomDto getRooms(RoomDto dto);

	public RoomDto updateRooms(RoomDto dto);

	public List<RoomDto> getAllRooms();

	public String saveReservation(ReservationDtoList dto);

}
