package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/verifyEmail")
public class EmailVerification extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	   String email= req.getParameter("email");
	   
	   try 
		{
			Class.forName("org.postgresql.Driver");
			
			Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres", "abdullah");
			  
			PreparedStatement ps= connection.prepareStatement("select * from employee where email=? ");

			
			ps.setString(1, email);
			
			ResultSet rs= ps.executeQuery();
			
			//process the result
			if(rs.next())
			{
				RequestDispatcher rd= req.getRequestDispatcher("takeNewPassword.html");
				rd.forward(req, resp);
				
			}
			else
			{
				PrintWriter pw= resp.getWriter();
				pw.print("<h1>INVALID EMAIL</h1>");
			}
			
			connection.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
