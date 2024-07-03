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

<style type="text/css">

	h3,h4{
		
		color:crimson;
		text-align:center;
	
	}


</style>

<meta charset="UTF-8">
<title>Error</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navbar.jsp" %>

<div class="container">
<h3> Oggetto già presente nel carrello </h3>
<h4><a href = 'cart.jsp'> Go to cart page </a> </h4>

</div>

<%@include file = "includes/footer.jsp" %>
</body>
</html>