package com.arek.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {

			//rozpoczynamy przetwarzanie
			session.beginTransaction();

			List<Student> theStudenst = session.createQuery("from Student").getResultList();
			
			displayStudents(theStudenst);
			theStudenst = session.createQuery("from Student s where s.lastName='Jerry'").getResultList();
			displayStudents(theStudenst);
			theStudenst = session.createQuery("from Student s where s.lastName='Koala' OR s.firstName='Szop'").getResultList();
			displayStudents(theStudenst);
			theStudenst = session.createQuery("from Student s where s.email LIKE '%@koale.com'").getResultList();
			displayStudents(theStudenst);
			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudenst) {
		for(Student tempStudent : theStudenst) {
			System.out.println(tempStudent);
		}
	}

}
