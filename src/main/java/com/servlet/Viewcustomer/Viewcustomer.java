package com.servlet.Viewcustomer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernate.Entity.Customer_info;
import com.save.SaveDetails;

@WebServlet("/Uplaod")
public class Viewcustomer extends HttpServlet {
private static final long serialVersionUID = 1L;
       
  
@Override
protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String Cid=request.getParameter("CId");
		String name=request.getParameter("Name");
		String contactno=request.getParameter("Cno");
		String email=request.getParameter("Email");
		String date=request.getParameter("Date");
		
		Customer_info sd=new Customer_info();
		sd.setCId(Cid);
		sd.setName(name);
		sd.setCno(contactno);
		sd.setEmail(email);
		sd.setDate(date);
		
		int count=SaveDetails.save(sd);
		
		if(count==0) {
			pw.println("<h2>Details not uploaded</h2>");
			
			pw.println("<a href='details.html'>Home</a>");
		}
			else
			{
				pw.println("<h2>Details uploaded</h2>");
				pw.println("Customer ID:"+Cid);
				pw.println("<br>");
				pw.println("Name:"+name);
				pw.println("<br>");
				pw.println("Contact Number:"+contactno);
				pw.println("<br>");
				pw.println("Email:"+email);
				pw.println("<br>");
				pw.println("Date:"+date);
				pw.println("<br>");
				pw.println("<a href='items.html'>Next</a>");
			}
			//close the stream
			pw.close();
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	}