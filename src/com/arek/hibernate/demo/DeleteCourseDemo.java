package com.arek.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arek.hibernate.demo.entity.Course;
import com.arek.hibernate.demo.entity.Instructor;
import com.arek.hibernate.demo.entity.InstructorDetail;
import com.arek.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		//Tworzymy SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//tworzymy sesjê
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//rozpoczynamy przetwarzanie
			session.beginTransaction();
			
			int theId=3;
			Course theCourse = session.get(Course.class, theId);
			
			session.delete(theCourse);

			//comitujemy
			session.getTransaction().commit();
		}
		finally{
			
			session.close();
			factory.close();
		}
	}

}
