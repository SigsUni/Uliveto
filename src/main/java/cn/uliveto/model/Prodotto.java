package cn.uliveto.model;

public class Prodotto {
	
		private int id;
		private String name;
		private String category;
		private String description;
		private Double price;
		private String image;
		
		public Prodotto()
		{
			
		}
		
		public Prodotto(int id, String name, String category, String description, Double price,  String image){
			
			this.id = id;
			this.name = name;
			this.category = category;
			this.description = description;
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
			return "Product [id=" + id + ", name=" +name +", category =" +category +", description="+description+", price =" +price+", image="+image+"]";
		}
}
