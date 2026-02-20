package com.kodnest.EmpManagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate {
	// hibernate for CURD Operations
	
	@SuppressWarnings("unused")
	static
	
	
	Configuration conf = new Configuration().configure("hibernate.cfg.xml");
	
	static SessionFactory factory = conf.buildSessionFactory();
	
	
	public static Session getSession() {
		
		return factory.openSession();
		
	}
	
	
	
	
	
}
