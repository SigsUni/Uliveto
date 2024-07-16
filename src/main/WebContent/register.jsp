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

<script>


function Check()
{
    var nome = document.modulo.login_nome.value;
    var email = document.modulo.login_email.value;
    var password = document.modulo.login_password.value;
    var password2 = document.modulo.login_password_confirm.value;
	
    if ((nome == "") || (nome == "undefined")) {
    	alert("Il campo Nome è obbligatorio.");
    	document.modulo.login_nome.focus();
    	return false;
    	}
    
    if(password.length < 8)
    {
    	alert("La password deve contenere almeno 8 caratteri");
    	document.modulo.login_password.focus();
    	return false;
    }
    
    if (password != password2) {
    	alert("La password confermata è diversa da quella scelta, controllare.");
    	document.modulo.login_password_confirm.value = "";
    	document.modulo.login_password_confirm.focus();
    	return false;
    	}
    var email_reg_exp = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-]{2,})+.)+([a-zA-Z0-9]{2,})+$/;
    
    if (!email_reg_exp.test(email) || (email == "") || (email == "undefined")) {
    	alert("Inserire un indirizzo email corretto.");
    	document.modulo.login_email.select();
    	return false;
    	}
    
    
    document.modulo.submit();
    return true;
}


</script>
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
	

<form action ="user-register" method = "POST" name="modulo">

<div class= "form-group">

	<label><b>Nome</b></label>
	<input type="text" class ="form-control" name="login_nome" placeholder ="Inserisci il tuo Nome">
</div>

<div class= "form-group">
	<label><b>Indirizzo E-mail</b></label>
	<input type = "email" class = "form-control" name = "login_email" placeholder = "Inserisci la tua E-mail">
</div>

<div class= "form-group">
	<label><b>Password</b></label>
	<input type = "password" class = "form-control" name = "login_password" placeholder = "*******">
</div>

<div class= "form-group">
	<label><b>Confirm Password</b></label>
	<input type = "password" class = "form-control" name = "login_password_confirm" placeholder = "*******">
</div>

<div class = "text-center">
	
	<button type = "button" class = "link_bottone" onClick ="return Check()" >&nbsp;&nbsp;&nbsp;Register&nbsp;&nbsp;&nbsp;</button>
</div>
</form>

</div>
</div>
</div>
</body>
</html>