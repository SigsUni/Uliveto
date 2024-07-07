package cn.uliveto.servlet;
import cn.uliveto.dao.UserDao;
import cn.uliveto.connection.DbCon;
import cn.uliveto.model.Utente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("login.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html; charset= UTF-8");
		
		try (PrintWriter out = response.getWriter())
		{
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			
			try {
				UserDao udao = new UserDao(DbCon.getConnection());
				Utente user = udao.userLogin(email,password);
				
				
				if(user!=null)
				{
					out.print("user login");
					request.getSession().setAttribute("auth",user);
					
					if(user.getId() == 2)
					{
						response.sendRedirect("/uliveto/admin-pages/admin_index.jsp");
					}
					else
					{
						response.sendRedirect("index.jsp");
					}
					
				}
				else
				{
					response.sendRedirect("login_failure.jsp");
				}
				
			}
			catch(ClassNotFoundException | SQLException e)
			{
				e.printStackTrace();
			}
			
			
		}
		
	}

}
