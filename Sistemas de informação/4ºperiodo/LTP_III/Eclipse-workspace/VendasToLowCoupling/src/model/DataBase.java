package model;

import java.util.HashMap;
import java.util.Map;

import model.Payment.Cash;
import model.Payment.Credit;
import model.Payment.Debit;
import model.Payment.Paymmnet;
import model.stock.StockItem;

public class DataBase {
	private static Map<String, String[]> products = new HashMap();
	
	private static Map<String, Paymmnet> paymmnets = new HashMap<>();
	
	private static Map<String, StockItem> stockItems = new HashMap<>();
	
	static {
		products.put("arroz", new String[] {"Arroz Tipo 1", "20"});
		products.put("feijao", new String[] {"Feijão Malícia", "30"});
		products.put("sal", new String[] {"Sal Marino", "8"});
		
		stockItems.put("arroz", new StockItem(new Product("Arroz tipo 1", 20),5));
		
		Paymmnet credit = new Credit(5);
		
		paymmnets.put("cc", credit);
		paymmnets.put("cd", new Debit(0));
		paymmnets.put("c", new Cash(5));
	}
	
	public static String[] getProductDescription(String key) {
		return products.get(key);
	}
	
	public static Paymmnet getPaymmnet(String key) {
		return paymmnets.get(key);
	}
}
