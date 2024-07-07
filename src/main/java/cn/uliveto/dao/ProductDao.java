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
				row.setStock(rs.getInt("stock"));
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
						row.setStock(rs.getInt("stock"));
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
	
	public boolean CheckQuantity(int Id, int quantity)
	{
		boolean result = false;
		boolean check = false;
		
		try
		{
			query = "select stock from prodotti where id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, Id);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				check = true;
				int Stock_row = rs.getInt("stock");
					
				if(Stock_row != 0)
				{
					if(quantity<=Stock_row)
					{
						result = true;
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(result == false || check ==false)
		{
			return false;
		}
		
		return true;
		
	}
	
	public boolean CheckStock(int Id)
	{
		boolean result = false;
		boolean check = false;
		
		try
		{
			query = "select stock from prodotti where id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, Id);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				check = true;
				int Stock_row = rs.getInt("stock");
					
				if(Stock_row != 0)
				{
					result = true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(result == false || check ==false)
		{
			return false;
		}
		
		return true;
		
	}
	
	public Prodotto getSingleProduct(int id)
	{
		Prodotto row = null;
		
		try {
			
			query = "select * from prodotti where id=?";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				row = new Prodotto();
				
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("nome"));
				row.setCategory(rs.getString("categoria"));
				row.setDescription(rs.getString("descrizione"));
				row.setPrice(rs.getDouble("prezzo"));
				row.setImage(rs.getString("immagine"));
				row.setStock(rs.getInt("stock"));
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return row;
	}
	
	public boolean updateStock(int id, int stock)
	{
		
		try 
		{
			query = "UPDATE prodotti SET stock=? where id=?";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, stock);
			pst.setInt(2, id);
			
		    pst.executeUpdate();
		    
		    return true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public int getStockbyId(int id)
	{
		try {
			
			query = "select * from prodotti where id=?";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				return rs.getInt("stock");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
