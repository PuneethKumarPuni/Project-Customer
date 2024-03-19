package com.hibernate.Entity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.save.SaveItems;

@WebServlet("/ItemsInsert")
public class ItemsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String Cid=request.getParameter("CId");
		
		String item1=request.getParameter("I1");
		String price1=request.getParameter("P1");
		int P1=Integer.parseInt(price1);
		String item2=request.getParameter("I2");
		String price2=request.getParameter("P2");
		int P2=Integer.parseInt(price2);
		String item3=request.getParameter("I3");
		String price3=request.getParameter("P3");
		int P3=Integer.parseInt(price3);

		
		 Items its=new Items();
		its.setCid(Cid);
		its.setI1(item1);
		its.setP1(P1);
		its.setI2(item2);
		its.setP2(P2);
		its.setI3(item3);
		its.setP3(P3);
		
		
		
		int count=SaveItems.savei (its);
		
		if(count==0) {
			pw.println("<h2>Details not uploaded</h2>");
			
			pw.println("<a href='index.html'>Home</a>");
		}
			else
			{
				pw.println("<h2>Details uploaded</h2>");
				pw.println("Customer ID:"+Cid);
				pw.println("<br>");
				pw.println("Name:"+item1);
				pw.println("<br>");
				pw.println("Contact Number:"+P1);
				pw.println("<br>");
				pw.println("Name:"+item2);
				pw.println("<br>");
				pw.println("Contact Number:"+P2);
				pw.println("<br>");
				pw.println("Name:"+item3);
				pw.println("<br>");
				pw.println("Contact Number:"+P3);
				pw.println("<br>");
				pw.println("TOTAL PRICE:"+(P1+P2+P3));
				
				pw.println("<a href='index.html'>Home</a>");
			}
			//close the stream
			pw.close();
		}
	
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
