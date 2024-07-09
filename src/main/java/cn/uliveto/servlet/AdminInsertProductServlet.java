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
import cn.uliveto.dao.ProductDao;
import cn.uliveto.dao.UserDao;
import cn.uliveto.model.Utente;

/**
 * Servlet implementation class AdminInsertProductServlet
 */
@WebServlet("/insert-product")
public class AdminInsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset= UTF-8");
		
		try (PrintWriter out = response.getWriter())
		{
			String name = request.getParameter("insert-nome");
			String categoria = request.getParameter("insert-categoria");
			String descrizione = request.getParameter("insert-descrizione");
			int Stock = Integer.parseInt(request.getParameter("insert-stock"));
			String immagine = request.getParameter("insert-immagine");
			int prezzo= Integer.parseInt(request.getParameter("insert-prezzo"));
			
			
			try 
			{
				ProductDao productdao = new ProductDao(DbCon.getConnection());
				
				boolean x = productdao.insertProduct(name,categoria,descrizione,Stock,prezzo,immagine);
				
				
				if(x == true)
				{
					response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
				}
				else
				{
					response.sendRedirect("/uliveto/admin-pages/insert_error.jsp");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}
	}

}
