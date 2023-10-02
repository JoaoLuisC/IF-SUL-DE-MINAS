package model;

public class Product {
	private String name;
	private double salePrice;
	private int stock;
	
	//CONSTRUTOR	
	
	public Product(String name , double salePrice, int stock) throws Exception {
		setName(name);
		setSalePrice(salePrice);
		setStock(stock);
	}
	
	//Metodos
	
	protected static boolean stockValidate(Product prod, int amount) throws Exception {
		if (prod.stock >= amount)
			return true;
		else if (prod.stock <= 0)
			throw new Exception("Sem estoque!");
		else
			throw new Exception("Quantidade de " + prod.getName() + " Indísponível!");
	}
	
	//GETTERS
	
	private void setStock(int stock) throws Exception {
		if(stock <= 0)
			throw new Exception("Quantida de estoque invalida");
		else
			this.stock = stock;
	}
	
	private void setName(String name)throws Exception{
		if(name == "" || name == null)
			throw new Exception("Nome invalido");
		else
			this.name = name;
	}
	
	private void setSalePrice(double salePrice) throws Exception{
		if(salePrice <= 0)
			throw new Exception ("Valor invalido");
		else
			this.salePrice = salePrice;
	}
	
	//SETTERS
	
	public String getName() {
		return this.name;
	}
	public Double getSalePrice() {
		return this.salePrice;
	}
	public int getStock() {
		return this.stock;
	}
	
	
	
	
	
}
