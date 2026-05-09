package com.em;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/veiwDeveloper")
public class DisplayAllDevelopers extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try 
		{
			Class.forName("org.postgresql.Driver");
			
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres", "abdullah");
			
			String query= "select * from employee where role=?";
			
			PreparedStatement ps= connection.prepareStatement(query);
			
			ps.setString(1, "developer");
			
			ResultSet rs= ps.executeQuery();
			req.setAttribute("data", rs);
			
			RequestDispatcher rd= req.getRequestDispatcher("displayDeveloper.jsp");
			rd.forward(req, resp);
			
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}

}
