package com.hibernate.DBuilt;

//import org.hibernate.Session;

//package com.hibernate.DBuilt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Customer_info;
//import com.hibernate.Entity.Items;

public class DButil {

	static SessionFactory sessionfactory=null;
	public static SessionFactory buildSession() {
		if(sessionfactory!=null) {
			return sessionfactory;
		}
		Configuration cf=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer_info.class);
		sessionfactory= cf.buildSessionFactory();
	
		return sessionfactory;
		
	}
	
	
}
