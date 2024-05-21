package com.excel.hms.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.hms.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	Optional<Reservation> findByCheckInDateCheckOutDateTotalAmount(LocalDate checkInDate,LocalDate checkOutDate,double totalAmount);
}
