<nav class="navbar navbar-expand-lg navbar-light bg-light">

<div class= "container">




  <a class="navbar-brand" href="index.jsp">ADMIN PAGE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cart.jsp">Carrello<span class="badge badge-danger px-1">${cart_list.size() }</span></a>
      </li>
      	<% if(auth !=null)
      	{%>
      	
      		<li class="nav-item">
        	<a class="nav-link disabled" href="orders.jsp">Ordini</a>
      		</li>
      			
      		<li class="nav-item">
            <a class="nav-link" href="log-out">EXIT-ADMIN-MODE</a>
            </li>
      	<% }%>
    </ul>
  </div>
  </div>
</nav>