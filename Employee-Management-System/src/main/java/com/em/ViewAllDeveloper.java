package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/veiwAllDeveloper")
public class ViewAllDeveloper extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try 
		{
			
			// 1. Load and register the driver
			Class.forName("org.postgresql.Driver");

			// 2. Establish Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres", "abdullah");
						
		     String query= "select * from employee where role= 'Developer'";
		     
		     PreparedStatement ps= connection.prepareStatement(query);
		     
		     ResultSet rs= ps.executeQuery();
		     
		     resp.setContentType("text/html");
		     PrintWriter pw= resp.getWriter();
		     
		     if(rs != null)
		     {
		    	 while(rs.next())
		    	 {
		    	 	pw.print("ID : " + rs.getInt("id") + "<br>");
		    	 	pw.print("NAME : " + rs.getString("name") + "<br>");
		    	 	pw.print("EMAIL : " + rs.getString("email") + "<br>");
		    	 	pw.print("PASSWORD : " + rs.getString("password") + "<br>");
		    	 	pw.print("PHONE : " + rs.getString("phonenumber") + "<br>");
		    	 	pw.print("SALARY : " + rs.getDouble("salary") + "<br>");
		    	 	pw.print("ROLE : " + rs.getString("role") + "<br>");

		    	 	pw.print("<hr>");
		    	 }
		     }
		     else
		     {
		    	 pw.print("NO DEVELOPER FOUND");
		     }
		     
						
			connection.close();			
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}

}
