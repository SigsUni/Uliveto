package cn.uliveto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import cn.uliveto.model.*;

public class OrderDao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con)
	{
		this.con = con;
	}
	
	public boolean insertOrder(Ordine model)
	{
		boolean result = false;
		
		try {
			
			query = "insert into ordini (p_id,u_id,o_quantity,o_date) values(?,?,?,?)";
			
			pst= this.con.prepareStatement(query);
			pst.setInt(1,model.getId());
			pst.setInt(2,model.getUid());
			pst.setInt(3,model.getQuantity());
			pst.setString(4,model.getDate());
			pst.executeUpdate();
			result = true;
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
	public List<Ordine> userOrders(int id)
	{
		List<Ordine> list = new ArrayList <>();
		
		try
		{
			query = "select * from ordini where u_id=? order by ordini.o_id desc";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Ordine order = new Ordine();
				
				ProductDao productdao = new ProductDao(this.con);
				
				int pId = rs.getInt("p_id");
				
				Prodotto product = productdao.getSingleProduct(pId);
				order.setOrderId(rs.getInt("o_id"));
				order.setId(pId);
				order.setName(product.getName());
				order.setCategory(product.getCategory());
				order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public void cancelOrder(int id)
	{
		try {
			
			query = "delete from ordini where o_id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			pst.execute();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int getIdprodotto(int id)
	{
		try
		{
			query = "select * from ordini where o_id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				return rs.getInt("p_id");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getQuantity(int id)
	{
		try
		{
			query = "select * from ordini where o_id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				return rs.getInt("o_quantity");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}
