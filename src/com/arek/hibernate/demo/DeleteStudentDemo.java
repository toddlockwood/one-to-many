package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;

			//rozpoczynamy przetwarzanie
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//Student myStudent = session.get(Student.class, studentId);
			//session.delete(myStudent);
			session.createQuery("delete from Student where id=2").executeUpdate();

			//comitujemy
			session.getTransaction().commit();
			
			
		}
		finally{
			factory.close();
		}
	}

}
