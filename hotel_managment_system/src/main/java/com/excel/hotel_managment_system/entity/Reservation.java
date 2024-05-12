package com.excel.hotel_managment_system.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reservation_id")
	private int reservationId;

	@OneToOne(cascade = CascadeType.ALL)
	private Guest guest;

	@OneToOne(cascade = CascadeType.ALL)
	private Room room;

	@Column(name = "check_in_date")
	private Date checkInDate;

	@Column(name = "check_out_date")
	private Date checkOutDate;

	@Column(name="total_amount")
	private int amount;

	@Column(name = "is_cancelled")
	private boolean isCancelled;
}
