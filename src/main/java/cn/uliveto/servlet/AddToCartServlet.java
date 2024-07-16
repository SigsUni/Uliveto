package cn.uliveto.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.uliveto.connection.DbCon;
import cn.uliveto.dao.ProductDao;
import cn.uliveto.model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html; charset = UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			ArrayList<Cart> cartList = new ArrayList<>();
			
			int id = Integer.parseInt(request.getParameter("id"));
			ProductDao productdao = new ProductDao(DbCon.getConnection());
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);
			
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list= (ArrayList<Cart>) session.getAttribute("cart-list");
			
			boolean check;
			check = productdao.CheckStock(id);
			
			if(!check)
			{
				response.sendRedirect("index.jsp");
			}
			else
			{
				
				if(cart_list ==null)
				{
					cartList.add(cm);
					session.setAttribute("cart-list", cartList);
					response.sendRedirect("index.jsp");
					
				}
				else
				{
					cartList = cart_list;
					
					boolean exist = false;
				
					for(Cart c:cartList)
					{
						if(c.getId() == id)
						{
							exist = true;
							//out.println("<h3 style='color:crimson; text-align:center'> Oggetto già presente nel carrello <a href = 'cart.jsp'> Go to cart page </a>");
							response.sendRedirect("error_cart.jsp");
							
						}
					}
				
					if(!exist)
					{
						cartList.add(cm);
						response.sendRedirect("index.jsp");
					}
				}
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
