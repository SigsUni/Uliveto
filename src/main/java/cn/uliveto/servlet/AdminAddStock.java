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
 * Servlet implementation class AdminAddStock
 */
@WebServlet("/add-stock")
public class AdminAddStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html; charset = UTF-8");
		
		try(PrintWriter out = response.getWriter())
		{
			int id = Integer.parseInt(request.getParameter("id"));
			ProductDao productdao = new ProductDao(DbCon.getConnection());
			
			int stock = productdao.getStockbyId(id);
			productdao.updateStock(id, stock+1);
			
			response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
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
