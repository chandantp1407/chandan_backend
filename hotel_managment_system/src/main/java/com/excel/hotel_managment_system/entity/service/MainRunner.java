package com.excel.hotel_managment_system.entity.service;

import com.excel.hotel_managment_system.entity.Guest;
import com.excel.hotel_managment_system.entity.Reservation;
import com.excel.hotel_managment_system.entity.Room;
import com.excel.hotel_managment_system.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainRunner {
	public static void main(String[] args) {
		Room r=new Room();
		User u=new User();
		Guest g=new Guest();
		Reservation reservation=new Reservation();
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hotel");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		transaction.begin();
		em.persist(r);
		em.persist(u);
		em.persist(g);
		em.persist(reservation);
		transaction.commit();
		em.close();
	}
}
