package cn.uliveto.model;

public class Ordine extends Prodotto{
	
		private int orderId;
		private int uid;
		private int quantity;
		private String date;
		private String user_name;
		
		
		
		public Ordine()
		{
			
		}
		
		public Ordine(int orderId, int uid, int quantity, String date)
		{
			this.orderId = orderId;
			this.uid = uid;
			this.quantity = quantity;
			this.date = date;
		}
		
		public void setOrderId(int orderId)
		{
			this.orderId = orderId;
		}
		
		public void setUid(int uid)
		{
			this.uid = uid;
		}
		
		public void setQuantity(int quantity)
		{
			this.quantity = quantity;
		}
		
		public void setDate(String date)
		{
			this.date = date;
		}
		
		public void setUsername(String name)
		{
			this.user_name = name;
		}
		
		public int getOrderId()
		{
			return orderId;
		}
		
		public int getUid()
		{
			return uid;
		}
		
		public int getQuantity()
		{
			return quantity;
		}
		
		public String getDate()
		{
			return date;
		}
		
		public String getUsername()
		{
			return user_name;
		}
		
		
}
