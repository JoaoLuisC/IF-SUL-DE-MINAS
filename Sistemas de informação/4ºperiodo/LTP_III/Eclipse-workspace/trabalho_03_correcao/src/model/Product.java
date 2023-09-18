package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double costPrice;
	private double profit;
	private List<Tax> taxes;
	private boolean foreing;
	private boolean industrial;

	public Product(String name, double costPrice, double profit) throws Exception {
		foreing = false;
		setName(name);
		setCostPrice(costPrice);
		setProfit(profit);
		this.taxes = new ArrayList<>();
	}
	
	
	//SETTERS
	public void setIndustrial(boolean industrial) {
		this.industrial = industrial;
	}
	
	public void setIsForeing(boolean foreing) {
		this.foreing = foreing;
	}
	
	private void setProfit(double profit) throws Exception {

		if (profit <= 0)
			throw new Exception("Margem está Inválida!");

		this.profit = profit / 100;
	}

	private void setCostPrice(double costPrice) throws Exception {

		if (costPrice <= 0)
			throw new Exception("Preço de custo está inválido!");

		this.costPrice = costPrice;
	}

	private void setName(String name) throws Exception {

		if (name == null || name.equals(""))
			throw new Exception("Nome Inválido!");

		this.name = name;
	}
	
	public boolean addTax(Tax tax) throws Exception {

		if (tax == null)
			throw new Exception("Imposto não pode ser nulo.");

		if (taxes.contains(tax))
			return false;
		else {
			tax.defineAliquot(this);
			taxes.add(tax);
		}
			

		return true;
	}
	
	//GETTERS
	
	public boolean isIndustrial() {
		return this.industrial;
	}
	
	
	public boolean isForeing() {
		return foreing;
	}
	
	public String getName() {
		return name;
	}

	public double getCostPrice() {
		return costPrice;
	}
	
	protected double getProfit() {
		return this.profit;
	}
	
	//METODOS

	public double calculateSalePrice() {
		double taxesSum = 0;

		for (Tax tax : taxes) {
			taxesSum += tax.calculate(this);
		}

		double finalCost = this.costPrice + taxesSum;
		double finalPrice = finalCost + (finalCost * profit);

		return finalPrice;

	}
	
	
	

	

	
}