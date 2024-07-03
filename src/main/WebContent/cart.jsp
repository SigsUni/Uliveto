<%@page import ="cn.uliveto.connection.DbCon"%>
<%@page import ="cn.uliveto.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%Utente auth = (Utente)request.getSession().getAttribute("auth"); 
  	
  	if(auth!=null)
  	{
  		request.setAttribute("auth",auth);
  	}
  
  %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>carrello</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navbar.jsp" %>
<h1>Ciao a tutti </h1>
<%@include file = "includes/footer.jsp" %>
</body>
</html>