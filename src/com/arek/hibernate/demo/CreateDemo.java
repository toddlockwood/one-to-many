package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Instructor;
import com.arek.hibernate.demo.entity.InstructorDetail;
import com.arek.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			
			//Tworzymy obiekty
			Instructor tempInstructor = new Instructor("Mis","Koala", "mis@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("miskoalkayoutubesuperchannel", "eating raw meat");
			
			//£¹czymy obiekty :D
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			
			session.save(tempInstructor);

			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
