package com.excel.hms.controller;

import java.util.List;

import static com.excel.hms.constant.GuestConstant.GUEST_DETAILS_SAVED_MESSAGE;
import static com.excel.hms.constant.GuestConstant.GUESTS_DETAILS_FETCHED_MESSAGE;
import static com.excel.hms.constant.GuestConstant.GUEST_DETAILS_UPDATED_MESSAGE;
import static com.excel.hms.constant.GuestConstant.GUEST_DETAILS_DELETED_MESSAGE;
import static com.excel.hms.constant.RoomConstant.ROOM_DETAILS_SAVED_MESSAGE;
import static com.excel.hms.constant.RoomConstant.ROOM_DETAILS_FETCHED_MESSAGE;
import static com.excel.hms.constant.RoomConstant.ROOM_DETAILS_UPDATED_MESSAGE;
import static com.excel.hms.constant.RoomConstant.ROOMS_DETAILS_FETCHED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_DETAILS_SAVED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_DETAILS_FETCHED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATIONS_DETAILS_FETCHED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_CLOSED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_CANCELLED_MESSAGE;
import static com.excel.hms.constant.AdminConstant.ADMIN_REGISTER_MESSAGE;
import static com.excel.hms.constant.AdminConstant.ADMIN_LOGIN_MESSAGE;
import static com.excel.hms.constant.AdminConstant.ADMIN_DETAILS_FETCH_MESSAGE;
import static com.excel.hms.constant.AdminConstant.ADMINS_DETAILS_FETCH_MESSAGE;
import static com.excel.hms.constant.AdminConstant.PASSWORD_CHANGED_MESSAGE;
import static com.excel.hms.constant.AdminConstant.STAFF_INFORMATION_SAVED_MESSAGE;
import static com.excel.hms.constant.AdminConstant.STAFF_PASSWORD_UPDATED_MESSAGE;
import static com.excel.hms.constant.AdminConstant.STAFF_DELETED_MESSAGE;
import static com.excel.hms.constant.GuestConstant.GUEST_MESSAGE_SAVED_SUCCESS;
import static com.excel.hms.constant.GuestConstant.SUBSCRIPTION_SUCCESSFULL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excel.hms.dto.AdminDTO;
import com.excel.hms.dto.FeedbackDto;
import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.dto.StaffDTO;
import com.excel.hms.dto.SubscribeDto;
import com.excel.hms.response.CommonResponse;
import com.excel.hms.service.HotelManagmentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/hotelmanagment")
@CrossOrigin
public class HotelManagmentController {

	@Autowired
	private HotelManagmentService hotelManagmentService;

	@PostMapping(path = "/guest")
	public ResponseEntity<CommonResponse<String>> postGuestDetails(@RequestBody GuestDto dto) {
		String guest = hotelManagmentService.saveGuest(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(guest)
				.isError(false).message(GUEST_DETAILS_SAVED_MESSAGE).build());

	}
	@GetMapping(path = "/getAllGuests")
	public ResponseEntity<CommonResponse<List<GuestDto>>> getAllGuestDetails() {
		List<GuestDto> rooms = hotelManagmentService.getAllGuestDetails();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<GuestDto>>builder().data(rooms)
				.isError(false).message(GUESTS_DETAILS_FETCHED_MESSAGE).build());

	}
	@PutMapping(path = "/updateguest")
	public ResponseEntity<CommonResponse<GuestDto>> updateGuestDetails(@RequestBody GuestDto dto) {
		GuestDto update = hotelManagmentService.updateGuest(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<GuestDto>builder().data(update)
				.isError(false).message(GUEST_DETAILS_UPDATED_MESSAGE).build());
	}
	@DeleteMapping("/deleteguest")
	public ResponseEntity<CommonResponse<String>> deleteStaff(@RequestBody GuestDto dto){
		hotelManagmentService.deleteGuest(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder()
				.isError(false).message(GUEST_DETAILS_DELETED_MESSAGE).build());
	}

	@PostMapping(path = "/rooms")
	public ResponseEntity<CommonResponse<String>> postRoomsDetails(@RequestBody RoomDto dto) {
		String room = hotelManagmentService.saveRooms(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(room).isError(false)
				.message(ROOM_DETAILS_SAVED_MESSAGE).build());

	}

	@GetMapping(path = "/getroom")
	public ResponseEntity<CommonResponse<RoomDto>> getRoomsDetails(@RequestParam(name = "roomNumber") String roomNumber) {
	
		RoomDto room = hotelManagmentService.getRooms(roomNumber);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<RoomDto>builder().data(room)
				.isError(false).message(ROOM_DETAILS_FETCHED_MESSAGE).build());
	}

	@PutMapping(path = "/updateroom")
	public ResponseEntity<CommonResponse<RoomDto>> updateRoomsDetails(@RequestBody RoomDto dto) {
		RoomDto update = hotelManagmentService.updateRooms(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<RoomDto>builder().data(update)
				.isError(false).message(ROOM_DETAILS_UPDATED_MESSAGE).build());
	}

	@GetMapping(path = "/getAllrooms")
	public ResponseEntity<CommonResponse<List<RoomDto>>> getAllRoomsDetails() {
		List<RoomDto> rooms = hotelManagmentService.getAllRooms();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<RoomDto>>builder().data(rooms)
				.isError(false).message(ROOMS_DETAILS_FETCHED_MESSAGE).build());

	}

	@PostMapping(path = "/reservation")
	public ResponseEntity<CommonResponse<String>> postRervationDetails(@RequestBody ReservationDtoList dto) {
		String room = hotelManagmentService.saveReservation(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(room).isError(false)
				.message(RESERVATION_DETAILS_SAVED_MESSAGE).build());
	}

	@PutMapping(path = "/updatereservationsforclosed")
	public ResponseEntity<CommonResponse<String>> updateReservationsDetails(@RequestBody ReservationDto dto) {
		String update = hotelManagmentService.updateReservationByAdmin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<String>builder().data(update)
				.isError(false).message(RESERVATION_CLOSED_MESSAGE).build());
	}

	@PutMapping(path = "/updatereservationsforcancellation")
	public ResponseEntity<CommonResponse<String>> updateReservationsByGuestDetails(@RequestBody ReservationDto dto) {
		String update = hotelManagmentService.updateReservationByGuest(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<String>builder().data(update)
				.isError(false).message(RESERVATION_CANCELLED_MESSAGE).build());
	}
	@GetMapping(path = "/getreservation")
	public ResponseEntity<CommonResponse<ReservationDto>> getReservationDetails(@RequestParam(name = "reservationId") Integer reservationId) {
		ReservationDto reservation = hotelManagmentService.getReservation(reservationId);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<ReservationDto>builder().data(reservation)
				.isError(false).message(RESERVATION_DETAILS_FETCHED_MESSAGE).build());
	}
	@GetMapping(path = "/getallreservations")
	public ResponseEntity<CommonResponse<List<ReservationDto>>> getAllReservationsDetails() {
		List<ReservationDto> rooms = hotelManagmentService.getAllReservations();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<ReservationDto>>builder().data(rooms)
				.isError(false).message(RESERVATIONS_DETAILS_FETCHED_MESSAGE).build());
	}
	
	@PostMapping("/register")
	public ResponseEntity<CommonResponse<Integer>>postAdminInfo(@RequestBody AdminDTO dto){
		Integer adminId = hotelManagmentService.addAdminInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<Integer>builder().data(adminId)
				.isError(false).message(ADMIN_REGISTER_MESSAGE).build());	
	}

	@PostMapping("/login")
	public ResponseEntity<CommonResponse<AdminDTO>>postAdminLogin(@RequestBody AdminDTO dto){
		AdminDTO adminName = hotelManagmentService.adminLogin(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<AdminDTO>builder().data(adminName)
				.isError(false).message(ADMIN_LOGIN_MESSAGE).build());	
	}
	@PutMapping("/update")
	public ResponseEntity<CommonResponse<AdminDTO>> updateAdminPassword(@RequestBody AdminDTO dto){
		AdminDTO adminPass = hotelManagmentService.updateAdminPassword(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<AdminDTO>builder().data(adminPass)
				.isError(false).message(PASSWORD_CHANGED_MESSAGE).build());
	}
	@GetMapping("/getAll")
	public ResponseEntity<CommonResponse<List<AdminDTO>>>fetchAllAdminInfo(){
		List<AdminDTO> dto = hotelManagmentService.getAdmin();
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<AdminDTO>>builder().data(dto)
				.isError(false).message(ADMINS_DETAILS_FETCH_MESSAGE).build());
	}
	@GetMapping("/getById")
	public ResponseEntity<CommonResponse<AdminDTO>>fetchById(@RequestBody AdminDTO dto){
		AdminDTO admin = hotelManagmentService.getAdminById(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<AdminDTO>builder().data(admin)
				.isError(false).message(ADMIN_DETAILS_FETCH_MESSAGE).build());
	}
	@PostMapping("/sinfo")
	public ResponseEntity<CommonResponse<String>> postStaffInfo(@RequestBody StaffDTO dto){
		String staff = hotelManagmentService.addStaffInfo(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(staff)
				.isError(false).message(STAFF_INFORMATION_SAVED_MESSAGE).build());
	}
	@PutMapping("/updateStaff")
	public ResponseEntity<CommonResponse<StaffDTO>> updateStaffPassword(@RequestBody StaffDTO dto){
		StaffDTO staffPass = hotelManagmentService.updateStaffPassword(dto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<StaffDTO>builder()
				.data(staffPass).isError(false).message(STAFF_PASSWORD_UPDATED_MESSAGE).build());
	}
	@DeleteMapping("/staffDelete")
	public ResponseEntity<CommonResponse<String>> deleteStaff(@RequestBody StaffDTO dto){
		hotelManagmentService.deleteStaff(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder()
				.isError(false).message(STAFF_DELETED_MESSAGE).build());
	}
	@PostMapping("/message")
	public ResponseEntity<CommonResponse<String>> message(@RequestBody FeedbackDto dto){
		String contact = hotelManagmentService.addMessage(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(contact)
				.isError(false).message(GUEST_MESSAGE_SAVED_SUCCESS).build());
	}
	
	@GetMapping(path = "/getAllData")
	public ResponseEntity<CommonResponse<List<FeedbackDto>>> getAll(){
		List<FeedbackDto> contact = hotelManagmentService.getAllData();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(CommonResponse.<List<FeedbackDto>>builder().data(contact)
				.isError(false).message("Fetch all the data Successfuly").build());
	}
	@PostMapping(path = "/subscribe")
	public ResponseEntity<CommonResponse<String>> subscribe(@RequestBody SubscribeDto dto){
		String subscribe = hotelManagmentService.addSubscribe(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(CommonResponse.<String>builder().data(subscribe)
				.isError(false).message(SUBSCRIPTION_SUCCESSFULL).build());
	}
}
