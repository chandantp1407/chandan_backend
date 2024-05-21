package com.excel.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.response.CommonResponse;
import com.excel.hms.service.HotelManagmentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/hotelmanagment")
public class HotelManagmentController {

	@Autowired
	private HotelManagmentService hotelManagmentService;


	@PostMapping(path = "/guest")
	public ResponseEntity<CommonResponse<String>> postGuestDetails(@RequestBody GuestDto dto  ){
		String guest=hotelManagmentService.saveGuest(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(guest)
						.isError(false).message("Guest deatils saved succesfully").build());

	}
	@PostMapping(path = "/rooms")
	public ResponseEntity<CommonResponse<String>> postRoomsDetails(@RequestBody RoomDto dto  ){
		String room=hotelManagmentService.saveRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(room)
						.isError(false).message("Room deatils saved succesfully").build());

	}
	@GetMapping(path = "/getrooms")
	public ResponseEntity<CommonResponse<RoomDto>> getRoomsDetails(@RequestBody RoomDto dto ){
		RoomDto room=hotelManagmentService.getRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<RoomDto>builder().data(room)
						.isError(false).message("Room deatils getting succesfully").build());

	}
	@PutMapping(path = "/updateroom")
	public ResponseEntity<CommonResponse<RoomDto>> updateRoomsDetails(@RequestBody RoomDto dto ){
		RoomDto update=hotelManagmentService.updateRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<RoomDto>builder().data(update)
						.isError(false).message("Room deatils updated succesfully").build());

	}
	@GetMapping(path = "/getAllrooms")
	public ResponseEntity<CommonResponse<List<RoomDto>>> getAllRoomsDetails() {
		List<RoomDto> rooms=hotelManagmentService.getAllRooms();
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<List<RoomDto>>builder().data(rooms)
						.isError(false).message("Rooms deatils getting succesfully").build());

	}
	@PostMapping(path = "/reservation")
	public ResponseEntity<CommonResponse<String>> postRervationDetails(@RequestBody ReservationDtoList dto  ){
		String room=hotelManagmentService.saveReservation(dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonResponse.<String>builder().data(room)
						.isError(false).message("Reservation  deatils saved succesfully").build());

	}
}
