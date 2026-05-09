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
   String option= request.getParameter("upadte-option");
session.setAttribute("option", option);
if(option.equals("NAME"))
{
%>
<form action="update">
ENTER ID: <input type="text" name="developer-id"> <br><br>
ENTER NEW NAME:<input type="text" name="developer-name"> <br><br>
<input type="submit">
</form>
<%}
   else if(option.equals("EMAIL"))
{%>
<form action="update">
ENTER ID: <input type="text" name="developer-id"> <br><br>
ENTER NEW EMAIL:<input type="text" name="developer-email"> <br><br>
<input type="submit">
</form>
<%}
   else if(option.equals("PHONENUMBER"))
   {
%>	   
<form action="update">
ENTER ID: <input type="text" name="developer-id"> <br><br>
ENTER NEW PHONENUMBER:<input type="text" name="developer-phonenumber"> <br><br>
<input type="submit">
</form>   
<%} %>


</body>
</html>