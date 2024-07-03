package cn.uliveto.model;

public class  Utente{

		private int id;
		private String nome;
		private String email;
		private String password;
		
		
		public Utente()
		{
			
		}
		
		public Utente(int id, String nome, String email, String password)
		{
			
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.password = password;
		}
		
		public int getId()
		{
			return id;
		}
		
		public String getNome()
		{
			return nome;
		}
		
		public String getEmail()
		{
			return email;
		}
		
		public String getPassword()
		{
			return password;
		}
		
		public void setId(int id)
		{
			this.id = id;
		}
		
		public void setNome(String nome)
		{
			this.nome = nome;
		}
		
		public void setEmail(String email)
		{
			this.email = email;
		}
		
		public void setPassword(String password)
		{
			this.password = password;
		}
		
	
}

