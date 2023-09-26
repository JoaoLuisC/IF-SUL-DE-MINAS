package model;

public class Product {
	private String name;
	private double costPrice;
	private int amount;
	
	public Product(String name , double costPrice, int amount) throws Exception {
		setName(name);
		setCostPrice(costPrice);
		setAmount(amount);
	}
	
	private void setAmount(int amount) throws Exception {
		if(amount <= 0)
			throw new Exception("Quantida de estoque invalida");
		else
			this.amount = amount;
	}
	
	private void setName(String name)throws Exception{
		if(name == "" || name == null)
			throw new Exception("Nome invalido");
		else
			this.name = name;
	}
	
	private void setCostPrice(double costPrice) throws Exception{
		if(costPrice <= 0)
			throw new Exception ("Valor invalido");
		else
			this.costPrice = costPrice;
	}
	
	private String getName() {
		return this.name;
	}
	private Double getCostPrice() {
		return this.costPrice;
	}
	private int getAmount() {
		return this.amount;
	}
	
	
	
	
	
}
