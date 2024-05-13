package com.excel.hibernateDemo.Service;

import com.excel.hibernateDemo.manyToMany.entity.Book;
import com.excel.hibernateDemo.manyToMany.entity.Student2;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainRunner1 {
	public static void main(String[] args) {
		Student2 s1=new Student2();
		s1.setId(1);
		s1.setAge(22);
		s1.setName("prajwal");

		Student2 s2=new Student2();
		s2.setId(2);
		s2.setAge(23);
		s2.setName("akash");

		Student2 s3=new Student2();
		s3.setId(3);
		s3.setAge(24);
		s3.setName("vinay");

		Book b1=new Book();
		b1.setId(101);
		b1.setName("AAA");

		Book b2=new Book();
		b2.setId(102);
		b2.setName("BBB");

		Book b3=new Book();
		b3.setId(103);
		b3.setName("CCC");

		s1.getBooks().add(b1);
		s1.getBooks().add(b2);
		s2.getBooks().add(b2);
		s2.getBooks().add(b3);
		s3.getBooks().add(b3);
		s3.getBooks().add(b1);

		b1.getStudents().add(s1);
		b1.getStudents().add(s2);
		b2.getStudents().add(s2);
		b2.getStudents().add(s3);
		b3.getStudents().add(s3);
		b3.getStudents().add(s1);



		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		transaction.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		transaction.commit();
		em.close();
	}
}
