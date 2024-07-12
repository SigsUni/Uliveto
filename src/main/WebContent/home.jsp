<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import = "cn.uliveto.dao.ProductDao" %>
<%@page import = "cn.uliveto.connection.DbCon" %>
<%@page import ="cn.uliveto.model.*" %>
<%@page import = "java.util.*" %>

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
<title>home</title>
<%@include file = "includes/header.jsp" %>


</head>
<body>

<%@include file = "includes/navbar_nuova.jsp" %>

 <section class="cover elemento">
        <div class="cover_filter"></div>
        <div class="cover_caption">
            <div class="cover_caption_copy">
                    <h1>Welcome to L'Uliveto</h1>
                    
                    
            </div>
        </div>
    </section>




    <section class="cards clearfix">
        <div class="card">
            <img src="img/carosello1.jpg" alt="" class="image">
            <div class="card_copy">
                <h3>Orcio Magnum</h3>
                
            </div>
         
        </div>


        <div class="card">
            <img src="img/carosello2.jpg" alt="" class="image">
            <div class="card_copy">
                <h3>Il Nostro Olio</h3>
                
            </div>
         
        </div>


        <div class="card">
            <img src="img/carosello3.jpg" alt="" class="image">
            <div class="card_copy">
                <h3>Legumi</h3>
                
            </div>
         
        </div>

    </section>

    <section class="banner clearfix">
        <div class="banner_image"></div>
        <div class="banner_copy">
            <div class="banner_copy_txt">
                
                <h4>Scegli la bomboniera perfetta per il tuo evento</h4>
                <p>Gli orci sono realizzati e decorati a mano su tornio, immerso poi in smalto ceramico alimentare certificato. </p>
            </div>
        </div>
    </section>

    <section class="banner clearfix">
        <div class="banner_image float banner_image2"></div>
        <div class="banner_copy float">
            <div class="banner_copy_txt">
                
                <h4 class="right">Il nostro olio extravergine</h4>
                <p class="right">Olio extravergine di oliva ottenuto direttamente dalle olive e unicamente mediante processi meccanici.</p>
            </div>
        </div>
    </section>

    <section class="banner clearfix">
        <div class="banner_image banner_image3"></div>
        <div class="banner_copy">
            <div class="banner_copy_txt">
                
                <h4>I Nostri Ceci</h4>
                <p>La produzione dei ceci include semina, crescita e raccolta con cure colturali per garantire qualità.</p>
            </div>
        </div>
    </section>

   
    
<%@include file = "includes/footer.jsp" %>
    

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $(".header_icon-bar").click(function(e){
                $(".header_menu").toggleClass('is-open');
                e.preventDefault();/*mettiamo questo codice in questo modo dato che la rimozione e l inerimento della classe is open avviene su un link dobbiamo far si che la pagina non venga ricaricata cosi da poter attivare l evento*/
            });
           
        });
    </script>
</body>


</html>

</body>
</html>