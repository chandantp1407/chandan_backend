package com.excel.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
