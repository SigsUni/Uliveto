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
  	}
  
  	ProductDao pd = new ProductDao(DbCon.getConnection());
  	List<Prodotto> products = pd.getAllProducts();
  	
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
<title>Uliveto</title>
<%@include file = "includes/header.jsp" %>
</head>
<body>
<%@include file = "includes/navbar.jsp" %>

<!-- codice qui tra header e footer -->

	<div class = "container">
	
	<div class = "card-header my-3">I NOSTRI OLI</div>
	
	<div class="row g-3">
	
	<% 
	if(!products.isEmpty())
	{
		for(Prodotto p:products)
		{
			if(p.getCategory().equals("oli"))
			{
		%>
			
			<div class="col-12 col-md-6 col-lg-4 gy-3">
			<div class="card w-100" style="width: 8rem;">
				<a href="#">
  				<img class="card-img-top" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  					<div class="card-body">
    				<h5 class="card-title"><%= p.getName() %></h5>
    				<h6 class = "price">Prezzo €<%= p.getPrice() %></h6>
    				<h6 class = "category">Categoria: <%= p.getCategory() %></h6>
    				<div class = "mt-3 justify-content -between ">
    					<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark col-md-8 ">Aggiungi al carrello</a>
    					<a href="#" class="btn btn-primary ">Compra</a>
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				
  				</div>
			</div>
		</div>
			
		<%
			}
		}
	}
	
	%>
	
	</div>
	
	
	<div class = "card-header my-3">I NOSTRI OLI</div>
	
	<div class="row g-3">
	
	<% 
	
	List<Prodotto> productss = pd.getAllProducts();
	
	if(!productss.isEmpty())
	{
		for(Prodotto p:productss)
		{
		
			if(p.getCategory().equals("ceci"))
			{
		%>
			
			<div class="col-12 col-md-6 col-lg-4 gy-3">
			<div class="card w-100" style="width: 8rem;">
				<a href="#">
  				<img class="card-img-top" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  					<div class="card-body">
    				<h5 class="card-title"><%= p.getName() %></h5>
    				<h6 class = "price">Prezzo €<%= p.getPrice() %></h6>
    				<h6 class = "category">Categoria: <%= p.getCategory() %></h6>
    				<div class = "mt-3 justify-content -between ">
    					<a href="add-to-cart?id=<%= p.getId() %>" class="btn btn-dark col-md-8">Aggiungi al carrello</a>
    					<a href="#" class="btn btn-primary ">Compra</a>
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				
  				</div>
			</div>
		</div>
		<%
			}
		}
	}
	
	%>
	
	</div>
	
	
	
</div>

<%@include file = "includes/footer.jsp" %>
</body>
</html>