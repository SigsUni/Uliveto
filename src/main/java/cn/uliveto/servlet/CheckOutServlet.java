package cn.uliveto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.uliveto.connection.DbCon;
import cn.uliveto.dao.OrderDao;
import cn.uliveto.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CheckOutServlet
 */
@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter())
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			//prende tutti i prodotti dal carrello
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			
			//autenticazione utente
			Utente auth = (Utente) request.getSession().getAttribute("auth");
			
			//checkout e cart-list
			
			
			if(cart_list!=null && auth!=null)
			{
				for(Cart c:cart_list)
				{
					Ordine order = new Ordine();
					
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					
					OrderDao oDao = new OrderDao(DbCon.getConnection());
					
					boolean result = oDao.insertOrder(order);
					
					if(!result)
					{
						break;
					}
					
					
				}
				
				cart_list.clear();
				response.sendRedirect("orders.jsp");
				
			}
			else
			{
				if(auth ==null)
				{
					response.sendRedirect("login.jsp");
				}
				response.sendRedirect("cart.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
