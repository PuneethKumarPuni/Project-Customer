
package com.save;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
//import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import com.hibernate.DBuilt.DButil01;
import com.hibernate.Entity.Customer_info;
import com.hibernate.Entity.Items;

public class SaveItems {
	public static int savei (Items it) {
		
				//get the session Object
		SessionFactory sf = DButil01.buildSession();
				Session ses = sf.openSession();
				Transaction tx = null;
				Integer count = 0;
				int i = 0;
				try(ses){
					//brgin the transaction
					tx = ses.beginTransaction();
					 i = ses.createSQLQuery(" insert into ItemDtls values("+it.getCid()+",'"+it.getI1()+"','"+it.getP1()+"','"+it.getI2()+"','"+it.getP2()+"','"+it.getI2()+"','"+it.getP2()+"')").executeUpdate();
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


