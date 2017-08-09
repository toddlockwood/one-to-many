package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Student;

public class StudentDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			
			//tworzymy obiekt studenta
			Student theStudent = new Student("Mis", "Koala", "koale@super.com");
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			//zapisujemy obiekt
			session.save(theStudent);
			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
