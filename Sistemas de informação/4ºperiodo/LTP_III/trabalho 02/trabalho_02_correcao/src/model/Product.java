package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private String name;
	private double costPrice;
	private double profit;
	private List<Tax> taxes;
	
	public Product(String name, double costPrice, double profit) throws Exception {
		setName(name);
		setcostPrice(costPrice);
		setProfit(profit);
		this.taxes = new ArrayList<Tax>();
	}
	
	public boolean addTax(Tax tax) throws Exception {
		
		if(tax == null)
			throw new Exception("Imposto não pode ser nulo!");
		
		if(taxes.contains(tax)) {
			System.out.println("Imposto já inserido!");
			return false;
		}else
			taxes.add(tax);
		
		return true;
	}

	private void setProfit(double profit) throws Exception {
		
		if(profit<=0)
			throw new Exception("Margem está inválida!");
		
		this.profit = profit/100;
		
	}

	private void setcostPrice(double costPrice) throws Exception {

		if(costPrice<0)
			throw new Exception("Preço de custo inválido!");
		
		this.costPrice = costPrice;
		
	}


	private void setName(String name) throws Exception {
		
		if(name == null || !name.equals(""))
			throw new Exception("Nome inválido!");

		this.name = name;
			
	}
	
	
	
	
	
	
}
