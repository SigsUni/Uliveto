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
<style type = "text/css">

	.table tbody td
	{
	
		vertical-align: middle;
		
	}
	
	.btn-incre, .btn-decre
	{
		box-shadow: none;
		font-size: 1.7rem;
	}

</style>
</head>
<body>
<%@include file = "includes/navbar.jsp" %>

<div class="container">

<div class="d-flex py-3"><h3>Total price:€ </h3><a class="btn mx-3 btn-primary" href="#">Check out</a></div>
	
<table class="table table-loght">

	<thead>
	<tr>
	<th scope="col">Nome</th>
	<th scope="col">Categoria</th>
	<th scope="col">Prezzo</th>
	<th scope="col">Compra ora</th>
	<th scope="col">Annulla</th>
	</tr>
	</thead>

<tbody>
	
	<tr>
	
		<td>Olio extravergine d'oliva 250ml</td>
		<td>Oli</td>
		<td>€6</td>
		<td>
		
				<form action="" method="POST" class="form-inline">
			
				<input type="hidden" name="id" value="1" class="form-input">
				<div class="form-group d-flex justify-content-between">
				<a class="btn btn-sm btn-decre" href="#"><i class="fas fa-minus-square"></i></a>
				<input type="text" name ="quantity" class="form-control" value="1" readonly>
				<a class="btn btn-sm btn-incre" href="#"><i class="fas fa-plus-square"></i></a>
				
				
				</div>
			
			
				</form>
		</td>
		<td>
				<a class= "btn btn-sm btn-danger" href ="">Rimuovi</a>
		</td>
	
	</tr>

</tbody>

</table>


</div>


<%@include file = "includes/footer.jsp" %>
</body>
</html>