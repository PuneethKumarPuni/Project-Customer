package com.viewData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@WebServlet("/ViewData")
public class ViewData<customer_info, ItemDtls> extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SessionFactory sessionFactory;

    public void init() {   
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void destroy() {   
        sessionFactory.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        PrintWriter out1 = response.getWriter();
        
        String userInput = request.getParameter("command");

        
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM customer_info WHERE CId = :userInput";
        String sql1 = "SELECT * FROM ItemDtls WHERE CId = :userInput";
        
        List<customer_info []> resultList = session.createNativeQuery(sql).setParameter("userInput", userInput).getResultList(); 
        List<ItemDtls []> resultList1 = session.createNativeQuery(sql1).setParameter("userInput", userInput).getResultList(); 
        
        StringBuilder dataRows = new StringBuilder();
        StringBuilder dataRows1 = new StringBuilder();
        
        
        for (customer_info row[] : resultList) {
            dataRows.append("<tr>");
            for (customer_info column : row) {
                dataRows.append("<td>").append(column).append("</td>");
            }
            dataRows.append("</tr>");
        }
        for (ItemDtls row1[] : resultList1) {
            dataRows1.append("<tr>");
            for (ItemDtls column : row1) {
                dataRows1.append("<td>").append(column).append("</td>");
            }
            dataRows1.append("</tr>");
        }
        session.close();
        out.println("<html><body>");
        out.println("<h1>Data from Database</h1>");
        out.println("<table border=1>");
        out.println("<thead><tr><th>Cusomer Id</th><th>Name</th><th>Contact number</th><th>E mail</th><th>Date</th></tr></thead>");
        out.println("<tbody>" + dataRows + "</tbody>");
        out.println("</table>");
        out.println("</body></html>");
        
        out1.println("<html><body>");
        out1.println("<h1>Data from Database</h1>");
        out1.println("<table border=1>");
        out1.println("<thead><tr><th>Cusomer Id</th><th>ITEM 01</th><th>PRICE 01</th><th>ITEM 02</th><th>PRICE 02</th><th>ITEM 03</th><th>PRICE 03</th></tr></thead>");
        out1.println("<tbody>" + dataRows1 + "</tbody>");
        out1.println("</table>");
        out1.println("</body></html>");
        
        out1.println("<a href='index.html'>Home</a>");
        out.close(); 
        out1.close();
       

    }
}
