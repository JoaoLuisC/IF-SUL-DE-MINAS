package model.stock;

import model.Product;

public class StockItem {
	
	private Product product;
	private double amount;

	public StockItem(double amount, Product product) {
		this.product = product;
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
