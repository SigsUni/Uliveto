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
  		
  		if(auth.getId() == 2)
  	  	{
  	  		response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
  	  	}
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
<link rel="stylesheet" href="carrello.css">
<%@include file = "includes/header.jsp" %>

<style>

	.card-header{
	
		background-color: #3b3e23;
		color:white;
		text-weight:bold;
	
	}
</style>

</head>
<body>
<%@include file = "includes/navbar_nuova.jsp" %>

<!-- codice qui tra header e footer -->
<br><br><br>

	<div class = "container">
	<% if(auth!=null ){%>
	<br>
	<h4><p>Benvenuto <%= auth.getNome() %></p></h4>
	<br>
	<%}%>
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
			<div class="w-100 carta" style="width: 8rem;">
				<a href="#">
				<%if(p.getStock()!=0){ %>
  				<img class="card-img-top carta_immagine" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  				<%}else{%>
  				<img class="card-img-top carta_immagine bw-image" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  				<%} %>
  					<div class="card-body">
    				<h5 class="card-title"><%= p.getName() %></h5>
    				<h6 class = "price"><b>Prezzo</b> €<%= p.getPrice() %></h6>
    				<h6 class = "category"><b>Categoria:</b> <%= p.getCategory() %></h6>
    				<h6 class = "stock"><b>Stock:</b> <% if(p.getStock()!=0){%> <%= p.getStock()%> <%}else{ %><b><font color="red" >Out of Stock</font></b><%} %></h6>
    				<div class = "mt-3 justify-content -between bordo">
    				<%if(p.getStock()!=0){ %>
    					<a href="add-to-cart?id=<%= p.getId() %>" class="link_bottone_index">Aggiungi al carrello</a>
    					<a href="order-now?quantity=1&id=<%=p.getId()%>" class="link_bottone_rimuovi_index ">Compra</a>
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				<%}else{ %>
    				<p class="card-text"><b><font color="red" >ACQUISTO NON DISPONIBILE</font></b></p>
    				<!-- <a href="#" onclick="event.preventDefault();" class="link_bottone_index red">Aggiungi al carrello</a>
    				<a href="#" onclick="event.preventDefault();" class="link_bottone_rimuovi_index red">Compra</a> -->
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				<%} %>
    				
  				</div>
			</div>
		</div>
			
		<%
			}
		}
	}
	
	%>
	
	</div>
	
	<div class = "card-header my-3">I NOSTRI ORCI</div>
	
	<div class="row g-3">
	
	<% 
	
	products = pd.getAllProducts();
	
	if(!products.isEmpty())
	{
		for(Prodotto p:products)
		{
			if(p.getCategory().equals("orci"))
			{
		%>
			
			<div class="col-12 col-md-6 col-lg-4 gy-3">
			<div class="w-100 carta" style="width: 8rem;">
				<a href="#">
				<%if(p.getStock()!=0){ %>
  				<img class="card-img-top carta_immagine" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  				<%}else{%>
  				<img class="card-img-top carta_immagine bw-image" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  				<%} %>
  					<div class="card-body">
    				<h5 class="card-title"><%= p.getName() %></h5>
    				<h6 class = "price"><b>Prezzo</b> €<%= p.getPrice() %></h6>
    				<h6 class = "category"><b>Categoria:</b> <%= p.getCategory() %></h6>
    				<h6 class = "stock"><b>Stock:</b> <% if(p.getStock()!=0){%> <%= p.getStock()%> <%}else{ %><b><font color="red" >Out of Stock</font></b><%} %></h6>
    				<div class = "mt-3 justify-content -between bordo">
    				<%if(p.getStock()!=0){ %>
    					<a href="add-to-cart?id=<%= p.getId() %>" class="link_bottone_index">Aggiungi al carrello</a>
    					<a href="order-now?quantity=1&id=<%=p.getId()%>" class="link_bottone_rimuovi_index ">Compra</a>
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				<%}else{ %>
    				
    				<p class="card-text"><b><font color="red" >ACQUISTO NON DISPONIBILE</font></b></p>
    				
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				<%} %>
    				
  				</div>
			</div>
		</div>
			
		<%
			}
		}
	}
	
	%>
	
	</div>
	
	
	<div class = "card-header my-3">I NOSTRI CECI</div>
	
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
			<div class="w-100 carta" style="width: 8rem;">
				<a href="#">
				<%if(p.getStock()!=0){ %>
  				<img class="card-img-top carta_immagine" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  				<%}else{%>
  				<img class="card-img-top carta_immagine bw-image" src="product-images/<%= p.getImage() %>" alt="Card image cap"></a>
  				<%} %>
  					<div class="card-body">
    				<h5 class="card-title"><%= p.getName() %></h5>
    				<h6 class = "price"><b>Prezzo</b> €<%= p.getPrice() %></h6>
    				<h6 class = "category"><b>Categoria:</b> <%= p.getCategory() %></h6>
    				<h6 class = "stock"><b>Stock:</b> <% if(p.getStock()!=0){%> <%= p.getStock()%> <%}else{ %><b><font color="red" >Out of Stock</font></b><%} %></h6>
    				<div class = "mt-3 justify-content -between bordo">
    				<%if(p.getStock()!=0){ %>
    					<a href="add-to-cart?id=<%= p.getId() %>" class="link_bottone_index">Aggiungi al carrello</a>
    					<a href="order-now?quantity=1&id=<%=p.getId()%>" class="link_bottone_rimuovi_index ">Compra</a>
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				<%}else{ %>
    				
    				<p class="card-text"><b><font color="red" >ACQUISTO NON DISPONIBILE</font></b></p>
    				
    				
    				</div>
    				<div class = "mt-3 justify-content -between ">
    				<p class="card-text"><%=p.getDescription() %></p>
    				</div>
    				<%} %>
    				
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