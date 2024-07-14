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
<title>Register</title>
<%@include file = "includes/header.jsp" %>
<link rel="stylesheet" href="carrello.css">
<style>

	.card-header{
	
		background-color: #3b3e23;
		color:white;
		text-weight:bold;
	
	}
	
</style>

<script src="JavaScript/registration.js"></script>
</head>
<body>
<%@include file = "includes/navbar_nuova.jsp" %>
<br><br><br>
<div class= "container d-flex justify-content-center">

	<div class = "card w-50 mx-auto my-5">
	
	<!-- card in generale -->
	
	<div class = "card-header text-center">
	Registrazione
	
	<!--  card-header -->
	
	</div>
	
	<div class = "card-body">
	
	<!-- card body --> 
	

<form action ="user-register" method = "POST" >

<div class= "form-group">

	<label><b>Nome</b></label>
	<input type="text" class ="form-control" name="login-name" placeholder ="Inserisci il tuo nome" required>
</div>

<div class= "form-group">
	<label><b>Indirizzo E-mail</b></label>
	<input type = "email" class = "form-control" name = "login-email" placeholder = "Inserisci la tua E-mail" required>
</div>

<div class= "form-group">
	<label><b>Password</b></label>
	<input type = "password" class = "form-control" name = "login-password" placeholder = "*******" required>
</div>

<div class = "text-center">
	
	<button type = "submit" class = "link_bottone" onclick ="funzione(this)" >&nbsp;&nbsp;&nbsp;Register&nbsp;&nbsp;&nbsp;</button>
</div>
</form>

</div>
</div>
</div>
</body>
</html>