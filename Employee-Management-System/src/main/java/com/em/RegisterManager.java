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

@WebServlet("/registerManager")
public class RegisterManager extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// read data from form
		String id = req.getParameter("manager-id");
		String name = req.getParameter("manager-name");
		String email = req.getParameter("manager-email");
		String password = req.getParameter("manager-password");
		String phonenumber = req.getParameter("manager-phonenumber");
		String salary = req.getParameter("manager-salary");

		// conversion-Parsing
		int idInt = Integer.parseInt(id);
		long phonenumberLong = Long.parseLong(phonenumber);
		double salaryDouble = Double.parseDouble(salary);

		// insert all data to table--jdbc 5 steps
		try {

			// 1. Load and register the driver
			Class.forName("org.postgresql.Driver");

			// 2. Establish Connection
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employee_management_system", "postgres", "abdullah");

			String query = "INSERT INTO employee VALUES(?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, idInt);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setLong(5, phonenumberLong);
			preparedStatement.setDouble(6, salaryDouble);
			preparedStatement.setString(7, "Manager");

			int rows = preparedStatement.executeUpdate();
			PrintWriter printWriter = resp.getWriter();
			if (rows != 0) {
				printWriter.print("<h1>Manger Registered</h1>");
			}
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
}
