<%@page import = "cn.uliveto.dao.ProductDao" %>
<%@page import = "cn.uliveto.connection.DbCon" %>
<%@page import ="cn.uliveto.model.*" %>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%Utente auth = (Utente)request.getSession().getAttribute("auth"); 
  	
  	if(auth!=null)
  	{
  		request.setAttribute("auth",auth);
  		
  		if(auth.getId() != 2)
  		{
  			response.sendRedirect("index.jsp");
  		}
  	}
  	else
  	{
  		response.sendRedirect("index.jsp");
  	}
  	
  %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Uliveto</title>
  <%@include file = "admin-pages/admin_includes/header.jsp" %>
</head>
<body>
<%@include file = "admin-pages/admin_includes/navbar.jsp" %>

<!-- codice qui tra header e footer -->
	

 <%@include file = "admin-pages/admin_includes/footer.jsp" %>
</body>
</html>