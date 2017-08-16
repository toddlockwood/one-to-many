package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Course;
import com.arek.hibernate.demo.entity.Instructor;
import com.arek.hibernate.demo.entity.InstructorDetail;
import com.arek.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//tworzymy sesj�
		Session session = factory.getCurrentSession();
		
		try {
			
			//Tworzymy obiekty
			Instructor tempInstructor = new Instructor("Mis","Koala", "mis@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("miskoalkayoutubesuperchannel", "eating raw meat");
			
			//��czymy obiekty :D
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			
			session.save(tempInstructor);

			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			
			session.close();
			factory.close();
		}
	}

}
