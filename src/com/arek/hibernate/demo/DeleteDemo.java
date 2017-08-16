package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Instructor;
import com.arek.hibernate.demo.entity.InstructorDetail;
import com.arek.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			
			int id = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			if (tempInstructor != null) {
				
				session.delete(tempInstructor);
			}
			else
				System.out.println("NULL");

			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
