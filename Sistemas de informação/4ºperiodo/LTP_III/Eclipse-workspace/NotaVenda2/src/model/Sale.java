package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Sale {

	private Date date;
	private List<SaleItem> items;

	public Sale() {
		this.date = Calendar.getInstance().getTime();
		this.items = new ArrayList<>();
		
	}

	public Date getDate() {
		return this.date;
	}

	public List<String> getSaleItem() {
		List<String> saleItemString = new ArrayList<>();
		
		for (SaleItem si : this.items) {
			String item = String.format("%s - %d - R$%.2f - R$%.2f", si.getProduct().getDescription(),
					si.getAmount(),si.getProduct().getPrice(), si.getSaleItemSubTotal());
			
			saleItemString.add(item);
			
		}
		
		return saleItemString;
	}

	public void addItem(String codProduct , int amount) {
		
		SaleItem item = new SaleItem(codProduct, amount);
		this.items.add(item);
	}

	public double getTotal() {
		double total = 0.0;

		for (SaleItem saleItem : items) {
			total += saleItem.getSaleItemSubTotal();
		}

		return total;

	}
	

}
