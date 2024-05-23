package com.excel.hms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excel.hms.dto.AdminDTO;
import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.dto.StaffDTO;
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
	public ResponseEntity<CommonResponse<String>> postGuestDetails(@RequestBody GuestDto dto) {
		String guest = hotelManagmentService.saveGuest(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(guest)
				.isError(false).message("Guest deatils saved succesfully").build());

	}

	@PostMapping(path = "/rooms")
	public ResponseEntity<CommonResponse<String>> postRoomsDetails(@RequestBody RoomDto dto) {
		String room = hotelManagmentService.saveRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(room).isError(false)
				.message("Room deatils saved succesfully").build());

	}

	@GetMapping(path = "/getrooms")
	public ResponseEntity<CommonResponse<RoomDto>> getRoomsDetails(@RequestBody RoomDto dto) {
		RoomDto room = hotelManagmentService.getRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<RoomDto>builder().data(room)
				.isError(false).message("Room deatils getting succesfully").build());
	}

	@PutMapping(path = "/updateroom")
	public ResponseEntity<CommonResponse<RoomDto>> updateRoomsDetails(@RequestBody RoomDto dto) {
		RoomDto update = hotelManagmentService.updateRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<RoomDto>builder().data(update)
				.isError(false).message("Room deatils updated succesfully").build());
	}

	@GetMapping(path = "/getAllrooms")
	public ResponseEntity<CommonResponse<List<RoomDto>>> getAllRoomsDetails() {
		List<RoomDto> rooms = hotelManagmentService.getAllRooms();
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<List<RoomDto>>builder().data(rooms)
				.isError(false).message("Rooms deatils getting succesfully").build());

	}

	@PostMapping(path = "/reservation")
	public ResponseEntity<CommonResponse<String>> postRervationDetails(@RequestBody ReservationDtoList dto) {
		String room = hotelManagmentService.saveReservation(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(room).isError(false)
				.message("Reservation  deatils saved succesfully").build());
	}

	@PutMapping(path = "/updatereservationsbyadmin")
	public ResponseEntity<CommonResponse<String>> updateReservationsDetails(@RequestBody ReservationDto dto) {
		String update = hotelManagmentService.updateReservationByAdmin(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(update)
				.isError(false).message("Reservation deatils updated succesfully").build());
	}

	@PutMapping(path = "/updatereservationsbyguest")
	public ResponseEntity<CommonResponse<String>> updateReservationsByGuestDetails(@RequestBody ReservationDto dto) {
		String update = hotelManagmentService.updateReservationByGuest(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(update)
				.isError(false).message("Reservation deatils updated succesfully").build());
	}

	@GetMapping(path = "/getreservation")
	public ResponseEntity<CommonResponse<ReservationDto>> getReservationDetails(@RequestBody ReservationDto dto) {
		ReservationDto room = hotelManagmentService.getReservation(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<ReservationDto>builder().data(room)
				.isError(false).message("Reservation deatils getting succesfully").build());
	}

	@GetMapping(path = "/getallreservations")
	public ResponseEntity<CommonResponse<List<ReservationDto>>> getAllReservationsDetails() {
		List<ReservationDto> rooms = hotelManagmentService.getAllReservations();
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<List<ReservationDto>>builder().data(rooms)
				.isError(false).message("Reservations deatils getting succesfully").build());
	}
	@PostMapping("/register")
	public ResponseEntity<CommonResponse<String>>postAdminInfo(@RequestBody AdminDTO dto){
		String adminId = hotelManagmentService.addAdminInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(adminId).isError(false).message("Admin Registered Successfully").build());	
	}

	@PostMapping("/login")
	public ResponseEntity<CommonResponse<String>>postAdminLogin(@RequestBody AdminDTO dto){
		String adminName = hotelManagmentService.adminLogin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<String>builder().data(adminName).isError(false).message("Admin Login Succesfully").build());	
	}
	@PutMapping("/update")
	public ResponseEntity<CommonResponse<AdminDTO>> updateAdminPassword(@RequestBody AdminDTO dto){
		AdminDTO adminPass = hotelManagmentService.updateAdminPassword(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<AdminDTO>builder().data(adminPass).isError(false).message("Password updated successfully").build());
	}
	@GetMapping("/getAll")
	public ResponseEntity<CommonResponse<List<AdminDTO>>>fetchAllAdminInfo(@RequestBody AdminDTO admin){
		List<AdminDTO> dto = hotelManagmentService.getAdmin(admin);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<AdminDTO>>builder().data(dto).isError(false).message("Successfully Fetch All Admins").build());
	}
	@GetMapping("/getById")
	public ResponseEntity<CommonResponse<AdminDTO>>fetchById(@RequestBody AdminDTO dto){
		AdminDTO admin = hotelManagmentService.getAdminById(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<AdminDTO>builder().data(admin).isError(false).message("Fetch Admin By id Successfully!").build());
	}
	@PostMapping("/sinfo")
	public ResponseEntity<CommonResponse<String>> postStaffInfo(@RequestBody StaffDTO dto){
		String staff = hotelManagmentService.addStaffInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(staff).isError(false).message("Staff Info Added Successfully!").build());
	}
	@PutMapping("/updateStaff")
	public ResponseEntity<CommonResponse<StaffDTO>> updateStaffPassword(@RequestBody StaffDTO dto){
		StaffDTO staffPass = hotelManagmentService.updateStaffPassword(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<StaffDTO>builder().data(staffPass).isError(false).message("Staff Password Successfully!").build());
	}
	@DeleteMapping("/staffDelete")
	public ResponseEntity<CommonResponse<String>> deleteStaff(@RequestBody StaffDTO dto){
		hotelManagmentService.deleteStaff(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().isError(false).message("Staff Deleted Successfully!").build());
	}
}
