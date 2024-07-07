package cn.uliveto.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.uliveto.model.Utente;

public class UserDao {

		private Connection con;
		private String query;
		private PreparedStatement pst;
		private ResultSet rs;
		
		public UserDao(Connection con)
		{
			this.con = con;
		}
		
		public Utente userLogin(String email, String password)
		{
			Utente user = null;
			
			try
			{
				query = "select * from utenti where email=? && password=?;";
				
				pst = this.con.prepareStatement(query);
				pst.setString(1,email);
				pst.setString(2, password);
				rs = pst.executeQuery();
				
				if(rs.next())
				{
					user = new Utente();
					user.setId(rs.getInt("id"));
					user.setNome(rs.getString("nome"));
					user.setEmail(rs.getString("email"));
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
			
			return user;
		}
		
		public boolean UserCheck(String email)
		{
			try
			{
				query = "select * from utenti where email=?";
				
				pst = this.con.prepareStatement(query);
				pst.setString(1,email);
				rs = pst.executeQuery();
				
				if(rs.next())
				{
					if(rs.getString("email").equals(email))
					{
							return true;
					}
				}
				return false;
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
			return false;
		}
		
		
		
		public boolean userRegistration(String name, String email, String password)
		{
			try
			{
				query = "insert into utenti (nome, email, password) VALUES (?,?,?)";
					
				pst = this.con.prepareStatement(query);
				pst.setString(1,name);
				pst.setString(2,email);
				pst.setString(3,password);
				pst.executeUpdate();
				return true;
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.print(e.getMessage());
			}
			
			return false;
		}
		
		
}
