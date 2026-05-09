package com.em;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePassword")
public class ChangedPassword extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	   String password= req.getParameter("password");
	   int id= Integer.parseInt(req.getParameter("id"));
	   
	   try {
			//1. Load and register the driver
			Class.forName("org.postgresql.Driver");
			
			//2. Establish Connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres", "abdullah");
			
			//3. Create a statement using PreparedStatement interface
			PreparedStatement ps= con.prepareStatement("update employee set password=? where id=?");
			
			ps.setString(1, password);
			ps.setInt(2, id);
			
			//4. execute the query
			int rows= ps.executeUpdate();
		
			if(rows!=0)
			{
				RequestDispatcher rd= req.getRequestDispatcher("login.html");
				rd.forward(req, resp);
			}
			else
			{
				PrintWriter pw= resp.getWriter();
				pw.print("<h1>INVALID EMAIL OR REGISTER FIRST</h1>");
			}	
			
			//6. Close the connection
			con.close();
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
