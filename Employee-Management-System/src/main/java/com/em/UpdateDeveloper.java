package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateDeveloper extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		 //getData from Form
		int id= Integer.parseInt(req.getParameter("developer-id"));
		String name= req.getParameter("developer-name");
		String email= req.getParameter("developer-email");
		
		//get option from Httpsession
		HttpSession session= req.getSession();
		String option= (String) session.getAttribute("option");
		
		try 
		{
			
			// 1. Load and register the driver
			Class.forName("org.postgresql.Driver");

			// 2. Establish Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres","abdullah");
			
			PreparedStatement preparedStatement=null;
			
			if(option.equals("NAME"))
			{
				String query= "update employee set name=? where id=?";
				preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
			}
			else if(option.equals("EMAIL"))
			{
				String query= "update employee set email=? where id=?";
				preparedStatement= connection.prepareStatement(query);
				preparedStatement.setString(1, email);
				preparedStatement.setInt(2, id);
			}
			else if(option.equals("PHONENUMBER"))
			{
				long phonenumber= Long.parseLong(req.getParameter("developer-phonenumber"));
				String query= "update employee set phonenumber=? where id=?";
				preparedStatement= connection.prepareStatement(query);
				preparedStatement.setLong(1, phonenumber);
				preparedStatement.setInt(2, id);
			}
			
			int rows= preparedStatement.executeUpdate();
			PrintWriter printWriter= resp.getWriter();
			if(rows!=0)
			{
				printWriter.print("<h1>Data Updated</h1>");
			}
			connection.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
