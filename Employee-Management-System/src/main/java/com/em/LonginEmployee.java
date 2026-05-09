package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LonginEmployee extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		   String employeeEmail= req.getParameter("manager-email");
		   String employeePassword= req.getParameter("manager-password");
		   
		   try {
			// 1. Load and register the driver
				Class.forName("org.postgresql.Driver");

				// 2. Establish Connection
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres", "abdullah");
				
				String query = "select * from employee where email=? and password=?";
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setString(1, employeeEmail);
				ps.setString(2, employeePassword);

				ResultSet rs = ps.executeQuery();

				PrintWriter printWriter = resp.getWriter();

				if(rs.next()) 
				{
					//data present
				    printWriter.print("<h1>Login success, </h1>");
				    //validate based on role
				    //fetch role from RS obj
				    String role= rs.getString("role");
				    if(role.equals("Manager"))
				    {
				    	//do manager operaton
				    	RequestDispatcher requesDispatcher= req.getRequestDispatcher("manager.html");
				        requesDispatcher.forward(req, resp);
				    }
				    else if(role.equals("Developer"))
				    {
				    	//do developer opertion
				    	RequestDispatcher requestDispatcher= req.getRequestDispatcher("developer.html");
				    	requestDispatcher.forward(req, resp);
				    }
				} 
				else 
				{
//				    printWriter.print("<h1>Login failed</h1>");
				    PrintWriter pw= resp.getWriter();
			    	pw.print("<h1>Invalid Field</h1>");
			    	RequestDispatcher dispatcher= req.getRequestDispatcher("login.html");
			    	dispatcher.include(req, resp);
				}
				 connection.close();
		       } 
		    
		    catch (Exception e) 
		    {
			 System.out.println(e);
		    }
	}
}
