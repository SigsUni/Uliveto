<%@page import ="cn.uliveto.connection.DbCon"%>
<%@page import ="cn.uliveto.model.*" %>
<%@page import = "cn.uliveto.dao.*" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%Utente auth = (Utente)request.getSession().getAttribute("auth"); 
  	
  	if(auth!=null)
  	{
  		request.setAttribute("auth",auth);
  		
  		if(auth.getId() == 2)
  	  	{
  	  		response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
  	  	}
  	}
  	
  	
  	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
  	List<Cart> cartProduct = null;
  	
  	
  	
  	if(cart_list!=null)
  	{
  		ProductDao pDao = new ProductDao(DbCon.getConnection());
  		cartProduct = pDao.getCartProducts(cart_list);
  		double total = pDao.getTotalCartPrice(cart_list);
  		
  		request.setAttribute("cart_list",cart_list);
  		request.setAttribute("total", total);
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
<%@include file = "includes/navbar_nuova.jsp" %>

<br><br><br>
<div class="container">

<div class="d-flex py-3"><h3>Total price:€ ${ (total>0)? total:0 }</h3><a class="btn mx-3 btn-primary" href="cart-check-out">Check out</a></div>
	
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
	<% if(cart_list!=null) 
		{
			for(Cart c:cartProduct)
			{
				%>
				<tr>
				
				<td><%= c.getName()%></td>
				<td><%= c.getCategory()%></td>
				<td>€<%= c.getPrice()%></td>
				<td>
				
						<form action="order-now" method="POST" class="form-inline">
					
						<input type="hidden" name="id" value="<%= c.getId() %>" class="form-input">
						<div class="form-group d-flex justify-content-between w-50">
						<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
						<input type="text" name ="quantity" class="form-control w-50" value="<%=c.getQuantity() %>" readonly>
						<%if(c.getStock()>c.getQuantity()){%>
						<a class="btn btn-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a>
						</div>
						<%}else{ %>
						<a class="btn btn-sm btn-incre 2" href="#"><i class="fas fa-plus-square"></i></a>
						</div>
						<%} %>
						
						<button type = "submit" class="btn btn-primary btn-sm" >Acquista</button>
					
					
						</form>
				</td>
				<td>
						<a class= "btn btn-sm btn-danger" href ="remove-from-cart?id=<%=c.getId()%>">Rimuovi</a>
				</td>
			
			</tr>
			<% 
			}
		}
	
	
	
	
	%>
	

</tbody>

</table>


</div>


<%@include file = "includes/footer.jsp" %>
</body>
</html>