package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			
			//tworzymy obiekt 3 studentów
			Student theStudent1 = new Student("Mis", "Koala", "koale@super.com");
			Student theStudent2 = new Student("Zuczek", "Koalus", "koale@super.com");
			Student theStudent3 = new Student("Szop", "Pracz", "koale@super.com");
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			//zapisujemy obiekt
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}
}
