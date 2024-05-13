package com.excel.hibernateDemo.Service;



import com.excel.hibernateDemo.onetomany.entity.Laptop;
import com.excel.hibernateDemo.onetomany.entity.Student1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MainRunner {
	public static void main(String[] args) {
		 Student1 s1=new Student1();
		 s1.setId(101);
		 s1.setAge(22);
		 s1.setName("prajwal");
		 
		 Student1 s2=new Student1();
		 s2.setId(202);
		 s2.setAge(23);
		 s2.setName("akash");
		 
		 Laptop l1=new Laptop();
		 l1.setId(1001);
		 l1.setBrand("Dell");
		 l1.setSerialNo("AGHST5364");
		 
		 Laptop l2=new Laptop();
		 l2.setId(1002);
		 l2.setBrand("HP");
		 l2.setSerialNo("BGHST5364");
		 
		 Laptop l3=new Laptop();
		 l3.setId(1003);
		 l3.setBrand("Ipad");
		 l3.setSerialNo("CHSHST5364");
		 
		 Laptop l4=new Laptop();
		 l4.setId(1004);
		 l4.setBrand("LENOVO");
		 l4.setSerialNo("KKGHST5364");
		 
		 l1.setStudent1(s1);	
		 l2.setStudent1(s2);
		 l3.setStudent1(s1);	
		 l4.setStudent1(s2);
		 
		 
		 s1.getLaptops().add(l1);
		 s1.getLaptops().add(l2);
		 s2.getLaptops().add(l3);
		 s2.getLaptops().add(l4);
		 
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
		transaction.begin();
		em.persist(s1);
		em.persist(s2);
		em.persist(l1);
		em.persist(l2);
		em.persist(l3);
		em.persist(l4);
		transaction.commit();
		em.close();
	}
}
