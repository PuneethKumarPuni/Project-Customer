package com.Deletedetails;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//import com.hibernate.Entity.Customer_info;
//import com.hibernate.Entity.Items;

@WebServlet("/DeleteData")
public class DeleteDtls<customer_info, ItemDtls> extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    public void init() {   
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void destroy() {   
        sessionFactory.close();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Cid = request.getParameter("command1"); // Get the primary key value from the form

        // Set up Hibernate session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
           Transaction t= session.beginTransaction();
           String sql = "delete  FROM customer_info WHERE CId = :Cid";
           session.createNativeQuery(sql).setParameter("Cid", Cid).executeUpdate(); 
           
           String sql1 = "delete  FROM ItemDtls WHERE CId = :Cid";
           session.createNativeQuery(sql1).setParameter("Cid", Cid).executeUpdate();

            // Load the entity class and delete the row based on the primary key
//            Customer_info entity= session.load(Customer_info.class, CId);
//            session.delete(entity);
//            Items entity1 = session.load(Items.class, CId);
//            session.delete(entity1);
            t.commit();
            response.getWriter().println("Row deleted successfully!");
        } catch (Exception e) {
            session.getTransaction().rollback();
            response.getWriter().println("Error occurred while deleting the row: " + e.getMessage());
        } finally {
            session.close();
        }
    }
}
    
