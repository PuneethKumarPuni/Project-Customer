package com.save;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
//import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import com.hibernate.DBuilt.DButil;
import com.hibernate.Entity.Customer_info;

public class SaveDetails {
	public static int save (Customer_info ci) {
		
				//get the session Object
		SessionFactory sf = DButil.buildSession();
				Session ses = sf.openSession();
				Transaction tx = null;
				Integer count = 0;
				int i = 0;
				try(ses){
					//brgin the transaction
					tx = ses.beginTransaction();
					 i = ses.createSQLQuery(" insert into Customer_info values("+ci.getCId()+",'"+ci.getName()+"','"+ci.getCno()+"','"+ci.getEmail()+"','"+ci.getDate()+"')").executeUpdate();
					//save the object
					count = (Integer) ses.save(count);
					//commit the trasaction
					tx.commit();
				}catch(HibernateException e) {
					e.printStackTrace();
					//tx.rollback();
				}catch(Exception e) {
					e.printStackTrace();
					//tx.rollback();
				}
				ses.close();
				return i;
			}
		

	}


