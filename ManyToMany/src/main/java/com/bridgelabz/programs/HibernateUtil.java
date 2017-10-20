package com.bridgelabz.programs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

public class HibernateUtil {
	static SessionFactory factory;
	static{
		Configuration config=new Configuration().configure();
		factory=config.buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return factory;
	}

}
