package com.excel.hms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excel.hms.dto.GuestDto;
import com.excel.hms.dto.ReservationDto;
import com.excel.hms.dto.ReservationDtoList;
import com.excel.hms.dto.RoomDto;
import com.excel.hms.entity.Guest;
import com.excel.hms.entity.Reservation;
import com.excel.hms.entity.Room;
import com.excel.hms.exception.HotelException;
import com.excel.hms.repository.GuestRepository;
import com.excel.hms.repository.ReservationRepository;
import com.excel.hms.repository.RoomRepository;
import com.excel.hms.util.ObjectUtil;

import jakarta.persistence.NonUniqueResultException;

@Service
public class HotelManagmentServiceImpl implements HotelManagmentService{

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public String saveGuest(GuestDto dto) {
		if(!guestRepository.findByEmail(dto.getEmail()).isPresent()) {
			Guest guest	=ObjectUtil.dtoToEntity(dto);
			Guest guest1=guestRepository.save(guest);
			return guest1.getEmail();

		}

		throw new HotelException("Guest Email is Already Found");
	}

	@Override
	public String saveRooms(RoomDto dto) {
		if(!roomRepository.findByRoomNumber(dto.getRoomNumber()).isPresent()) {
			Room room=ObjectUtil.dtoToRoomEntity(dto);
			room.setAvailable(true);
			Room room1=roomRepository.save(room);
			return room1.getRoomNumber();
		}
		throw new HotelException("Room number is Already present");
	}

	@Override
	public RoomDto getRooms(RoomDto dto) {
		Optional<Room> optional	=roomRepository.findByRoomNumber(dto.getRoomNumber());
		if(optional.isPresent()) {
			Room rooms=optional.get();
			RoomDto room=ObjectUtil.RoomEntityToDto(rooms);
			return room;
		}
		throw new HotelException("Room number is not Found");
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
		throw new HotelException("Room number is not Found");
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
		Optional<Guest> optional=guestRepository.findByEmail(dto.getGuestDto().getEmail());
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
			return "Reservation saved successfully!";
		}

		else {
			throw new HotelException("Guest Email is not Found");
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
				return "updated seccefully";
			} else {
				return "Reservation not found";
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
				Reservation save=reservationRepository.save(reservation);
				return "updated seccefully";
			} else {
				return "Reservation not found";
			}
		} catch (NonUniqueResultException e) {
			return "Multiple reservations found for the given ID";

		} catch (Exception e) {
			return "An error occurred: " + e.getMessage();
		}
	}

	@Override
	public ReservationDto getReservation(ReservationDto dto) {
		Optional<Reservation> optional	=reservationRepository.findByReservationId(dto.getReservationId());
		if(optional.isPresent()) {
			Reservation reservation=optional.get();
			ReservationDto reservation1=ObjectUtil.ReservationEntityToDto(reservation);
			return reservation1;
		}
		throw new HotelException("Reservation Id is not Found");

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
}

