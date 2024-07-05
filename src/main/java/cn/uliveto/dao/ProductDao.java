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
				row.setPrice(rs.getDouble("prezzo"));
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
	
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList)
	{
		List<Cart> products = new ArrayList<Cart>();
		
		try {
			
			if(cartList.size()>0)
			{
				for(Cart item:cartList)
				{
					query = "select * from prodotti where id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1,item.getId());
					rs = pst.executeQuery();
					
					while(rs.next())
					{
						Cart row = new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("nome"));
						row.setCategory(rs.getString("categoria"));
						row.setDescription(rs.getString("descrizione"));
						row.setPrice(rs.getDouble("prezzo")*item.getQuantity());
						row.setImage(rs.getString("immagine"));
						row.setQuantity(item.getQuantity());
						
						products.add(row);
					}
					
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return products;
		
	}
	
	public double getTotalCartPrice(ArrayList<Cart> cartList)
	{
		double sum = 0;
		
		try {
			if(cartList.size() >0)
			{
				for(Cart item:cartList)
				{
					query = "select prezzo from prodotti where id=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					
					while(rs.next())
					{
						sum+= rs.getDouble("prezzo")*item.getQuantity();
					}
				}
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return sum;
	}
}
