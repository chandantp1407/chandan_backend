package com.excel.hms.service;

import java.util.List;
import static com.excel.hms.constant.GuestConstant.GUEST_DETAILS_DELETED_MESSAGE;
import static com.excel.hms.constant.GuestConstant.GUEST_EMAIL_FOUND_MESSAGE;
import static com.excel.hms.constant.GuestConstant.GUEST_EMAIL_NOTFOUND_MESSAGE;
import static com.excel.hms.constant.RoomConstant.ROOMNUMBER_FOUND_MESSAGE;
import static com.excel.hms.constant.RoomConstant.ROOMNUMBER_NOTFOUND_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_NOTFOUND_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_CLOSED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_CANCELLED_MESSAGE;
import static com.excel.hms.constant.ReservationConstant.RESERVATION_DETAILS_SAVED_MESSAGE;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.hms.dto.AdminDTO;
import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.dto.StaffDTO;
import com.excel.hms.entity.Admin;
import com.excel.hms.entity.Guest;
import com.excel.hms.entity.Reservation;
import com.excel.hms.entity.Room;
import com.excel.hms.entity.Staff;
import com.excel.hms.exception.AdminExistenceException;
import com.excel.hms.exception.HotelException;
import com.excel.hms.repository.AdminRepository;
import com.excel.hms.repository.GuestRepository;
import com.excel.hms.repository.ReservationRepository;
import com.excel.hms.repository.RoomRepository;
import com.excel.hms.repository.StaffRepository;
import com.excel.hms.util.AdminUtil;
import com.excel.hms.util.ObjectUtil;
import com.excel.hms.util.StaffUtil;

import jakarta.persistence.NonUniqueResultException;

@Service
public class HotelManagmentServiceImpl implements HotelManagmentService{

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StaffRepository staffRepository;

	
	@Override
	public String saveGuest(GuestDto dto) {
		if(!guestRepository.findByEmail(dto.getEmail()).isPresent()) {
			Guest guest	=ObjectUtil.dtoToEntity(dto);
			Guest guest1=guestRepository.save(guest);
			return guest1.getEmail();

		}
		throw new HotelException(GUEST_EMAIL_FOUND_MESSAGE);
	}

	@Override
	public List<GuestDto> getAllGuestDetails() {
		try {
			return guestRepository.findAll().stream()
					.map(ObjectUtil::GuestEntityToDto).toList();
		} catch (Exception e) {
			throw new HotelException("Failed to retrieve Guests: " + e.getMessage());
		}
	}

	@Override
	public GuestDto updateGuest(GuestDto dto) {
		Optional<Guest> optional=guestRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			Guest guest=optional.get();
			guest=ObjectUtil.updateGuest(guest,dto);
			Guest save=guestRepository.save(guest);
			return ObjectUtil.GuestEntityToDto(save);
		}
		throw new HotelException(GUEST_EMAIL_NOTFOUND_MESSAGE);
	}

	@Override
	public String deleteGuest(GuestDto dto) {
	
		Optional<Guest> optional=guestRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			Guest guest=optional.get();
			guestRepository.delete(guest);
			return GUEST_DETAILS_DELETED_MESSAGE;
		}
		throw new HotelException(GUEST_EMAIL_NOTFOUND_MESSAGE);
	}

	@Override
	public String saveRooms(RoomDto dto) {
		if(!roomRepository.findByRoomNumber(dto.getRoomNumber()).isPresent()) {
			Room room=ObjectUtil.dtoToRoomEntity(dto);
			room.setAvailable(true);
			Room room1=roomRepository.save(room);
			return room1.getRoomNumber();
		}
		throw new HotelException(ROOMNUMBER_FOUND_MESSAGE);
	}

	@Override
	public RoomDto getRooms(String roomNumber) {
		Optional<Room> optional	=roomRepository.findByRoomNumber(roomNumber);
		if(optional.isPresent()) {
			Room rooms=optional.get();
			RoomDto room=ObjectUtil.RoomEntityToDto(rooms);
			return room;
		}
		throw new HotelException(ROOMNUMBER_NOTFOUND_MESSAGE);
	}

	@Override
	public RoomDto updateRooms(RoomDto dto) {
		Optional<Room> optional	=roomRepository.findByRoomNumber(dto.getRoomNumber());
		if(optional.isPresent()) {
			Room room=optional.get();
			room=ObjectUtil.updateValues(room,dto);
			Room save=roomRepository.save(room);
			return ObjectUtil.RoomEntityToDto(save);
		}
		throw new HotelException(ROOMNUMBER_NOTFOUND_MESSAGE);
	}

	@Override
	public List<RoomDto> getAllRooms() {
		try {
			return roomRepository.findAll().stream()
					.map(ObjectUtil::RoomEntityToDto).toList();
		} catch (Exception e) {
			throw new HotelException("Failed to retrieve rooms: " + e.getMessage());
		}
	}

	@Override
	public String saveReservation(ReservationDtoList dto) {
		Optional<Guest> optional=guestRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			Guest guest=optional.get();
			Reservation reservation=ObjectUtil.dtoToReservationEntity(dto);
			guest.getReservations().add(reservation);
			reservation.setGuest(guest);

			List<Integer> rooms = dto.getRooms();
			List<Room>	roomsList=dto.getRooms().stream().map(i->{
				Optional<Room> r=roomRepository.findById(i);
				return r.get();
			}).toList();

			roomsList.stream().forEach(room -> room.getReservations().add(reservation));
			reservation.setRooms(roomsList);
			guestRepository.save(guest);
			roomRepository.saveAll(roomsList);
			reservationRepository.save(reservation);
			return RESERVATION_DETAILS_SAVED_MESSAGE;
		}

		else {
			throw new HotelException(GUEST_EMAIL_NOTFOUND_MESSAGE);
		}
	}

	@Override
	public String updateReservationByAdmin(ReservationDto dto) {
		try {
			Optional<Reservation> resOptional= reservationRepository.findByReservationId(dto.getReservationId());
			if(resOptional.isPresent()) {
				Reservation reservation = resOptional.get();
				reservation.setClosed(true);
				Reservation save=reservationRepository.save(reservation);
				return RESERVATION_CLOSED_MESSAGE;
			} else {
				return RESERVATION_NOTFOUND_MESSAGE;
			}
		} catch (NonUniqueResultException e) {
			return "Multiple reservations found for the given ID";

		} catch (Exception e) {
			return "An error occurred: " + e.getMessage();
		}
	}

	@Override
	public String updateReservationByGuest(ReservationDto dto) {
		try {
			Optional<Reservation> resOptional= reservationRepository.findByReservationId(dto.getReservationId());
			if(resOptional.isPresent()) {
				Reservation reservation = resOptional.get();
				reservation.setCancelled(true);
				reservationRepository.save(reservation);
				return RESERVATION_CANCELLED_MESSAGE;
			} else {
				return RESERVATION_NOTFOUND_MESSAGE;
			}
		} catch (NonUniqueResultException e) {
			return "Multiple reservations found for the given ID";

		} catch (Exception e) {
			return "An error occurred: " + e.getMessage();
		}
	}

	@Override
	public ReservationDto getReservation(Integer reservationId) {
		Optional<Reservation> optional	=reservationRepository.findByReservationId(reservationId);
		if(optional.isPresent()) {
			Reservation reservation=optional.get();
			ReservationDto reservation1=ObjectUtil.ReservationEntityToDto(reservation);
			return reservation1;
		}
		throw new HotelException(RESERVATION_NOTFOUND_MESSAGE);

	}

	@Override
	public List<ReservationDto> getAllReservations() {
		try {
			return reservationRepository.findAll().stream()
					.map(ObjectUtil::ReservationEntityToDto).toList();
		} catch (Exception e) {
			throw new HotelException("Failed to retrieve reservations: " + e.getMessage());
		}

	}

	@Override
	public Integer addAdminInfo(AdminDTO dto) {
		Admin admin = AdminUtil.dtoToEntity(dto);
		if(!adminRepository.findByAdminName(dto.getAdminName()).isPresent()) 
		{
			Admin save = adminRepository.save(admin);
			return save.getAdminNo();
		}
		throw new AdminExistenceException("Admin name is already present");
	}

	@Override
	public String adminLogin(AdminDTO dto) {
		Optional<Admin> optional = adminRepository.findByAdminName(dto.getAdminName());
		if (optional.isPresent()) {
			Admin admin = optional.get();
			if (admin.getPassword().equals(dto.getPassword())) {
				return admin.getRoleType().getRoleType();
			} else {
				throw new AdminExistenceException("Invalid Password!");
			}
		}
		throw new AdminExistenceException("Invalid Username!");
	}

	@Override
	public AdminDTO updateAdminPassword(AdminDTO dto) {
		Optional<Admin> optional = adminRepository.findByAdminNo(dto.getAdminNo());
		if(optional.isPresent()) {
			Admin password = optional.get();
			password = AdminUtil.updatepassword(password,dto);
			Admin save = adminRepository.save(password);
			return AdminUtil.dtoToEntity(save);
		}
		throw new AdminExistenceException("Password is Not Valid!");
	}

	@Override
	public List<AdminDTO> getAdmin() {
		return adminRepository.findAll().stream().map(x->AdminDTO.builder().adminNo(x.getAdminNo()).adminName(x.getAdminName()).password(x.getPassword()).roleType(x.getRoleType()).build()).toList();
	}

	@Override
	public AdminDTO getAdminById(AdminDTO dto) {
		Optional<Admin> optional = adminRepository.findByAdminNo(dto.getAdminNo());
		if(optional.isPresent()) {
			Admin admin = optional.get();
			return AdminUtil.dtoToGetEntity(admin);
		}else {
			throw new AdminExistenceException("Employee Id Not Found");
		}
	}

	@Override
	public String addStaffInfo(StaffDTO staffDto)  {
		if (!isAdmin(staffDto.getAdminNo())) {
			throw new AdminExistenceException("Only admins are allowed to add staff details");
		}
		Staff staff = StaffUtil.dtoToEntity(staffDto);
		if (!staffRepository.findByStaffId(staffDto.getStaffId()).isPresent()) {
			Staff savedStaff = staffRepository.save(staff);
			return savedStaff.getStaffId();
		}
		throw new AdminExistenceException("Staff Id is already present");
	}
	private boolean isAdmin(Integer adminNo) {
		Optional<Admin> adminOptional = adminRepository.findById(adminNo);
		return adminOptional.isPresent();
	}

	@Override
	public StaffDTO updateStaffPassword(StaffDTO dto) {
		if(!isAdmin(dto.getAdminNo())) {
			throw new AdminExistenceException("Only Admins Can Update Staff Password");
		}
		Optional<Staff> optional = staffRepository.findByStaffId(dto.getStaffId());
		if(optional.isPresent()) {
			Staff password = optional.get();
			password = StaffUtil.updatePassword(password,dto);
			Staff save = staffRepository.save(password);
			return StaffUtil.dtoToEntity(save);
		}
		throw new AdminExistenceException("Password is Not Valid!");
	}

	@Override
	public String deleteStaff(StaffDTO dto) {
		if(!isAdmin(dto.getAdminNo())) {
			throw new AdminExistenceException("Only Admins Can Delete Staff Info ");
		}
		Optional<Staff> optional = staffRepository.findByStaffId(dto.getStaffId());
		if(optional.isPresent()) {
			staffRepository.delete(optional.get());
			return "Staff Deleted Succesfully!!";
		}
		throw new AdminExistenceException("Staff Id not Found!");
	}

}

