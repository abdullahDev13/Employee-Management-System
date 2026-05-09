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

@WebServlet("/delete")
public class DeleteDeveloper extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id= req.getParameter("developer-id");
		
		// conversion-Parsing
		int idInt = Integer.parseInt(id);
		
try {
			
		// 1. Load and register the driver
			Class.forName("org.postgresql.Driver");

		// 2. Establish Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres","abdullah");

						String query = "delete from employee where id=?";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.setInt(1, idInt);
					
						int rows = preparedStatement.executeUpdate();
						PrintWriter printWriter = resp.getWriter();
						if (rows != 0) {
							printWriter.print("<h1>Developer ID Deleted</h1>");
						}
						connection.close();
					
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		
	}

}
