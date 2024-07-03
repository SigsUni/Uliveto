package cn.uliveto.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbCon {

		private static Connection connection = null;
		
		public static Connection getConnection() throws ClassNotFoundException, SQLException
		{
			if(connection == null)
			{
				try 
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/uliveto", "root","Gb162004");
					System.out.print("connected");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}
			return connection;
		}
}
