package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			
			//tworzymy obiekt studenta
			Student tempStudent = new Student("Mysz", "Jerry", "Jerry@super.com");
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			//zapisujemy obiekt
			session.save(tempStudent);
			//comitujemy
			session.getTransaction().commit();
			
			
			//nowa sesja
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			Student theStudent = session.get(Student.class, tempStudent.getId());
			System.out.println(theStudent);
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
	}

}
