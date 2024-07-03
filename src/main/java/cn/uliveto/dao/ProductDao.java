package cn.uliveto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import cn.uliveto.model.*;

public class ProductDao {
		
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public ProductDao(Connection con)
	{
		this.con = con;
	}
	
	public List<Prodotto> getAllProducts()
	{
		List<Prodotto> products = new ArrayList<Prodotto>();
		
		try
		{
			query = "select * from prodotti";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Prodotto row = new Prodotto();
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("nome"));
				row.setCategory(rs.getString("categoria"));
				row.setDescription(rs.getString("descrizione"));
				row.setPrice(rs.getString("prezzo"));
				row.setImage(rs.getString("immagine"));
				
				products.add(row);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return products;
	}
}
