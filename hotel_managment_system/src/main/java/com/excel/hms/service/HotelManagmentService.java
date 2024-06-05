package com.excel.hms.service;

import java.util.List;

import com.excel.hms.dto.AdminDTO;
import com.excel.hms.dto.FeedbackDto;
import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.dto.StaffDTO;
import com.excel.hms.dto.SubscribeDto;

public interface HotelManagmentService {

	public  String saveGuest(GuestDto dto);

	public String saveRooms(RoomDto dto);

	public RoomDto getRooms(String roomNumber);

	public RoomDto updateRooms(RoomDto dto);

	public List<RoomDto> getAllRooms();

	public String saveReservation(ReservationDtoList dto);

	public String updateReservationByAdmin(ReservationDto dto);

	public String updateReservationByGuest(ReservationDto dto);

	public ReservationDto getReservation(Integer reservationId);

	public List<ReservationDto> getAllReservations();

	public Integer addAdminInfo(AdminDTO dto);

	public AdminDTO adminLogin(AdminDTO dto);

	public AdminDTO updateAdminPassword(AdminDTO dto);

	public List<AdminDTO> getAdmin();

	public AdminDTO getAdminById(AdminDTO dto);

	public String addStaffInfo(StaffDTO dto);

	public StaffDTO updateStaffPassword(StaffDTO dto);

	public String deleteStaff(StaffDTO dto);

	public List<GuestDto> getAllGuestDetails();

	public GuestDto updateGuest(GuestDto dto);

	public String deleteGuest(GuestDto dto);

	public String addMessage(FeedbackDto dto);

	public List<FeedbackDto> getAllData();

	public String addSubscribe(SubscribeDto dto);

}
