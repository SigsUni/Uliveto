 <a href="" class=" face "></a>
    <a href="" class="insta"></a>
    <header class="header clearfix">

        
        <a href="" class="header_logo"></a>



        <a href="" class="header_icon-bar">
            <span></span>
            <span></span>
            <span></span>

        </a>


        <ul class="header_menu animate">



            <li class="header_menu_item"><a href="home.jsp">Home</a></li>
            <li class="header_menu_item"><a target="_blank" href="https://www.google.com/maps/place/L'Uliveto+Azienda+Agricola+Trentinara/@40.4006209,15.1075769,15z/data=!4m6!3m5!1s0x133957af04b89b47:0xb0c762598c63ecf!8m2!3d40.3995352!4d15.1151114!16s%2Fg%2F11ns1f867d?hl=it&entry=ttu">Dove ci Trovi</a></li>

            <li class="header_menu_item"><a href="index.jsp">Negozio</a></li>
			
			<% if(auth !=null)
      		{%>
      	
      		<li class="header_menu_item"><a href="cart.jsp">Carrello<span class="badge badge-danger px-1">${cart_list.size() }</span></a>
      		
        	<li class="header_menu_item"><a href="orders.jsp">Ordini</a></li>
      			
 
            <li class="header_menu_item"><a href="log-out">Logout</a></li>
      	<% }
      	else
      	{%>
      		<li class="header_menu_item"><a href="login.jsp">Login</a></li>
      	<%}%>
            

        </ul>
        
</header>