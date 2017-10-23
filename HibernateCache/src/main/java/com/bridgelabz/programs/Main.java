package com.bridgelabz.programs;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
			Session session=factory.openSession();
			Student student=session.get(Student.class,37);
			Student student2=session.get(Student.class,37);
			session.close();
			Session session2=factory.openSession();
			Student student3=session2.get(Student.class,37);
			session2.close();
	}

}
