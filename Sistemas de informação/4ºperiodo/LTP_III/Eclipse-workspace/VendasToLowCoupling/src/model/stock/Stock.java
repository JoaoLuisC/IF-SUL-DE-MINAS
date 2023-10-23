package model.stock;

import java.util.List;

import model.DataBase;

public class Stock {

	private List<StockItem> items;
	

	public Stock(List<StockItem> items) {
		//vamos esperar do banco de dados
		items = DataBase.stockItems();
	}
	
	
	
	
	
	

	
	
	
	
}
