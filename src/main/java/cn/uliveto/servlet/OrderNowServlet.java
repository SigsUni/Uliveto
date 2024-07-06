package cn.uliveto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import cn.uliveto.connection.*;
import cn.uliveto.dao.*;
import cn.uliveto.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderNowServlet
 */
@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter())
		{
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			
			Utente auth = (Utente)request.getSession().getAttribute("auth");
			
			if(auth!=null)
			{
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				
				ProductDao productdao = new ProductDao(DbCon.getConnection());
				boolean r= productdao.CheckQuantity(Integer.parseInt(productId),productQuantity);
				
				if(r == false)
				{
					response.sendRedirect("index.jsp");
				}
				else
				{
				
					if(productQuantity<=0)
					{
						productQuantity = 1;
					}
				
					Ordine orderModel = new Ordine();
					orderModel.setId(Integer.parseInt(productId));
					orderModel.setUid(auth.getId());
					orderModel.setQuantity(productQuantity);
					orderModel.setDate(formatter.format(date));
				
					OrderDao orderdao = new OrderDao(DbCon.getConnection());
					boolean result = orderdao.insertOrder(orderModel);
				
					if(result)
					{
						ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					
						if(cart_list !=null)
						{
							for(Cart c:cart_list)
							{
								if(c.getId() == Integer.parseInt(productId))
								{
									cart_list.remove(cart_list.indexOf(c));
									break;
								}
							}
						}
					
						response.sendRedirect("orders.jsp");
					}
					else
					{
						out.print("ordine fallito");
					}
				
				}
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
