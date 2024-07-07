<%@page import = "cn.uliveto.connection.DbCon" %>
<%@page import ="cn.uliveto.model.*" %>
<%@page import ="java.util.*" %>
<%@page import ="cn.uliveto.dao.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%Utente auth = (Utente)request.getSession().getAttribute("auth"); 
  	
  	if(auth!=null)
  	{
  		request.setAttribute("auth",auth);
  		response.sendRedirect("index.jsp");
  		
  		if(auth.getId() == 2)
  	  	{
  	  		response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
  	  	}
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
<meta charset="UTF-8">
<title>Login</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navbar.jsp" %>
<div class= "container">

	<div class = "card w-50 mx-auto my-5">
	
	<!-- card in generale -->
	
	<div class = "card-header text-center">
	User login
	
	<!--  card-header -->
	
	</div>
	
	<div class = "card-body">
	
	<!-- card body --> 
	

<form action ="user-login" method = "POST" >

<div class= "form-group">

	<label>Indirizzo E-mail</label>
	<input type = "email" class = "form-control" name = "login-email" placeholder = "Inserisci la tua E-mail" required>

</div>

<div class= "form-group">

	<label>Password</label>
	<input type = "password" class = "form-control" name = "login-password" placeholder = "*******" required>

</div>

<div class = "text-center">
	
	
	<button type = "submit" class = "btn btn-primary"> Login </button>
</div>

<a class="text-left" href="register.jsp"><i>Non sei ancora registrato?</i></a>
</form>

</div>
</div>
</div>

<%@include file = "includes/footer.jsp" %>
</body>
</html>