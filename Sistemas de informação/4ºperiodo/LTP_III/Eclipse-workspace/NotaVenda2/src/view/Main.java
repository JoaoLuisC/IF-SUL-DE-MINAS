package view;

import model.Sale;

public class Main {

	public static void main(String[] args) {
		
		Sale sale = new Sale();
		sale.addItem("arroz",3);
		sale.addItem("feijao",9);
		sale.addItem("sal",9);
		
		System.out.println(String.format("Venda - #1234 - %s", sale.getDate().toLocaleString()));
		
		for (String si : sale.getSaleItem()) {
			System.out.println(si);
		}
		
		System.out.println(String.format("Total: R$%.2f", sale.getTotal()));
	}

}
