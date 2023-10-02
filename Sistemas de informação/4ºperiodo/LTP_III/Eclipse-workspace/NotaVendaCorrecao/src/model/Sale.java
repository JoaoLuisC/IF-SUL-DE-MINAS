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

	public List<SaleItem> getSaleItem() {
		return this.items;
	}

	public void addSaleItem(SaleItem item) {
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
