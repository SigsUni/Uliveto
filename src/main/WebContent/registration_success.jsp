<%@page import ="cn.uliveto.connection.DbCon"%>
<%@page import ="cn.uliveto.model.*" %>
<%@page import = "java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%Utente auth = (Utente)request.getSession().getAttribute("auth"); 
  	
  	if(auth!=null)
  	{
  		request.setAttribute("auth",auth);
  	}
  	
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
  	
  	if(cart_list!=null)
  	{	
  		request.setAttribute("cart_list",cart_list);
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
<title>Successo</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navbar.jsp" %>

<div class="container">
<h3> Registrazione avvenuta con successo </h3>
<h4><a href = 'login.jsp'> Effettua il Login </a> </h4>

</div>

<%@include file = "includes/footer.jsp" %>
</body>
</html>