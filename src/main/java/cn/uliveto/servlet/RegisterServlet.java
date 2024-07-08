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
import cn.uliveto.dao.UserDao;
import cn.uliveto.model.Utente;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/user-register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("register.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
response.setContentType("text/html; charset= UTF-8");
		
		try (PrintWriter out = response.getWriter())
		{
			String name = request.getParameter("login-name");
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			
			try {
				UserDao udao = new UserDao(DbCon.getConnection());
				boolean x = udao.UserCheck(email);
				
				if(x)
				{
					response.sendRedirect("registration_failure.jsp");
				}
				else
				{
					boolean y = udao.userRegistration(name,email,password);
					
					if(y)
					{
						response.sendRedirect("registration_success.jsp");
					}
					else
					{
						response.sendRedirect("registration_failure.jsp");
					}
				}
			
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
		
		}
	}}


