package cn.uliveto.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.uliveto.connection.DbCon;
import cn.uliveto.dao.ProductDao;

/**
 * Servlet implementation class AdminDeleteStock
 */
@WebServlet("/delete-stock")
public class AdminDeleteStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset = UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			int id = Integer.parseInt(request.getParameter("id"));
			int stock_input = Integer.parseInt(request.getParameter("stock_remove"));
			ProductDao productdao = new ProductDao(DbCon.getConnection());
			
			int stock = productdao.getStockbyId(id);
			if((stock - stock_input) <0)
			{
				response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
			}
			else
			{
				productdao.updateStock(id, stock-stock_input);
			
				response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
			}
		}
		catch(Exception e)
		{
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
