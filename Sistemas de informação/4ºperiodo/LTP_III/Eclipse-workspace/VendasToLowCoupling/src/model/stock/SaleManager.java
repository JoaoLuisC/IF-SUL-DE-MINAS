package model.stock;

import model.sale.Sale;

public class SaleManager {

	private Stock stock;
	private Sale sale;
	
	public SaleManager() {
		stock = new Stock();
		sale = null;
	}
	
	public void openSale() {
		sale = new Sale();
	}
	
	public void closeSale()
	{
		sale = null;
	}
	
	public boolean isOpen() {
		return sale!= null;
	}
	
	private boolean verifyStock(){
		
	}

}
