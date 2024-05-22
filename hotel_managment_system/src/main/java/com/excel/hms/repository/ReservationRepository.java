package com.excel.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.hms.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

}
