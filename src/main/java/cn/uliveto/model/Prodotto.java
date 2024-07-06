package cn.uliveto.model;

public class Prodotto {
	
		private int id;
		private String name;
		private String category;
		private String description;
		private Integer stock;
		private Double price;
		private String image;
		
		public Prodotto()
		{
			
		}
		
		public Prodotto(int id, String name, String category, String description,Integer stock, Double price,  String image){
			
			this.id = id;
			this.name = name;
			this.category = category;
			this.description = description;
			this.stock = stock;
			this.price = price;
			this.image = image;
		}

		public int getId()
		{
			return id;
		}
		
		public String getName()
		{
			return name;
		}
		
		public Double getPrice()
		{
			return price;
		}
		
		public String getCategory()
		{
			return category;
		}
		
		public String getDescription()
		{
			return description;
		}
		
		public Integer getStock()
		{
			return stock;
		}
		
		public String getImage()
		{
			return image;
		}
		
		public void setId(int id)
		{
			this.id = id;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public void setCategory(String category)
		{
			this.category= category;
		}
		
		public void setStock(Integer stock)
		{
			this.stock = stock;
		}
		
		public void setPrice(Double price)
		{
			this.price = price;
		}
		
		public void setDescription(String description)
		{
			this.description = description;
		}
		
		public void setImage(String image)
		{
			this.image = image;
		}
		
		@Override
		public String toString()
		{
			return "Product [id=" + id + ", name=" +name +", category =" +category +", description="+description+", stock="+stock+", price =" +price+", image="+image+"]";
		}
}
