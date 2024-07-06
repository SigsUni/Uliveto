package cn.uliveto.model;

public class Cart extends Prodotto{

	private int quantity;
	private int stock_cart;
	
	
	public Cart()
	{
		
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public int getStock_cart()
	{
		return stock_cart;
	}
	
	public void setStock_cart(int stock)
	{
		this.stock_cart = stock;
	}
	
	
}
