package com.excel.hibernateDemo.Service;

import com.excel.hibernateDemo.OneToOne.entity.Markscard;
import com.excel.hibernateDemo.OneToOne.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class RunnerClass {
	public static void main(String[] args) {
		Student s=new Student();
		s.setName("chandan");
		s.setAge(23);

		Markscard markscard=new Markscard();
		markscard.setGrade("A");
		markscard.setMarks(87);
		markscard.setStudent(s);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		transaction.begin();
		em.persist(s);
		em.persist(markscard);
		transaction.commit();
		em.close();
	}
}
