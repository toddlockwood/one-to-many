package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Instructor;
import com.arek.hibernate.demo.entity.InstructorDetail;
import com.arek.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// tworzymy sesjê
		Session session = factory.getCurrentSession();

		try {

			// rozpoczynamy przetwarzanie
			session.beginTransaction();

			int theid = 23;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theid);

			System.out.println("TEMP    " + tempInstructorDetail);

			System.out.println("TEMP  ASSOCIATED  " + tempInstructorDetail.getInstructor());

			// comitujemy
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();

			factory.close();
		}
	}

}
