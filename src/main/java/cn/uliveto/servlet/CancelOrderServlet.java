package cn.uliveto.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uliveto.connection.DbCon;
import cn.uliveto.dao.OrderDao;
import cn.uliveto.dao.ProductDao;

/**
 * Servlet implementation class CancelOrderServlet
 */
@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out= response.getWriter())
		{
			String id = request.getParameter("id");
			if(id!=null)
			{
				OrderDao orderDao = new OrderDao(DbCon.getConnection());
				ProductDao productdao = new ProductDao(DbCon.getConnection());
				
				int id_prodotto = orderDao.getIdprodotto(Integer.parseInt(id));
				int quantity = orderDao.getQuantity(Integer.parseInt(id));
				if(id_prodotto == 0)
				{
					response.sendRedirect("index.jsp");
				}
				else
				{
					int stock_iniziale = productdao.getStockbyId(id_prodotto);
					stock_iniziale = stock_iniziale + quantity;
					
					
					productdao.updateStock(id_prodotto, stock_iniziale);
					orderDao.cancelOrder(Integer.parseInt(id));
					
				}		
			}
			response.sendRedirect("orders.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
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
