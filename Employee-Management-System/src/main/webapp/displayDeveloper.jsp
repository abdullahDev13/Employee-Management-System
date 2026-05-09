<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
  ResultSet resultSet= (ResultSet) request.getAttribute("data");

//process the result
 while(resultSet.next())
{
	PrintWriter pw= response.getWriter(); 
	out.print(resultSet.getInt("id")+" "+resultSet.getString("name")+" "+resultSet.getString("email")+" "+resultSet.getString("password")+" "+resultSet.getLong("phonenumber")+" "+resultSet.getDouble("salary")+" "+resultSet.getString("role")+"<br>");
}
%>

</body>
</html>